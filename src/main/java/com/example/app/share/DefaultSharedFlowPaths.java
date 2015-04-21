package com.example.app.share;

import lombok.AccessLevel;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;

@lombok.Data
public class DefaultSharedFlowPaths implements SharedFlowPaths, Serializable {

    private static final long serialVersionUID = 1L;

    @lombok.Setter(AccessLevel.NONE)
    private String id = UUID.randomUUID().toString();
    private String flowFinishPath;
    private String flowCancelPath;

    public void finalizePaths() {
        this.flowFinishPath = appendParameters(flowFinishPath);
        this.flowCancelPath = appendParameters(flowCancelPath);
        if (flowCancelPath == null) {
            this.flowCancelPath = flowFinishPath;
        }
    }

    private String appendParameters(String path) {
        if (path == null) {
            return null;
        }
        StringBuilder pathBuilder = new StringBuilder(path);
        if (path.contains("?")) {
            pathBuilder.append("&");
        } else {
            pathBuilder.append("?");
        }
        pathBuilder.append("sharedFlowId").append("=").append(id);
        pathBuilder.append("&").append("sharedFlowOperation").append("=").append("terminating");
        return pathBuilder.toString();
    }

    public Map<String, String> asIdMap() {
        return Collections.singletonMap("sharedFlowId", id);
    }

}
