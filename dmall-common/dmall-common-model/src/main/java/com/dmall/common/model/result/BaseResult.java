package com.dmall.common.model.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description: 接口统一返回
 * @author: created by hang.yu on 2019/11/7 21:32
 */
@Data
public class BaseResult<T> {

    @ApiModelProperty(value = "返回码", position = 1)
    private String code;

    @ApiModelProperty(value = "返回消息", position = 2)
    private String msg;

    @ApiModelProperty(value = "返回结果", position = 3)
    private Boolean result;

    @ApiModelProperty(value = "返回数据为集合时的条数", position = 4)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer count;

    @ApiModelProperty(value = "返回数据", position = 5)
    private T data;

}
