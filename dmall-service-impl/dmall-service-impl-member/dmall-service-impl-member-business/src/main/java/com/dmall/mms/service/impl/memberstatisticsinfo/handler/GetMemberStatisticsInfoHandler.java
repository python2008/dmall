package com.dmall.mms.service.impl.memberstatisticsinfo.handler;

import com.dmall.mms.api.dto.memberstatisticsinfo.common.CommonMemberStatisticsInfoResponseDTO;
import com.dmall.mms.service.impl.memberstatisticsinfo.enums.MemberStatisticsInfoErrorEnum;
import com.dmall.mms.generator.dataobject.MemberStatisticsInfoDO;
import com.dmall.mms.generator.mapper.MemberStatisticsInfoMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dmall.common.model.handler.AbstractCommonHandler;
import com.dmall.common.model.result.BaseResult;
import com.dmall.component.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 查询会员统计信息处理器
 * @author: created by hang.yu on 2019-12-01 22:56:08
 */
@Component
public class GetMemberStatisticsInfoHandler extends AbstractCommonHandler<Long, MemberStatisticsInfoDO, CommonMemberStatisticsInfoResponseDTO> {

    @Autowired
    private MemberStatisticsInfoMapper memberStatisticsInfoMapper;

    @Override
    public BaseResult<CommonMemberStatisticsInfoResponseDTO> validate(Long id) {
        return ResultUtil.success();
    }

    @Override
    public BaseResult<CommonMemberStatisticsInfoResponseDTO> processor(Long id) {
        return ResultUtil.success();
    }

}