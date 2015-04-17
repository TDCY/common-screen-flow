package com.github.kazuki43zoo.domain.service.address;

import com.github.kazuki43zoo.domain.model.StreetAddress;
import com.github.kazuki43zoo.domain.repository.address.StreetAddressSearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StreetAddressServiceImpl implements StreetAddressService {

    public Page<StreetAddress> search(StreetAddressSearchCriteria criteria, Pageable pageable) {
        List<StreetAddress> addresses = new ArrayList<>();
        addresses.add(new StreetAddress("1700014", "東京都豊島区池袋（１丁目）"));
        addresses.add(new StreetAddress("1710014", "東京都豊島区池袋（２～４丁目）"));
        addresses.add(new StreetAddress("1700011", "東京都豊島区池袋本町"));
        addresses.add(new StreetAddress("1710043", "東京都豊島区要町"));
        addresses.add(new StreetAddress("1700012", "東京都豊島区上池袋"));
        addresses.add(new StreetAddress("1700004", "東京都豊島区北大塚"));
        addresses.add(new StreetAddress("1700003", "東京都豊島区駒込"));
        return new PageImpl<StreetAddress>(addresses, pageable, addresses.size());
    }

}
