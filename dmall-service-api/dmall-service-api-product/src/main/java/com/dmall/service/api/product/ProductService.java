package com.dmall.service.api.product;

import com.dmall.service.api.product.dto.request.ProductRequestDTO;
import com.dmall.service.api.product.dto.response.ProductResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description: 商品服务接口
 * @author: created by yuhang on 2019/10/14 21:50
 */
public interface ProductService {

    /**
     * 获取商品服务
     * @param requestDTO    请求实体
     */
    @PostMapping("/product")
    @ResponseBody
    ProductResponseDTO getProduct(@RequestBody ProductRequestDTO requestDTO);
}
