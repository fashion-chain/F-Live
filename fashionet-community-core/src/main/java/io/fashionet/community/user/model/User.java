package io.fashionet.community.user.model;

import io.fashionet.core.base.model.EntityBase;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class User extends EntityBase {
    @Column(columnDefinition = "VARCHAR(63) NOT NULL COMMENT '用户昵称' ")
    private String nickname;

    @Column(columnDefinition = "VARCHAR(63) NOT NULL COMMENT '密码' ")
    private String password;

    @Column(columnDefinition = "VARCHAR(31) NOT NULL COMMENT '盐' ")
    private String salt;

    @Column(columnDefinition = "VARCHAR(15) NOT NULL COMMENT '手机号' ")
    private String phoneNumber;

    @Column(columnDefinition = "VARCHAR(15) NOT NULL COMMENT '手机区号' ")
    private String phoneDistrict;

    @Column(columnDefinition = "INT(1) NOT NULL COMMENT '性别' ")
    private Integer gender;

    @Column(columnDefinition = "VARCHAR(31) NOT NULL COMMENT '国家' ")
    private String country;

    @Column(columnDefinition = "VARCHAR(31) NOT NULL COMMENT '省' ")
    private String province;

    @Column(columnDefinition = "VARCHAR(31) NOT NULL COMMENT '市' ")
    private String city;

    @Column(columnDefinition = "VARCHAR(31) NOT NULL COMMENT '区' ")
    private String district;

    @Column(columnDefinition = "VARCHAR(127) NOT NULL COMMENT '详细地址' ")
    private String address;

    @Column(columnDefinition = "VARCHAR(127) NOT NULL COMMENT '简介' ")
    private String introduction;
}
