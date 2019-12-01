package com.dmall.mms.generator.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.*;
import java.math.*;

/**
 * @description: 会员浏览历史记录表
 * @author: created by hang.yu on 2019-12-01 22:56:08
 */
@Data
@Accessors(chain = true)
@ApiModel(value="MemberViewSkuDTO", description="会员浏览历史记录表")
public class MemberViewSkuDTO implements Serializable {

    private static final long serialVersionUID=1L;


    @ApiModelProperty(value = "id", position = 1)
    private Long id;

    @ApiModelProperty(value = "会员id", position = 2)
    private Long memberId;

    @ApiModelProperty(value = "skuid", position = 3)
    private Long skuId;

    @ApiModelProperty(value = "商品id", position = 4)
    private String productId;

    @ApiModelProperty(value = "商品编号", position = 5)
    private String productNo;

    @ApiModelProperty(value = "sku编号", position = 6)
    private String skuNo;

    @ApiModelProperty(value = "浏览时价格", position = 7)
    private BigDecimal price;

    @ApiModelProperty(value = "创建人", position = 8)
    private Long creator;

    @ApiModelProperty(value = "创建时间", position = 9)
    private Date gmtCreated;

    @ApiModelProperty(value = "更新人", position = 10)
    private Long modifier;

    @ApiModelProperty(value = "更新时间", position = 11)
    private Date gmtModified;

    @ApiModelProperty(value = "状态 Y-可用;N-不可用", position = 12)
    private String isDeleted;

}