package com.github.kazuki43zoo.app.share;

import org.dozer.Mapper;
import org.springframework.security.web.firewall.RequestRejectedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class SharedFlowHelper {

    private static final Pattern ALLOWED_PATH_PATTERN = Pattern.compile("^/$|^/[a-zA-Z].*");

    @Inject
    Mapper beanMapper;

    public String gotoStreetAddressSearch(
            RedirectAttributes redirectAttributes,
            SharedFlowPaths sharedFlowPaths) {
        takeOverSharedFlowPathsIntoQueryString(redirectAttributes, sharedFlowPaths);
        return "redirect:/share/streetAddresses?searchForm";
    }

    @SuppressWarnings("unchecked")
    Map<String, String> toAttributes(SharedFlowPaths sharedFlowPaths) {
        // For mapping roles, please refer to classpath:/META-INF/dozer/commonScreenFlow-mapping.xml
        return beanMapper.map(sharedFlowPaths, Map.class);
    }

    void validateAllowedPath(String path, String logicalPathName) {
        if (path == null) {
            return;
        }
        if (!path.isEmpty() && !ALLOWED_PATH_PATTERN.matcher(path).matches()) {
            throw new RequestRejectedException(
                    "Detected the forbidden path pattern into the shared screen flow " + logicalPathName + ". Rejected path : " + path);
        }
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
