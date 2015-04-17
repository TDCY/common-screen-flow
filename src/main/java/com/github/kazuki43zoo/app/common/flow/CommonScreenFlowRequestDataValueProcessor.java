package com.github.kazuki43zoo.app.common.flow;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.terasoluna.gfw.web.mvc.support.RequestDataValueProcessorAdaptor;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class CommonScreenFlowRequestDataValueProcessor extends RequestDataValueProcessorAdaptor {

    private static final String MODEL_NAME = StringUtils.uncapitalize(CommonScreenFlowPaths.class.getSimpleName());

    @Inject
    CommonScreenFlowSharedHelper commonScreenFlowSharedHelper;

    @Override
    public Map<String, String> getExtraHiddenFields(HttpServletRequest request) {
        Object model = request.getAttribute(MODEL_NAME);
        if (model == null) {
            return null;
        }
        CommonScreenFlowPaths flowPaths = CommonScreenFlowPaths.class.cast(model);
        return commonScreenFlowSharedHelper.toAttributes(flowPaths);
    }

}
