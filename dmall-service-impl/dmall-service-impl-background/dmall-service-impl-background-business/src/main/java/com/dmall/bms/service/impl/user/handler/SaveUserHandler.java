package com.dmall.bms.service.impl.user.handler;

import com.dmall.bms.api.dto.user.request.SaveUserRequestDTO;
import com.dmall.bms.service.impl.user.enums.UserErrorEnum;
import com.dmall.bms.generator.dataobject.UserDO;
import com.dmall.bms.generator.mapper.UserMapper;
import com.dmall.common.model.handler.AbstractCommonHandler;
import com.dmall.common.model.result.BaseResult;
import com.dmall.component.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 新增后台用户处理器
 * @author: created by hang.yu on 2020-01-05 18:36:37
 */
@Component
public class SaveUserHandler extends AbstractCommonHandler<SaveUserRequestDTO, UserDO, Long> {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseResult<Long> validate(SaveUserRequestDTO requestDTO) {
        return ResultUtil.success();
    }

    @Override
    public BaseResult<Long> processor(SaveUserRequestDTO requestDTO) {
        return ResultUtil.success();
    }

}
