package com.dmall.pms.api.dto.attributetype.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;
import com.dmall.component.web.entity.PageRequestDTO;
import java.util.*;
import java.math.*;

/**
 * @description: 属性分类分页请求实体
 * @author: created by hang.yu on 2019-12-02 23:18:00
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="PageAttributeTypeRequestDTO", description="属性分类分页请求实体")
public class PageAttributeTypeRequestDTO  extends PageRequestDTO {




    @ApiModelProperty(value = "商品分类id", position = 2)
    private Long productCategoryId;

    @ApiModelProperty(value = "商品分类id集合 如，1/2/3", position = 3)
    private String cascadeCategoryId;

    @ApiModelProperty(value = "名称", position = 4)
    private String name;

    @ApiModelProperty(value = "展示名称", position = 5)
    private String showName;

    @ApiModelProperty(value = "排序", position = 6)
    private Integer sort;

    @ApiModelProperty(value = "规格数量", position = 7)
    private Integer specificationsCount;

    @ApiModelProperty(value = "参数数量", position = 8)
    private Integer paramCount;






}