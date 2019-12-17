package com.dmall.pms.service.impl.sku.handler;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dmall.common.model.handler.AbstractCommonHandler;
import com.dmall.common.model.result.BaseResult;
import com.dmall.component.web.util.ResultUtil;
import com.dmall.pms.api.dto.sku.request.save.SaveSkuExtRequestDTO;
import com.dmall.pms.generator.dataobject.SkuDO;
import com.dmall.pms.generator.dataobject.SkuExtDO;
import com.dmall.pms.generator.mapper.SkuExtMapper;
import com.dmall.pms.generator.mapper.SkuMapper;
import com.dmall.pms.service.impl.sku.enums.SkuErrorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: SaveSkuAttributeHandler
 * @author: created by hang.yu on 2019/12/16 16:43
 */
@Component
public class SaveSkuExtHandler extends AbstractCommonHandler<SaveSkuExtRequestDTO, SkuExtDO, Long> {

    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private SkuExtMapper skuExtMapper;

    @Override
    public BaseResult validate(SaveSkuExtRequestDTO requestDTO) {
        SkuDO skuDO = skuMapper.selectById(requestDTO.getSkuId());
        if (skuDO == null) {
            return ResultUtil.fail(SkuErrorEnum.SKU_NOT_EXIST);
        }
        return ResultUtil.success();
    }

    @Override
    public BaseResult processor(SaveSkuExtRequestDTO requestDTO) {
        SkuExtDO skuExtDO = skuExtMapper.selectOne(Wrappers.<SkuExtDO>lambdaQuery().eq(SkuExtDO::getSkuId, requestDTO.getSkuId()));
        if (skuExtDO == null){
            skuExtDO = dtoConvertDo(requestDTO, SkuExtDO.class);
            skuExtMapper.insert(skuExtDO);
        }else {
            skuExtDO.setDetailHtml(requestDTO.getDetailHtml());
            skuExtDO.setDetailMobileHtml(requestDTO.getDetailMobileHtml());
            skuExtMapper.updateById(skuExtDO);
        }
        return ResultUtil.success(requestDTO.getSkuId());
    }
}