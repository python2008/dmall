package com.dmall.pms.api.dto.product.response.get;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: sku列表响应实体
 * @author: created by hang.yu on 2019/12/27 21:46
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "SkuListResponseDTO", description = "sku列表响应实体")
public class SkuListResponseDTO implements Serializable {

    private static final long serialVersionUID = 3640609472202223262L;

    @ApiModelProperty(value = "skuId", position = 1)
    private Long skuId;

    @ApiModelProperty(value = "sku编号", position = 2)
    private String skuNo;

    @ApiModelProperty(value = "价格", position = 3)
    private BigDecimal price;

    @ApiModelProperty(value = "库存", position = 4)
    private Integer stock;

    @ApiModelProperty(value = "规格", position = 5)
    private String specifications;
}
