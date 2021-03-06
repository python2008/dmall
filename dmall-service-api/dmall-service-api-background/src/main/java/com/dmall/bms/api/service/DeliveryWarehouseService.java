package com.dmall.bms.api.service;

import com.dmall.bms.api.dto.deliverywarehouse.request.ListDeliveryWarehouseRequestDTO;
import com.dmall.bms.api.dto.deliverywarehouse.request.PageDeliveryWarehouseRequestDTO;
import com.dmall.bms.api.dto.deliverywarehouse.common.CommonDeliveryWarehouseResponseDTO;
import com.dmall.bms.api.dto.deliverywarehouse.request.SaveDeliveryWarehouseRequestDTO;
import com.dmall.bms.api.dto.deliverywarehouse.request.UpdateDeliveryWarehouseRequestDTO;
import com.dmall.common.model.result.BaseResult;
import com.dmall.common.model.result.LayuiPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @description: 商家发货仓库服务
 * @author: created by hang.yu on 2020-01-05 18:36:36
 */
@Api(tags = "商家发货仓库服务")
@RequestMapping("/deliveryWarehouse")
public interface DeliveryWarehouseService {

    @PostMapping("/")
    @ApiOperation(value = "新增商家发货仓库")
    BaseResult<Long> save(@Valid @RequestBody SaveDeliveryWarehouseRequestDTO requestDTO);

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除商家发货仓库")
    @ApiImplicitParam(name = "id", value = "商家发货仓库id", required = true, dataType = "int", paramType = "path")
    BaseResult<Long> delete(@PathVariable("id") Long id);

    @PutMapping("/")
    @ApiOperation(value = "修改商家发货仓库")
    BaseResult<Long> update(@Valid @RequestBody UpdateDeliveryWarehouseRequestDTO requestDTO);

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询商家发货仓库")
    @ApiImplicitParam(name = "id", value = "商家发货仓库id", required = true, dataType = "int", paramType = "path")
    BaseResult<CommonDeliveryWarehouseResponseDTO> get(@PathVariable("id") Long id);

    @PostMapping("/list")
    @ApiOperation(value = "商家发货仓库列表")
    BaseResult<List<CommonDeliveryWarehouseResponseDTO>> list(@RequestBody ListDeliveryWarehouseRequestDTO requestDTO);

    @PostMapping("/page")
    @ApiOperation(value = "商家发货仓库分页")
    BaseResult<LayuiPage<CommonDeliveryWarehouseResponseDTO>> page(@RequestBody PageDeliveryWarehouseRequestDTO requestDTO);

}
