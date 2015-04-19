package com.example.domain.model;

import java.io.Serializable;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class StreetAddress implements Serializable {
    private static final long serialVersionUID = 1L;
    private String zipCode;
    private String address;
    private String addressKana;
}
