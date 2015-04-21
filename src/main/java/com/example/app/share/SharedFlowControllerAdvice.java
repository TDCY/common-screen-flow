package com.example.app.share;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice(annotations = SharedFlowController.class)
public class SharedFlowControllerAdvice {

    @ModelAttribute
    public void bindSharedFlowPaths(@RequestParam(value = "sharedFlowId", required = false) String requestedSharedFlowId, HttpSession session, Model model) {
        String sharedFlowId = requestedSharedFlowId;
        SharedFlowPaths sharedFlowPaths = null;
        if (sharedFlowId == null) {
            sharedFlowPaths = SharedFlowPaths.class.cast(model.asMap().get(SharedFlowPaths.MODEL_NAME));
            if (sharedFlowPaths == null) {
                return;
            }
            sharedFlowId = sharedFlowPaths.getId();
            sharedFlowPaths.finalizePaths();
            List<SharedFlowPaths> flows = new ArrayList<>();
            flows.add(sharedFlowPaths);
            session.setAttribute(SharedFlowPaths.MODEL_NAME + sharedFlowId, flows);
        } else {
            List<SharedFlowPaths> flows = (List<SharedFlowPaths>) session.getAttribute(SharedFlowPaths.MODEL_NAME + sharedFlowId);
            if (flows == null) {
                return;
            }
            sharedFlowPaths = SharedFlowPaths.class.cast(model.asMap().get(SharedFlowPaths.MODEL_NAME));
            if (sharedFlowPaths != null) {
                flows.add(sharedFlowPaths);
            } else {
                sharedFlowPaths = flows.get(flows.size() - 1);
                model.addAttribute(SharedFlowPaths.MODEL_NAME, sharedFlowPaths);
            }
        }
    }

}
