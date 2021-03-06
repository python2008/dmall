package com.dmall.bms.service.impl.roleresource.handler;

import com.dmall.bms.api.dto.roleresource.request.UpdateRoleResourceRequestDTO;
import com.dmall.bms.service.impl.roleresource.enums.RoleResourceErrorEnum;
import com.dmall.bms.generator.dataobject.RoleResourceDO;
import com.dmall.bms.generator.mapper.RoleResourceMapper;
import com.dmall.common.model.handler.AbstractCommonHandler;
import com.dmall.common.model.result.BaseResult;
import com.dmall.component.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 修改后台角色-资源处理器
 * @author: created by hang.yu on 2020-01-05 18:36:37
 */
@Component
public class UpdateRoleResourceHandler extends AbstractCommonHandler<UpdateRoleResourceRequestDTO, RoleResourceDO, Long> {

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public BaseResult<Long> validate(UpdateRoleResourceRequestDTO requestDTO) {
        return ResultUtil.success();
    }

    @Override
    public BaseResult<Long> processor(UpdateRoleResourceRequestDTO requestDTO) {
        return ResultUtil.success();
    }

}