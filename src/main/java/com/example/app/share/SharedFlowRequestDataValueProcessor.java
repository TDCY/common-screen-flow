package com.example.app.share;

import org.springframework.stereotype.Component;
import org.terasoluna.gfw.web.mvc.support.RequestDataValueProcessorAdaptor;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class SharedFlowRequestDataValueProcessor extends RequestDataValueProcessorAdaptor {

    @Override
    public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
        SharedFlowPaths sharedFlowPaths = SharedFlowPaths.class.cast(request.getAttribute(SharedFlowPaths.MODEL_NAME));
        if (sharedFlowPaths == null) {
            return null;
        }
        return sharedFlowPaths.asIdMap();
    }

}
