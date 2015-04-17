package com.github.kazuki43zoo.app.member;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@lombok.Data
public class MemberForm implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String mainZipCode;
    @NotNull
    private String mainAddress;
    private String subZipCode;
    private String subAddress;
}
