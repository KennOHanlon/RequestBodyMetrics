package com.ken.requestbodymetrics.model.training;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("inspections")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inspections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private String key;

    private Address address;

    @JsonProperty("business_name")
    private String businessName;

    @JsonProperty("certificate_number")
    private int certificateNumber;

    private String date;

    private String id;

    private String result;

    private String sector;
}
