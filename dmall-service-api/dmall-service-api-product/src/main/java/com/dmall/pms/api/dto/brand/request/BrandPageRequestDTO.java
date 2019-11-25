package com.dmall.pms.api.dto.brand.request;

import com.dmall.pms.api.dto.common.PageRequestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @description: 品牌分页请求实体
 * @author: created by hang.yu on 2019/11/23 10:30
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "BrandPageRequestDTO", description = "品牌分页请求实体")
@EqualsAndHashCode(callSuper = false)
public class BrandPageRequestDTO extends PageRequestDTO {

    @ApiModelProperty(value = "品牌名称", position = 1)
    private String name;

    @ApiModelProperty(value = "英文名称", position = 2)
    private String englishName;

    @ApiModelProperty(value = "首字母", position = 3)
    @NotBlank(message = "首字母不能为空")
    @Length(max = 1,min = 1,message = "首字母长度固定一位")
    private String firstLetter;
}