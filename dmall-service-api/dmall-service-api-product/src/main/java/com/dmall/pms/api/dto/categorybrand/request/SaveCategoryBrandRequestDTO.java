package com.dmall.pms.api.dto.categorybrand.request;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.EqualsAndHashCode;
import com.dmall.pms.api.dto.categorybrand.common.CommonCategoryBrandRequestDTO;

/**
 * @description: 新增分类品牌关系请求实体
 * @author: created by hang.yu on 2019-12-02 23:18:00
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SaveCategoryBrandRequestDTO", description="新增分类品牌关系请求实体")
public class SaveCategoryBrandRequestDTO extends CommonCategoryBrandRequestDTO {

}