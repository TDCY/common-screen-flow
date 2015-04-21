package com.example.app.share.address;

import com.example.app.share.DefaultSharedFlowPaths;
import com.example.app.share.SharedFlowController;
import com.example.app.share.SharedFlowHelper;
import com.example.app.share.SharedFlowPaths;
import com.example.domain.model.StreetAddress;
import com.example.domain.repository.address.StreetAddressSearchCriteria;
import com.example.domain.service.address.StreetAddressService;
import org.dozer.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@RequestMapping("share/streetAddresses")
@SharedFlowController
public class StreetAddressSearchController {

    @Inject
    StreetAddressService streetAddressService;

    @Inject
    SharedFlowHelper sharedFlowHelper;

    @Inject
    Mapper beanMapper;

    @ModelAttribute
    public StreetAddressSearchForm setupSearchForm() {
        return new StreetAddressSearchForm();
    }

    @RequestMapping(method = RequestMethod.GET, params = "searchForm")
    public String searchForm() {
        return "share/streetAddress/searchForm";
    }

    @RequestMapping(method = RequestMethod.GET, params = "searchRedo")
    public String searchRedo(StreetAddressSearchForm form) {
        return searchForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String search(
            @Validated StreetAddressSearchForm form,
            BindingResult bindingResult,
            Pageable pageable,
            Model model) {
        if (bindingResult.hasErrors()) {
            return searchForm();
        }
        StreetAddressSearchCriteria criteria = beanMapper.map(form, StreetAddressSearchCriteria.class);
        Page<StreetAddress> page = streetAddressService.search(criteria, pageable);
        model.addAttribute("page", page);
        return "share/streetAddress/searchResult";
    }

}
