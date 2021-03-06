package com.dmall.bms.service.impl.user.handler;

import com.dmall.bms.api.dto.user.common.CommonUserResponseDTO;
import com.dmall.bms.api.dto.user.request.PageUserRequestDTO;
import com.dmall.bms.generator.dataobject.UserDO;
import com.dmall.bms.generator.mapper.UserMapper;
import com.dmall.common.model.result.LayuiPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dmall.common.model.handler.AbstractCommonHandler;
import com.dmall.common.model.result.BaseResult;
import com.dmall.component.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 后台用户分页处理器
 * @author: created by hang.yu on 2020-01-05 18:36:37
 */
@Component
public class PageUserHandler extends AbstractCommonHandler<PageUserRequestDTO, UserDO, CommonUserResponseDTO> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResult<LayuiPage<CommonUserResponseDTO>> validate(PageUserRequestDTO requestDTO) {
        return ResultUtil.success();
    }

    @Override
    public BaseResult<LayuiPage<CommonUserResponseDTO>> processor(PageUserRequestDTO requestDTO) {
        return ResultUtil.success();
    }

}
