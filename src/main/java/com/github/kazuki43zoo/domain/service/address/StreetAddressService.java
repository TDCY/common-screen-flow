package com.github.kazuki43zoo.domain.service.address;

import com.github.kazuki43zoo.domain.model.StreetAddress;
import com.github.kazuki43zoo.domain.repository.address.StreetAddressSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StreetAddressService {
    Page<StreetAddress> search(StreetAddressSearchCriteria criteria, Pageable pageable);
}
