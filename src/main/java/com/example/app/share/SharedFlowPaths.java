package com.example.app.share;

public interface SharedFlowPaths {
    String MODEL_NAME = "sharedFlowPaths";

    boolean isEmpty();

    void validatePaths();

    void finalizePaths();
}
