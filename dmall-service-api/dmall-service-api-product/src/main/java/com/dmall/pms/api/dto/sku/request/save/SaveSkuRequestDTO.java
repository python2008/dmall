package com.dmall.pms.api.dto.sku.request.save;

import com.dmall.common.enums.base.YNEnum;
import com.dmall.component.web.validate.ValueInEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @description: 新增sku请求实体
 * @author: created by hang.yu on 2019-12-16 15:14:50
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "SaveSkuRequestDTO", description = "新增sku请求实体")
public class SaveSkuRequestDTO implements Serializable {

    @ApiModelProperty(value = "商品id", required = true, position = 0)
    @NotNull(message = "商品id不能为空")
    private Long productId;

    @ApiModelProperty(value = "skuId", position = 1)
    private Long id;

    @ApiModelProperty(value = "sku名称", required = true, position = 2)
    @NotBlank(message = "名称不能为空")
    private String name;

    @ApiModelProperty(value = "sku副名称", position = 3)
    private String subName;

    @ApiModelProperty(value = "价格", required = true, position = 4)
    @NotNull(message = "价格不能为空")
    private BigDecimal price;

    @ApiModelProperty(value = "vip价格", position = 5)
    private BigDecimal vipPrice;

    @ApiModelProperty(value = "市场价格", position = 6)
    private BigDecimal marketPrice;

    @ApiModelProperty(value = "库存", required = true, position = 7)
    @NotNull(message = "库存不能为空")
    private Integer stock;

    @ApiModelProperty(value = "预警库存", position = 8)
    private Integer lowStock;

    @ApiModelProperty(value = "推荐状态 Y-是;N-否", required = true, position = 9)
    @NotNull(message = "推荐状态不能为空")
    @ValueInEnum(YNEnum.class)
    private String recommendStatus;

    @ApiModelProperty(value = "新品状态 Y-是;N-否", position = 10)
    @NotNull(message = "新品状态不能为空")
    @ValueInEnum(YNEnum.class)
    private String newStatus;

    @ApiModelProperty(value = "是否是预告sku Y-是;N-否", position = 11)
    @NotNull(message = "是否是预告sku不能为空")
    @ValueInEnum(YNEnum.class)
    private String previewStatus;

    @ApiModelProperty(value = "sku描述", position = 12)
    private String description;

}
