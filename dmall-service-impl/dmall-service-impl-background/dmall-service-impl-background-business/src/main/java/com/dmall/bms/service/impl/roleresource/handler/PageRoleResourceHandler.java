package com.dmall.bms.service.impl.roleresource.handler;

import com.dmall.bms.api.dto.roleresource.common.CommonRoleResourceResponseDTO;
import com.dmall.bms.api.dto.roleresource.request.PageRoleResourceRequestDTO;
import com.dmall.bms.generator.dataobject.RoleResourceDO;
import com.dmall.bms.generator.mapper.RoleResourceMapper;
import com.dmall.common.model.result.LayuiPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dmall.common.model.handler.AbstractCommonHandler;
import com.dmall.common.model.result.BaseResult;
import com.dmall.component.web.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description: 后台角色-资源分页处理器
 * @author: created by hang.yu on 2020-01-05 18:36:37
 */
@Component
public class PageRoleResourceHandler extends AbstractCommonHandler<PageRoleResourceRequestDTO, RoleResourceDO, CommonRoleResourceResponseDTO> {

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public BaseResult<LayuiPage<CommonRoleResourceResponseDTO>> validate(PageRoleResourceRequestDTO requestDTO) {
        return ResultUtil.success();
    }

    @Override
    public BaseResult<LayuiPage<CommonRoleResourceResponseDTO>> processor(PageRoleResourceRequestDTO requestDTO) {
        return ResultUtil.success();
    }

}
