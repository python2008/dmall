package com.dmall.pms.service.impl.category.handler;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dmall.common.model.handler.AbstractCommonHandler;
import com.dmall.common.model.result.BaseResult;
import com.dmall.component.web.util.ResultUtil;
import com.dmall.pms.api.dto.category.request.setbrand.BrandIdsDTO;
import com.dmall.pms.api.dto.category.request.setbrand.SetBrandRequestDTO;
import com.dmall.pms.generator.dataobject.BrandDO;
import com.dmall.pms.generator.dataobject.CategoryBrandDO;
import com.dmall.pms.generator.dataobject.CategoryDO;
import com.dmall.pms.generator.service.IBrandService;
import com.dmall.pms.generator.service.ICategoryBrandService;
import com.dmall.pms.service.impl.category.enums.CategoryErrorEnum;
import com.dmall.pms.service.impl.support.CategorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @description: 设置品牌处理器
 * @author: created by hang.yu on 2019/12/4 22:44
 */
@Component
public class SetBrandHandler extends AbstractCommonHandler<SetBrandRequestDTO, CategoryDO, Void> {

    @Autowired
    private IBrandService iBrandService;

    @Autowired
    private ICategoryBrandService iCategoryBrandService;

    @Autowired
    private CategorySupport categorySupport;

    @Override
    public BaseResult validate(SetBrandRequestDTO requestDTO) {
        Set<Long> brandIds = requestDTO.getBrandIds().stream().map(BrandIdsDTO::getBrandId).collect(Collectors.toSet());
        // 品牌id不能有重复
        if (brandIds.size() != requestDTO.getBrandIds().size()) {
            return ResultUtil.fail(CategoryErrorEnum.BRAND_IDS_REPEATED);
        }
        Collection<BrandDO> brandDOS = iBrandService.listByIds(brandIds);
        // 品牌id必须存在
        if (brandDOS.size() != requestDTO.getBrandIds().size()) {
            return ResultUtil.fail(CategoryErrorEnum.BRAND_ID_INVALID);
        }
        return categorySupport.validate(requestDTO.getCategoryId());
    }

    @Override
    public BaseResult processor(SetBrandRequestDTO requestDTO) {
        // 先删除 后批量插入
        iCategoryBrandService.remove(Wrappers.<CategoryBrandDO>lambdaQuery()
                .eq(CategoryBrandDO::getCategoryId, requestDTO.getCategoryId()));
        List<CategoryBrandDO> insertList = requestDTO.getBrandIds().stream()
                .map(brand -> {
                    CategoryBrandDO categoryBrandDO = new CategoryBrandDO();
                    categoryBrandDO.setCategoryId(requestDTO.getCategoryId());
                    categoryBrandDO.setBrandId(brand.getBrandId());
                    categoryBrandDO.setSort(brand.getSort());
                    return categoryBrandDO;
                }).collect(Collectors.toList());
        iCategoryBrandService.saveBatch(insertList);
        return ResultUtil.success();
    }
}
