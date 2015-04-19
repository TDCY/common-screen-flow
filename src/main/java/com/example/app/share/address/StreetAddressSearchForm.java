package com.example.app.share.address;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@lombok.Data
public class StreetAddressSearchForm implements Serializable {
    private static final long serialVersionUID = 1L;
    private String zipCode;
    private String address;
    @Min(0)
    @Max(200)
    private Integer size;
}
