package com.dmall.pms.api.service;

import com.dmall.pms.api.dto.comment.request.ListCommentRequestDTO;
import com.dmall.pms.api.dto.comment.request.PageCommentRequestDTO;
import com.dmall.pms.api.dto.comment.common.CommonCommentResponseDTO;
import com.dmall.pms.api.dto.comment.request.SaveCommentRequestDTO;
import com.dmall.pms.api.dto.comment.request.UpdateCommentRequestDTO;
import com.dmall.common.model.result.BaseResult;
import com.dmall.common.model.result.LayuiPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

/**
 * @description: 商品评价服务
 * @author: created by hang.yu on 2019-12-02 23:18:00
 */
@Api(tags = "商品评价服务")
@RequestMapping("/comment")
public interface CommentService {

    @PostMapping("/")
    @ApiOperation(value = "新增商品评价")
    BaseResult<Long> save(@Valid @RequestBody SaveCommentRequestDTO requestDTO);

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除商品评价")
    @ApiImplicitParam(name = "id", value = "商品评价id", required = true, dataType = "int", paramType = "path")
    BaseResult<Long> delete(@PathVariable("id") Long id);

    @PutMapping("/")
    @ApiOperation(value = "修改商品评价")
    BaseResult<Long> update(@Valid @RequestBody UpdateCommentRequestDTO requestDTO);

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id查询商品评价")
    @ApiImplicitParam(name = "id", value = "商品评价id", required = true, dataType = "int", paramType = "path")
    BaseResult<CommonCommentResponseDTO> get(@PathVariable("id") Long id);

    @PostMapping("/list")
    @ApiOperation(value = "商品评价列表")
    BaseResult<List<CommonCommentResponseDTO>> list(@RequestBody ListCommentRequestDTO requestDTO);

    @PostMapping("/page")
    @ApiOperation(value = "商品评价分页")
    BaseResult<LayuiPage<CommonCommentResponseDTO>> page(@RequestBody PageCommentRequestDTO requestDTO);

}