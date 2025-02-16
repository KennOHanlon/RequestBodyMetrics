package com.ken.requestbodymetrics.controller;

import com.ken.requestbodymetrics.model.training.Address;
import com.ken.requestbodymetrics.model.training.Inspections;
import com.ken.requestbodymetrics.service.InspectionsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    private final InspectionsService inspectionsService;

    public TrainingController(InspectionsService inspectionsService) {
        this.inspectionsService = inspectionsService;
    }

    // GET endpoint to retrieve training by ID
    @GetMapping("/{id}")
    public ResponseEntity<Inspections> getInspectionById(@PathVariable String id) {
        Optional<Inspections> inspection = inspectionsService.getInspectionById(id);
        return inspection.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // GET endpoint to retrieve training by name and address
    @PostMapping
    public ResponseEntity<List<Inspections>> getInspectionsByNameAndAddress(
            @RequestParam String businessName,
            @RequestBody Address address) {
        List<Inspections> inspections = inspectionsService.retrieveInspectionsByBusinessNameAndAddress(businessName, address);
        if (inspections.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(inspections);
    }

    // POST endpoint to insert a new training record
    @PostMapping
    public ResponseEntity<Inspections> createTraining(@RequestBody Inspections inspection) {
        Inspections savedInspection = inspectionsService.insertInspectionRecord(inspection);
        return ResponseEntity.ok(savedInspection);
    }
}
