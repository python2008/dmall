package com.dmall.bms.service.impl.userloginlog.handler;

import com.dmall.bms.api.dto.userloginlog.request.UpdateUserLoginLogRequestDTO;
import com.dmall.bms.service.impl.userloginlog.enums.UserLoginLogErrorEnum;
import com.dmall.bms.generator.dataobject.UserLoginLogDO;
import com.dmall.bms.generator.mapper.UserLoginLogMapper;
import com.dmall.common.model.handler.AbstractCommonHandler;
import com.dmall.common.model.result.BaseResult;
import com.dmall.component.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 修改后台用户登录日志处理器
 * @author: created by hang.yu on 2020-01-05 18:36:37
 */
@Component
public class UpdateUserLoginLogHandler extends AbstractCommonHandler<UpdateUserLoginLogRequestDTO, UserLoginLogDO, Long> {

    @Autowired
    private UserLoginLogMapper userLoginLogMapper;

    @Override
    public BaseResult<Long> validate(UpdateUserLoginLogRequestDTO requestDTO) {
        return ResultUtil.success();
    }

    @Override
    public BaseResult<Long> processor(UpdateUserLoginLogRequestDTO requestDTO) {
        return ResultUtil.success();
    }

}