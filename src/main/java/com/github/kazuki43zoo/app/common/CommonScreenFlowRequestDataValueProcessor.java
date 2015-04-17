package com.github.kazuki43zoo.app.common;

import org.springframework.stereotype.Component;
import org.terasoluna.gfw.web.mvc.support.RequestDataValueProcessorAdaptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Map;

@Component
public class CommonScreenFlowRequestDataValueProcessor extends RequestDataValueProcessorAdaptor {

    @Override
    public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
        Object backwardPath = request.getAttribute("backwardPath");
        Map<String, String> hiddenFields = null;
        if (backwardPath != null) {
            hiddenFields = Collections.singletonMap("backwardPath", backwardPath.toString());
        }
        return hiddenFields;
    }

}
