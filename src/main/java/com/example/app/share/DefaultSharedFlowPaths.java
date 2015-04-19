package com.example.app.share;

import org.springframework.security.web.firewall.RequestRejectedException;

import java.io.Serializable;
import java.util.regex.Pattern;

@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
public class DefaultSharedFlowPaths implements SharedFlowPaths, Serializable {

    private static final long serialVersionUID = 1L;
    protected static final Pattern ALLOWED_PATH_PATTERN = Pattern.compile("^/$|^/[a-zA-Z].*");

    private String flowFinishPath;
    private String flowCancelPath;

    public boolean isEmpty() {
        return flowFinishPath == null
                && flowCancelPath == null;
    }

    @Override
    public void validatePaths() {
        validateAllowedPath(flowFinishPath, "finish path");
        validateAllowedPath(flowCancelPath, "cancel path");
    }

    public void finalizePaths() {
        if (flowCancelPath == null) {
            this.flowCancelPath = flowFinishPath;
        }
    }

    protected final void validateAllowedPath(String path, String logicalPathName) {
        if (path == null) {
            return;
        }
        if (!path.isEmpty() && !ALLOWED_PATH_PATTERN.matcher(path).matches()) {
            throw new RequestRejectedException(
                    "Detected the forbidden path pattern into the shared screen flow " + logicalPathName + ". Rejected path : " + path);
        }
    }

}
