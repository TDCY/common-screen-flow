package com.github.kazuki43zoo.app.common.flow;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@ControllerAdvice(annotations = CommonScreenFlowController.class)
public class CommonScreenFlowControllerAdvice {

    @ModelAttribute()
    public CommonScreenFlowPaths createCommonScreenFlowPaths(
            @RequestParam(value = "flowFinishPath", required = false) String flowFinishPath,
            @RequestParam(value = "flowCancelPath", required = false) String flowCancelPath) {
        if (flowFinishPath == null & flowCancelPath == null) {
            return null;
        }
        return new CommonScreenFlowPaths(flowFinishPath, (flowCancelPath != null ? flowCancelPath : flowFinishPath));
    }

}
