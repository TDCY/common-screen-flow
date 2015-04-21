package com.example.app.member;

import com.example.app.share.DefaultSharedFlowPaths;
import com.example.app.share.SharedFlowPaths;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
public class MemberHelper {

    // ### 共通画面フローの終了時とキャンセル時の遷移先情報を定義している。
    // ### 今回の例では、検索ボタンを押下した際にフォームの内容を保存するため、
    // ### MemberControllerでリクエストデータを受けてから、共通画面フロー側に
    // ### リダイレクトするスタイルを採用している。
    // ### 直接JSPから共通画面フロー側に遷移する場合は、この仕掛けはいらない。
    private Map<String, SharedFlowPaths> addressSearchSharedFlowPathsMap;

    @PostConstruct
    void setupAddressSearchSharedFlowPathsMap() {
        Map<String, SharedFlowPaths> map = new HashMap<>();
        map.put("mainAddressOnCreation",
                newSharedFlowPaths("selectMainAddress&destination=createForm", "createForm"));
        map.put("subAddressOnCreation",
                newSharedFlowPaths("selectSubAddress&destination=createForm", "createForm"));
        map.put("mainAddressOnUpdating",
                newSharedFlowPaths("selectMainAddress&destination=updateForm", "updateForm"));
        map.put("subAddressOnUpdating",
                newSharedFlowPaths("selectSubAddress&destination=updateForm", "updateForm"));
        addressSearchSharedFlowPathsMap = Collections.unmodifiableMap(map);
    }

    private SharedFlowPaths newSharedFlowPaths(String queryStringOnFinish, String queryStringOnCancel) {
        String basePath = "/members?";
        DefaultSharedFlowPaths defaultSharedFlowPaths = new DefaultSharedFlowPaths();
        defaultSharedFlowPaths.setFlowFinishPath(basePath + queryStringOnFinish);
        defaultSharedFlowPaths.setFlowCancelPath(basePath + queryStringOnCancel);
        return defaultSharedFlowPaths;
    }

    SharedFlowPaths decideAddressSearchSharedFlowPaths(String addressSearchButton) {
        return addressSearchSharedFlowPathsMap.get(addressSearchButton);
    }

}
