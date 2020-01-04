package com.dmall.mms.api.dto.memberinvoice.request;

import com.dmall.mms.api.dto.memberinvoice.common.CommonMemberInvoiceRequestDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @description: 新增会员发票请求实体
 * @author: created by hang.yu on 2019-12-02 23:04:18
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "SaveMemberInvoiceRequestDTO", description = "新增会员发票请求实体")
public class SaveMemberInvoiceRequestDTO extends CommonMemberInvoiceRequestDTO {

}
