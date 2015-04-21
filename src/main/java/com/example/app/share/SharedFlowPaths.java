package com.example.app.share;

import java.util.Map;

public interface SharedFlowPaths {
    String MODEL_NAME = "sharedFlowPaths";

    void finalizePaths();

    Map<String, String> asIdMap();

    String getId();

}
