package com.dmall.mms.api.dto.bankcard.request;

import com.dmall.component.web.entity.PageRequestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @description: 会员银行卡分页请求实体
 * @author: created by hang.yu on 2019-12-02 23:04:17
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "PageBankCardRequestDTO", description = "会员银行卡分页请求实体")
public class PageBankCardRequestDTO extends PageRequestDTO {


    @ApiModelProperty(value = "会员id", position = 2)
    private Long memberId;

    @ApiModelProperty(value = "银行名称", position = 3)
    private String bankName;

    @ApiModelProperty(value = "持卡人姓名", position = 4)
    private String name;

    @ApiModelProperty(value = "持卡人手机号", position = 5)
    private String mobile;

    @ApiModelProperty(value = "持卡人身份证号", position = 6)
    private String idNo;

    @ApiModelProperty(value = "银行卡类型 1-储蓄卡;2-信用卡", position = 7)
    private Integer type;


}
