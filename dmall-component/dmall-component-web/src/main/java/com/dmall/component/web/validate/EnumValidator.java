package com.dmall.component.web.validate;

import com.dmall.common.enums.base.EnumUtil;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 枚举校验类
 * @author: created by hang.yu on 2019/11/23 17:57
 */
@Slf4j
public class EnumValidator implements ConstraintValidator<ValueInEnum, Object> {
    private List<Object> values = new ArrayList<>();

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || values.contains(value);
    }

    @Override
    public void initialize(ValueInEnum valueInEnum) {
        values = EnumUtil.getAllCode(valueInEnum.value());
    }
}
