package com.github.kazuki43zoo.app.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@ControllerAdvice(basePackageClasses = CommonScreenFlowControllerAdvice.class)
public class CommonScreenFlowControllerAdvice {

    @ModelAttribute("backwardPath")
    public String storeBackwardPathIntoModel(@RequestParam(value = "backwardPath", required = false) String backwardPath) {
        return backwardPath;
    }

}
