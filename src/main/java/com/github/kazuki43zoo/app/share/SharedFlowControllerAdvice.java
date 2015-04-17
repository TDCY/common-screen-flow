package com.github.kazuki43zoo.app.share;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(annotations = SharedFlowController.class)
public class SharedFlowControllerAdvice {

    @ModelAttribute
    public SharedFlowPaths createSharedScreenFlowPaths(SharedFlowPaths sharedFlowPaths) {
        if (sharedFlowPaths.getFlowFinishPath() == null
                && sharedFlowPaths.getFlowCancelPath() == null) {
            return null;
        }
        if (sharedFlowPaths.getFlowCancelPath() == null) {
            sharedFlowPaths.setFlowCancelPath(sharedFlowPaths.getFlowFinishPath());
        }
        return sharedFlowPaths;
    }

}
