package org.bmth.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by pengq on 2020/1/4 13:18.
 */
@Data
public class User{
    private Integer id;

    private String username;

    private String password;

    private String avatar;

    private String nickname;

    private Integer sex;

    private Integer age;

    private String telephone;

    private Boolean enable;

    private Date createTime;
}
