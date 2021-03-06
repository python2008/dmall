package com.dmall.pms.api.dto.product.response.attributevalue;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 商品扩展信息
 * @author: created by hang.yu on 2019/12/10 22:08
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ProductExtResponseDTO", description = "商品响应扩展信息")
public class ProductExtResponseDTO implements Serializable {

    private static final long serialVersionUID = -4383222923230954323L;

    @ApiModelProperty(value = "商品分类id列表", position = 1)
    private List<Long> categoryIds;

    @ApiModelProperty(value = "品牌id", position = 2)
    private Long brandId;

    @ApiModelProperty(value = "销售规格", position = 3)
    private List<SpecificationsResponseDTO> specifications;

    @ApiModelProperty(value = "卖点", position = 4)
    private List<SalePointResponseDTO> salePoints;

    @ApiModelProperty(value = "参数", position = 5)
    private List<ParamResponseDTO> params;

}
