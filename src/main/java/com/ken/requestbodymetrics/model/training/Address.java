package com.ken.requestbodymetrics.model.training;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String city;
    private int zip;
    private String street;
    private int number;
}
