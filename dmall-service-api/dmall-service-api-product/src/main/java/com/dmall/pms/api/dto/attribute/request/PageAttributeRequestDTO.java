package com.dmall.pms.api.dto.attribute.request;

import com.dmall.component.web.entity.PageRequestDTO;
import com.dmall.component.web.validate.ValueInEnum;
import com.dmall.pms.api.dto.attribute.enums.HandAddStatusEnum;
import com.dmall.pms.api.dto.attribute.enums.InputTypeEnum;
import com.dmall.pms.api.dto.attribute.enums.TypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @description: 属性分页请求实体
 * @author: created by hang.yu on 2019-12-16 15:14:49
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PageAttributeRequestDTO", description = "属性分页请求实体")
public class PageAttributeRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "分类id", position = 5)
    private Long categoryId;

    @ApiModelProperty(value = "展示名称", position = 6)
    private String showName;

    @ApiModelProperty(value = "属性类型 1-普通属性;2-公共属性", position = 7)
    @ValueInEnum(TypeEnum.class)
    private Integer type;

    @ApiModelProperty(value = "属性录入方式 1-手工录入;2-从列表获取", position = 8)
    @ValueInEnum(InputTypeEnum.class)
    private Integer inputType;

    @ApiModelProperty(value = "是否支持手动新增 Y-支持;N-不支持", position = 9)
    @ValueInEnum(HandAddStatusEnum.class)
    private String handAddStatus;

}
