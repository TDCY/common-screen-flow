package com.example.domain.repository.address;

import java.io.Serializable;

@lombok.Data
public class StreetAddressSearchCriteria implements Serializable {
    private static final long serialVersionUID = 1L;
    private String zipCode;
    private String address;
}
