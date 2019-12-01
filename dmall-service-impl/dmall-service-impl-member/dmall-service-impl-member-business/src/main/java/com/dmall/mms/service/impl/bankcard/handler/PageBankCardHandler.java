package com.dmall.mms.service.impl.bankcard.handler;

import com.dmall.mms.api.dto.bankcard.common.CommonBankCardResponseDTO;
import com.dmall.mms.api.dto.bankcard.request.PageBankCardRequestDTO;
import com.dmall.mms.service.impl.bankcard.enums.BankCardErrorEnum;
import com.dmall.mms.generator.dataobject.BankCardDO;
import com.dmall.mms.generator.mapper.BankCardMapper;
import com.dmall.common.model.result.LayuiPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dmall.common.model.handler.AbstractCommonHandler;
import com.dmall.common.model.result.BaseResult;
import com.dmall.component.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 会员银行卡分页处理器
 * @author: created by hang.yu on 2019-12-01 22:56:07
 */
@Component
public class PageBankCardHandler extends AbstractCommonHandler<PageBankCardRequestDTO, BankCardDO, CommonBankCardResponseDTO> {

    @Autowired
    private BankCardMapper bankCardMapper;

    @Override
    public BaseResult<LayuiPage<CommonBankCardResponseDTO>> validate(PageBankCardRequestDTO requestDTO) {
        return ResultUtil.success();
    }

    @Override
    public BaseResult<LayuiPage<CommonBankCardResponseDTO>> processor(PageBankCardRequestDTO requestDTO) {
        return ResultUtil.success();
    }

}