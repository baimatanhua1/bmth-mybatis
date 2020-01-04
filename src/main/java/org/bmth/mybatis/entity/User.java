package org.bmth.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by pengq on 2020/1/4 13:18.
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String avatar;

    private String nickname;

    private Boolean sex;

    private Boolean enable;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}