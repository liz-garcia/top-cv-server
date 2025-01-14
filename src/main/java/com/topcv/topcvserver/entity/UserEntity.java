package com.topcv.topcvserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEntity {

    private Long id;

    private String email;

    @JsonIgnore // for not leaking any hashes
    private String password;

    private String role;

    private String extraInfo;
}
