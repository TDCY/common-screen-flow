package com.github.kazuki43zoo.app.share;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.inject.Inject;

@ControllerAdvice(annotations = SharedFlowController.class)
public class SharedFlowControllerAdvice {

    @Inject
    SharedFlowHelper sharedFlowHelper;

    @ModelAttribute
    public SharedFlowPaths bindSharedFlowPathsIntoModel(SharedFlowPaths sharedFlowPaths) {
        if (sharedFlowPaths.isEmpty()) {
            return null;
        }
        sharedFlowHelper.validateAllowedPath(sharedFlowPaths.getFlowFinishPath(), "finish path");
        sharedFlowHelper.validateAllowedPath(sharedFlowPaths.getFlowCancelPath(), "cancel path");
        if (sharedFlowPaths.getFlowCancelPath() == null) {
            sharedFlowPaths.setFlowCancelPath(sharedFlowPaths.getFlowFinishPath());
        }
        return sharedFlowPaths;
    }

}
