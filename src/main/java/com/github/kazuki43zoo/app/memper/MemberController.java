package com.github.kazuki43zoo.app.memper;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes(types = MemberForm.class)
@RequestMapping("member")
@Controller
public class MemberController {

    @ModelAttribute("memberForm")
    public MemberForm setupMemberForm() {
        return new MemberForm();
    }

    @RequestMapping(params = "createForm")
    public String createForm() {
        return "member/createForm";
    }

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, params = "createRedo")
    public String createRedo(MemberForm form) {
        return createForm();
    }

    @RequestMapping(method = RequestMethod.POST, params = "createConfirm")
    public String createConfirm(@Validated MemberForm form) {
        return "member/createConfirm";
    }

}
