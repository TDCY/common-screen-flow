package com.example.app.share;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class SharedFlowTerminatingInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String sharedFlowId = request.getParameter("sharedFlowId");
        String sharedFlowOperation = request.getParameter("sharedFlowOperation");
        if (sharedFlowId == null || !"terminating".equals(sharedFlowOperation)) {
            return true;
        }
        HttpSession session = request.getSession(false);
        if (session == null) {
            return true;
        }
        List<SharedFlowPaths> flows = (List<SharedFlowPaths>) session.getAttribute(SharedFlowPaths.MODEL_NAME + sharedFlowId);
        if (flows == null) {
            return true;
        }
        if (!flows.isEmpty()) {
            flows.remove(flows.size() - 1);
        }
        if (flows.isEmpty()) {
            session.removeAttribute(SharedFlowPaths.MODEL_NAME + sharedFlowId);
        }
        return true;
    }

}
