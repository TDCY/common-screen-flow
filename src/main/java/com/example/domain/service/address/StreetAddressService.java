package com.example.domain.service.address;

import com.example.domain.model.StreetAddress;
import com.example.domain.repository.address.StreetAddressSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StreetAddressService {
    Page<StreetAddress> search(StreetAddressSearchCriteria criteria, Pageable pageable);
}
