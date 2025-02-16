package com.ken.requestbodymetrics.service;

import com.ken.requestbodymetrics.model.training.Address;
import com.ken.requestbodymetrics.model.training.Inspections;
import com.ken.requestbodymetrics.repository.InspectionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InspectionsService {

    private final InspectionsRepository inspectionsRepository;

    public InspectionsService(InspectionsRepository inspectionsRepository) {
        this.inspectionsRepository = inspectionsRepository;
    }

    public Optional<Inspections> getInspectionById(String id) {
        return inspectionsRepository.findById(id);
    }

    public List<Inspections> retrieveInspectionsByBusinessNameAndAddress(String businessName, Address address) {
        return inspectionsRepository.findByBusinessNameAndAddress(businessName, address);
    }

    public Inspections insertInspectionRecord(Inspections inspection) {
        return inspectionsRepository.save(inspection);
    }
}