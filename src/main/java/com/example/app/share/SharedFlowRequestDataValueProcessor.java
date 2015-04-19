package com.example.app.share;

import org.springframework.stereotype.Component;
import org.terasoluna.gfw.web.mvc.support.RequestDataValueProcessorAdaptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class SharedFlowRequestDataValueProcessor extends RequestDataValueProcessorAdaptor {

    @Inject
    SharedFlowHelper sharedFlowHelper;

    @Override
    public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
        Object model = request.getAttribute(SharedFlowPaths.MODEL_NAME);
        if (model == null) {
            return null;
        }
        SharedFlowPaths flowPaths = SharedFlowPaths.class.cast(model);
        return sharedFlowHelper.toAttributes(flowPaths);
    }

}
