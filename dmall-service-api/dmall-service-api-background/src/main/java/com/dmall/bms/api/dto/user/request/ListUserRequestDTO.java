package com.dmall.bms.api.dto.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.*;
import java.math.*;
import java.io.Serializable;

/**
 * @description: 后台用户列表请求实体
 * @author: created by hang.yu on 2020-01-05 18:36:37
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ListUserRequestDTO", description = "后台用户列表请求实体")
public class ListUserRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "商家店铺id", position = 2)
    private Long merchantsId;

    @ApiModelProperty(value = "用户名", position = 3)
    private String userName;

    @ApiModelProperty(value = "昵称", position = 4)
    private String nickName;

    @ApiModelProperty(value = "手机号", position = 5)
    private String phone;

    @ApiModelProperty(value = "密码", position = 6)
    private String password;

    @ApiModelProperty(value = "真实姓名", position = 7)
    private String realName;

    @ApiModelProperty(value = "头像", position = 8)
    private String icon;

    @ApiModelProperty(value = "备注", position = 9)
    private String remark;


}
