package com.example.app.member;

import com.example.app.share.SharedFlowHelper;
import com.example.app.share.SharedFlowPaths;
import com.example.domain.model.StreetAddress;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

// ### 共通画面フローを呼び出す際は、呼び出し元の画面情報（フォームデータ）はセッションに格納する前提
@SessionAttributes(types = MemberForm.class)
@RequestMapping("members")
@Controller
public class MemberController {

    @Inject
    MemberHelper memberHelper;

    @Inject
    SharedFlowHelper sharedFlowHelper;

    @ModelAttribute("memberForm")
    public MemberForm setupMemberForm() {
        return new MemberForm();
    }

    @RequestMapping(method = RequestMethod.GET, params = "cancel")
    public String cancel(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
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

    // ### 検索ボタンが押下された際に、フォームデータを保存した後に共通画面フロー(住所検索)側に遷移するためのメソッド。
    // ### 直接JSPから共通画面フロー側に遷移する場合は、この仕掛けはいらない。(JSP側で同等の処理を行う)
    @RequestMapping(method = RequestMethod.POST, params = "addressSearch")
    public String gotoAddressSearch(
            MemberForm form,
            @RequestParam("addressSearch") String addressSearchButton,
            RedirectAttributes redirectAttribute) {
        SharedFlowPaths sharedFlowPaths = memberHelper.decideAddressSearchSharedFlowPaths(addressSearchButton);
        return sharedFlowHelper.gotoStreetAddressSearch(redirectAttribute, sharedFlowPaths);
    }

    // ### 共通画面フロー(住所検索)側で「選択ボタン」を押下した時のリクエストをハンドリングし、メイン住所に反映するためのメソッド。
    @RequestMapping(method = RequestMethod.POST, params = "selectMainAddress")
    public String selectMainAddress(
            MemberForm form,
            StreetAddress selectedAddress,
            @RequestParam("destination") String destination) {
        form.setMainZipCode(selectedAddress.getZipCode());
        form.setMainAddress(selectedAddress.getAddress());
        return "redirect:/members?" + destination;
    }

    // ### 共通画面フロー(住所検索)側で「選択ボタン」を押下した時のリクエストをハンドリングし、サブ住所に反映するためのメソッド。
    @RequestMapping(method = RequestMethod.POST, params = "selectSubAddress")
    public String selectSubAddress(
            MemberForm form,
            StreetAddress selectedAddress,
            @RequestParam("destination") String destination) {
        form.setSubZipCode(selectedAddress.getZipCode());
        form.setSubAddress(selectedAddress.getAddress());
        return "redirect:/members?" + destination;
    }

}
