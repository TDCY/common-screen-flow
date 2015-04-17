package com.github.kazuki43zoo.app.common.address;

import com.github.kazuki43zoo.domain.model.Address;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("commonFlow/address")
@Controller
public class AddressSearchController {

    @ModelAttribute
    public AddressSearchForm setupAddressSearchForm() {
        return new AddressSearchForm();
    }

    @RequestMapping(method = RequestMethod.GET, params = "searchForm")
    public String searchForm() {
        return "commonFlow/address/searchForm";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String search(@Validated AddressSearchForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return searchForm();
        }
        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address("1710051", "東京都豊島区長崎"));
        model.addAttribute("addresses", addresses);
        return "commonFlow/address/searchResult";
    }

}
