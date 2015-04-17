package com.github.kazuki43zoo.app.common.flow;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import java.util.Map;

@Component
public class CommonScreenFlowSharedHelper {

    @Inject
    Mapper beanMapper;

    public void takeOverQueryParameters(RedirectAttributes redirectAttributes, CommonScreenFlowPaths flowPaths) {
        if (flowPaths == null) {
            return;
        }
        redirectAttributes.addAllAttributes(toAttributes(flowPaths));
    }

    @SuppressWarnings("unchecked")
    public Map<String, String> toAttributes(CommonScreenFlowPaths flowPaths) {
        // For mapping roles, please refer to classpath:/META-INF/dozer/commonScreenFlow-mapping.xml
        return beanMapper.map(flowPaths, Map.class);
    }

}
