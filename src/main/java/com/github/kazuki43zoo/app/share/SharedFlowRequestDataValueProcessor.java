package com.github.kazuki43zoo.app.share;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.terasoluna.gfw.web.mvc.support.RequestDataValueProcessorAdaptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class SharedFlowRequestDataValueProcessor extends RequestDataValueProcessorAdaptor {

    private static final String MODEL_NAME = StringUtils.uncapitalize(SharedFlowPaths.class.getSimpleName());

    @Inject
    SharedFlowHelper sharedFlowHelper;

    @Override
    public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
        Object model = request.getAttribute(MODEL_NAME);
        if (model == null) {
            return null;
        }
        SharedFlowPaths flowPaths = SharedFlowPaths.class.cast(model);
        return sharedFlowHelper.toAttributes(flowPaths);
    }

}
