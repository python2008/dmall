package com.dmall.bms.service.impl.role.handler;

import com.dmall.bms.api.dto.role.request.SaveRoleRequestDTO;
import com.dmall.bms.service.impl.role.enums.RoleErrorEnum;
import com.dmall.bms.generator.dataobject.RoleDO;
import com.dmall.bms.generator.mapper.RoleMapper;
import com.dmall.common.model.handler.AbstractCommonHandler;
import com.dmall.common.model.result.BaseResult;
import com.dmall.component.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 新增后台角色处理器
 * @author: created by hang.yu on 2020-01-05 18:36:37
 */
@Component
public class SaveRoleHandler extends AbstractCommonHandler<SaveRoleRequestDTO, RoleDO, Long> {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public BaseResult<Long> validate(SaveRoleRequestDTO requestDTO) {
        return ResultUtil.success();
    }

    @Override
    public BaseResult<Long> processor(SaveRoleRequestDTO requestDTO) {
        return ResultUtil.success();
    }

}
