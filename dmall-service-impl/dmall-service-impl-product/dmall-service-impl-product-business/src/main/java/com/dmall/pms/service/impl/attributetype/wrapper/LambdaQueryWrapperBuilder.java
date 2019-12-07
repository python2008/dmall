package com.dmall.pms.service.impl.attributetype.wrapper;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dmall.pms.generator.dataobject.AttributeTypeDO;

/**
 * @description: LambdaQueryWrapperBuilder
 * @author: created by hang.yu on 2019/12/5 20:50
 */
public class LambdaQueryWrapperBuilder {

    public static LambdaQueryWrapper queryWrapper(Long categoryId, String name, String showName){
        LambdaQueryWrapper<AttributeTypeDO> queryWrapper = Wrappers.<AttributeTypeDO>lambdaQuery()
                .eq(categoryId != null, AttributeTypeDO::getCategoryId, categoryId)
                .eq(StrUtil.isNotBlank(name), AttributeTypeDO::getName,name)
                .eq(StrUtil.isNotBlank(showName), AttributeTypeDO::getShowName, showName)
                .orderByAsc(AttributeTypeDO::getSort);
        return queryWrapper;
    }



}