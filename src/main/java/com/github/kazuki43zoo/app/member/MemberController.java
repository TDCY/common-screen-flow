package com.github.kazuki43zoo.app.member;

import com.github.kazuki43zoo.app.share.SharedFlowHelper;
import com.github.kazuki43zoo.app.share.SharedFlowPaths;
import com.github.kazuki43zoo.domain.model.StreetAddress;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// ### 共通画面フローを呼び出す際は、呼び出し元の画面情報（フォームデータ）はセッションに格納する前提
@SessionAttributes(types = MemberForm.class)
@RequestMapping("members")
@Controller
public class MemberController {

    @ModelAttribute("memberForm")
    public MemberForm setupMemberForm() {
        return new MemberForm();
    }

    @RequestMapping(method = RequestMethod.GET, params = "clearCreateForm")
    public String clearCreateForm(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/members?createForm";
    }

    @RequestMapping(method = RequestMethod.GET, params = "createForm")
    public String createForm() {
        return "member/createForm";
    }

    @RequestMapping(method = RequestMethod.POST, params = "createRedo")
    public String createRedo(MemberForm form) {
        return createForm();
    }


    @RequestMapping(method = RequestMethod.POST, params = "createConfirm")
    public String createConfirm(
            @Validated MemberForm form,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return createRedo(form);
        }
        return "member/createConfirm";
    }

    // ### 共通画面フローの終了時とキャンセル時の遷移先情報を定義している。
    // ### 今回の例では、検索ボタンを押下した際にフォームの内容を一旦保存させるために、
    // ### MemberControllerでリクエストデータを受けてから、共通画面フロー側に
    // ### リダイレクトするスタイルを採用している。
    // ### 直接JSPから共通画面フロー側に遷移する場合は、この仕掛けはいらない。
    Map<String, SharedFlowPaths> addressSearchSharedFlowPathsMap;

    @Inject
    SharedFlowHelper sharedFlowHelper;

    @PostConstruct
    public void setupAddressSearchCommonScreenFlowPathsMap() {
        Map<String, SharedFlowPaths> map = new HashMap<>();
        map.put("mainAddressOnCreation", newSharedFlowPaths("createSelectMainAddress", "createForm"));
        map.put("subAddressOnCreation", newSharedFlowPaths("createSelectSubAddress", "createForm"));
        addressSearchSharedFlowPathsMap = Collections.unmodifiableMap(map);
    }

    private SharedFlowPaths newSharedFlowPaths(String finishParam, String cancelParam) {
        String basePath = "/members?";
        return new SharedFlowPaths(basePath + finishParam, basePath + cancelParam);
    }

    // ### 検索ボタンが押下された際に、フォームデータを保存した上で共通画面フロー(住所検索)側に遷移するためのメソッド。
    // ### 直接JSPから共通画面フロー側に遷移する場合は、この仕掛けはいらない。(JSP側で同等の処理を行う)
    @RequestMapping(method = RequestMethod.POST, params = "addressSearch")
    public String gotoAddressSearch(
            MemberForm form,
            @RequestParam("addressSearch") String target,
            RedirectAttributes redirectAttribute) {
        SharedFlowPaths sharedFlowPaths = addressSearchSharedFlowPathsMap.get(target);
        sharedFlowHelper.takeOverQueryParameters(redirectAttribute, sharedFlowPaths);
        return "redirect:/share/streetAddresses?searchForm";
    }

    // ### 共通画面フロー(住所検索)側で「選択ボタン」を押下した時のリクエストをハンドリングし、メイン住所に反映するためのメソッド。
    @RequestMapping(method = RequestMethod.POST, params = "createSelectMainAddress")
    public String createSelectMainAddress(
            @ModelAttribute MemberForm memberForm,
            StreetAddress address) {
        memberForm.setMainZipCode(address.getZipCode());
        memberForm.setMainAddress(address.getAddress());
        return createForm();
    }

    // ### 共通画面フロー(住所検索)側で「選択ボタン」を押下した時のリクエストをハンドリングし、サブ住所に反映するためのメソッド。
    @RequestMapping(method = RequestMethod.POST, params = "createSelectSubAddress")
    public String createSelectSubAddress(
            @ModelAttribute MemberForm memberForm,
            StreetAddress address) {
        memberForm.setSubZipCode(address.getZipCode());
        memberForm.setSubAddress(address.getAddress());
        return createForm();
    }

}
