package com.dmall.component.mybatisplus.generator;

import com.baomidou.mybatisplus.generator.config.IFileCreate;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;

/**
 * @description:
 * @author: created by hang.yu on 2019/12/2 22:47
 */
public interface DMallFileCreate extends IFileCreate {

    boolean isCreate(ConfigBuilder configBuilder, DMallFileType fileType, String filePath);
}
