package com.example.app.share;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

@Component
public class SharedFlowHelper {
    @Inject
    Mapper beanMapper;

    public String gotoStreetAddressSearch(
            RedirectAttributes redirectAttributes,
            SharedFlowPaths sharedFlowPaths) {
        takeOverSharedFlowPaths(redirectAttributes, sharedFlowPaths);
        return "redirect:/share/streetAddresses?searchForm";
    }

    private void takeOverSharedFlowPaths(
            RedirectAttributes redirectAttributes,
            SharedFlowPaths sharedFlowPaths) {
        if (sharedFlowPaths == null) {
            return;
        }
        redirectAttributes.addFlashAttribute(SharedFlowPaths.MODEL_NAME, beanMapper.map(sharedFlowPaths, sharedFlowPaths.getClass()));
    }

}
