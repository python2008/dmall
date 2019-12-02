package com.dmall.pms.api.dto.brand.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;
import java.util.*;
import java.math.*;

/**
 * @description: 品牌公共响应实体
 * @author: created by hang.yu on 2019-12-02 23:18:00
 */
@Data
@Accessors(chain = true)
@ApiModel(value="CommonBrandResponseDTO", description="品牌公共响应实体")
public class CommonBrandResponseDTO implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "品牌id", position = 1)
    private Long id;

    @ApiModelProperty(value = "创建人", position = 7)
    private Long creator;

    @ApiModelProperty(value = "创建人姓名", position = 8)
    private String creatorName;

    @ApiModelProperty(value = "创建时间", position = 9)
    private Date gmtCreated;

    @ApiModelProperty(value = "修改人", position = 10)
    private Long modifier;

    @ApiModelProperty(value = "修改人姓名", position = 11)
    private String modifierName;

    @ApiModelProperty(value = "修改时间", position = 12)
    private Date gmtModified;

    @ApiModelProperty(value = "状态", position = 13)
    private String isDeleted;


}