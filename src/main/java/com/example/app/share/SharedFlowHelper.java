package com.example.app.share;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.Map;

@Component
public class SharedFlowHelper {

    @Inject
    Mapper beanMapper;

    public String gotoStreetAddressSearch(
            RedirectAttributes redirectAttributes,
            SharedFlowPaths sharedFlowPaths) {
        takeOverSharedFlowPathsIntoQueryString(redirectAttributes, sharedFlowPaths);
        return "redirect:/share/streetAddresses?searchForm";
    }

    public SharedFlowPaths constructSharedFlowPaths(SharedFlowPaths requestedSharedFlowPaths) {
        if (requestedSharedFlowPaths == null || requestedSharedFlowPaths.isEmpty()) {
            return null;
        }
        requestedSharedFlowPaths.validatePaths();
        requestedSharedFlowPaths.finalizePaths();
        return requestedSharedFlowPaths;
    }

    @SuppressWarnings("unchecked")
    Map<String, String> toAttributes(SharedFlowPaths sharedFlowPaths) {
        // For mapping roles, please refer to classpath:/META-INF/dozer/sharedScreenFlow-mapping.xml
        return beanMapper.map(sharedFlowPaths, Map.class);
    }

    private void takeOverSharedFlowPathsIntoQueryString(
            RedirectAttributes redirectAttributes,
            SharedFlowPaths sharedFlowPaths) {
        if (sharedFlowPaths == null) {
            return;
        }
        redirectAttributes.addAllAttributes(toAttributes(sharedFlowPaths));
    }

}
