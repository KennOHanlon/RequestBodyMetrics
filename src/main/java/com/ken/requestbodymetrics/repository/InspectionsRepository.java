package com.ken.requestbodymetrics.repository;

import com.ken.requestbodymetrics.model.training.Address;
import com.ken.requestbodymetrics.model.training.Inspections;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InspectionsRepository extends MongoRepository<Inspections, String> {
    List<Inspections> findByBusinessNameAndAddress(String businessName, Address address);
}
