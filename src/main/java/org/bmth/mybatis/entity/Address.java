package org.bmth.mybatis.entity;

import lombok.Data;

/**
 * Created by pengq on 2020/1/19 19:11.
 */
@Data
public class Address {
    private String province;
    private String city;
    private String region;
    private String detailAddress;
}
