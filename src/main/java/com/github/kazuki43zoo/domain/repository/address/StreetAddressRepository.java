package com.github.kazuki43zoo.domain.repository.address;

import com.github.kazuki43zoo.domain.model.StreetAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StreetAddressRepository {

    long countByCriteria(
            @Param("criteria") StreetAddressSearchCriteria criteria);

    List<StreetAddress> findPageByCriteria(
            @Param("criteria") StreetAddressSearchCriteria criteria,
            @Param("pageable") Pageable pageable);

}
