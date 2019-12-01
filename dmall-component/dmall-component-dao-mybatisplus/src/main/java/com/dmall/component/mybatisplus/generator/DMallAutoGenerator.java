package com.dmall.component.mybatisplus.generator;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: DMallAutoGenerator
 * @author: created by hang.yu on 2019/12/1 14:34
 */
public class DMallAutoGenerator extends AutoGenerator {

    @Override
    protected List<TableInfo> getAllTableInfoList(ConfigBuilder config) {
        List<TableInfo> allTableInfoList = super.getAllTableInfoList(config);
        // 自定义配置模版， 如果你想添加一个新的类，可以在资源文件目录中的templates文件夹下
        // 添加自定义的模版文件
        config.setInjectionConfig(getInjectionConfig(config));
        return allTableInfoList;
    }

    public InjectionConfig getInjectionConfig(ConfigBuilder config) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        List<FileOutConfig> list = new ArrayList<>();
        // dto
        FileOutConfig dtoOutConfig = new FileOutConfig(Constants.TEMPLATES_DTO) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                StringBuilder dtoOutPut = new StringBuilder()
                        .append(System.getProperty("user.dir"))
                        .append(Constants.GENERATOR_MODULE_NAME)
                        .append(Constants.SRC_MAIN_JAVA)
                        .append(Constants.COM_DMALL)
                        .append(Constants.PACKAGE_MODULE_NAME)
                        .append(File.separator)
                        .append(Constants.PACKAGE_GENERATOR_NAME)
                        .append(File.separator)
                        .append(Constants.DTO)
                        .append(File.separator)
                        .append(StrUtil.removeSuffix(tableInfo.getEntityName(), "DO"))
                        .append("DTO")
                        .append(StringPool.DOT_JAVA);
                return dtoOutPut.toString();
            }
        };
        list.add(dtoOutConfig);

        // commonRequest dto
        FileOutConfig commonRequestOutConfig = new FileOutConfig(Constants.TEMPLATES_COMMON_REQUEST_DTO) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getDtoPath(entityName, Constants.COMMON, "Common", "RequestDTO");
            }
        };
        list.add(commonRequestOutConfig);

        // commonResponse dto
        FileOutConfig commonResponseOutConfig = new FileOutConfig(Constants.TEMPLATES_COMMON_RESPONSE_DTO) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getDtoPath(entityName, Constants.COMMON, "Common", "ResponseDTO");
            }
        };
        list.add(commonResponseOutConfig);

        // list dto
        FileOutConfig listOutConfig = new FileOutConfig(Constants.TEMPLATES_LIST_REQEUST_DTO) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getDtoPath(entityName, Constants.REQUEST, "List", "RequestDTO");
            }
        };
        list.add(listOutConfig);

        // page dto
        FileOutConfig pageOutConfig = new FileOutConfig(Constants.TEMPLATES_PAGE_REQEUST_DTO) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getDtoPath(entityName, Constants.REQUEST, "Page", "RequestDTO");
            }
        };
        list.add(pageOutConfig);

        // save dto
        FileOutConfig saveOutConfig = new FileOutConfig(Constants.TEMPLATES_SAVE_REQEUST_DTO) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getDtoPath(entityName, Constants.REQUEST, "Save", "RequestDTO");
            }
        };
        list.add(saveOutConfig);

        // update dto
        FileOutConfig updateOutConfig = new FileOutConfig(Constants.TEMPLATES_UPDATE_REQUEST_DTO) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getDtoPath(entityName, Constants.REQUEST, "Update", "RequestDTO");
            }
        };
        list.add(updateOutConfig);

        // service
        FileOutConfig serviceOutConfig = new FileOutConfig(Constants.TEMPLATES_BUSINESS_SERVICE) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getServicePath(entityName);
            }
        };
        list.add(serviceOutConfig);

        // serviceImpl
        FileOutConfig serviceImplOutConfig = new FileOutConfig(Constants.TEMPLATES_BUSINESS_SERVICE_IMPL) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getServiceImplPath(entityName);
            }
        };
        list.add(serviceImplOutConfig);

        // save Handler
        FileOutConfig saveHandlerOutConfig = new FileOutConfig(Constants.TEMPLATES_SAVEHANDLER) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getHandlerPath(entityName, "Save");
            }
        };
        list.add(saveHandlerOutConfig);

        // delete Handler
        FileOutConfig deleteHandlerOutConfig = new FileOutConfig(Constants.TEMPLATES_DELETEHANDLER) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getHandlerPath(entityName, "Delete");
            }
        };
        list.add(deleteHandlerOutConfig);

        // update Handler
        FileOutConfig updateHandlerOutConfig = new FileOutConfig(Constants.TEMPLATES_UPDATEHANDLER) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getHandlerPath(entityName, "Update");
            }
        };
        list.add(updateHandlerOutConfig);

        // get Handler
        FileOutConfig getHandlerOutConfig = new FileOutConfig(Constants.TEMPLATES_GETHANDLER) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getHandlerPath(entityName, "Get");
            }
        };
        list.add(getHandlerOutConfig);

        // list Handler
        FileOutConfig listHandlerOutConfig = new FileOutConfig(Constants.TEMPLATES_LISTHANDLER) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getHandlerPath(entityName, "List");
            }
        };
        list.add(listHandlerOutConfig);

        // page Handler
        FileOutConfig pageHandlerOutConfig = new FileOutConfig(Constants.TEMPLATES_PAGEHANDLER) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getHandlerPath(entityName, "Page");
            }
        };
        list.add(pageHandlerOutConfig);

        // enums
        FileOutConfig enumsOutConfig = new FileOutConfig(Constants.TEMPLATES_ERRORENUM) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                String entityName = StrUtil.removeSuffix(tableInfo.getEntityName(), "DO");
                return getEnumsPath(entityName);
            }
        };
        list.add(enumsOutConfig);


        injectionConfig.setFileOutConfigList(list);
        return injectionConfig;
    }

    private String getDtoPath(String entityName, String operation, String prefix, String suffix) {
        StringBuilder append = api()
                .append(Constants.DTO)
                .append(File.separator)
                .append(entityName.toLowerCase())
                .append(File.separator)
                .append(operation)
                .append(File.separator)
                .append(prefix)
                .append(entityName)
                .append(suffix)
                .append(StringPool.DOT_JAVA);
        return append.toString();
    }

    private String getServicePath(String entityName) {
        StringBuilder append = api()
                .append(Constants.SERVICE)
                .append(File.separator)
                .append(entityName)
                .append("Service")
                .append(StringPool.DOT_JAVA);
        return append.toString();
    }

    private String getServiceImplPath(String entityName) {
        StringBuilder append = impl(entityName)
                .append(entityName)
                .append("ServiceImpl")
                .append(StringPool.DOT_JAVA);
        return append.toString();
    }

    private String getHandlerPath(String entityName, String operator) {
        StringBuilder append = impl(entityName)
                .append(Constants.HANDLER)
                .append(File.separator)
                .append(operator)
                .append(entityName)
                .append("Handler")
                .append(StringPool.DOT_JAVA);
        return append.toString();
    }

    private String getEnumsPath(String entityName) {
        StringBuilder append = impl(entityName)
                .append(Constants.ENUMS)
                .append(File.separator)
                .append(entityName)
                .append("ErrorEnum")
                .append(StringPool.DOT_JAVA);
        return append.toString();
    }

    private StringBuilder api(){
        /*String filePath = System.getProperty("user.dir")
                + Constants.BUSINESS_MODULE_NAME
                + Constants.SRC_MAIN_JAVA
                + Constants.PACKAGE_MODULE_NAME
                + File.separator
                + Constants.SERVICE
                + File.separator
                + Constants.IMPL
                + File.separator
                ;*/
//        File file = new File(filePath);
        StringBuilder append = new StringBuilder()
                .append(System.getProperty("user.dir"))
                .append(Constants.API_MODULE_NAME)
                .append(Constants.SRC_MAIN_JAVA)
                .append(Constants.COM_DMALL)
                .append(Constants.PACKAGE_MODULE_NAME)
                .append(File.separator)
                .append(Constants.API)
                .append(File.separator);
        return append;
    }

    private StringBuilder impl(String entityName){
        /*String filePath = System.getProperty("user.dir")
                + Constants.DEFAULT_BUSINESS_MODULE_NAME
                + Constants.SRC_MAIN_JAVA
                + Constants.PACKAGE_MODULE_NAME
                + File.separator
                + Constants.SERVICE
                + File.separator
                + Constants.IMPL
                + File.separator
                ;
        File file = new File(filePath);*/
        StringBuilder append = new StringBuilder()
                .append(System.getProperty("user.dir"))
                .append(Constants.BUSINESS_MODULE_NAME)
                .append(Constants.SRC_MAIN_JAVA)
                .append(Constants.COM_DMALL)
                .append(Constants.PACKAGE_MODULE_NAME)
                .append(File.separator)
                .append(Constants.SERVICE)
                .append(File.separator)
                .append(Constants.IMPL)
                .append(File.separator)
                .append(entityName.toLowerCase())
                .append(File.separator)
                ;
        return append;
    }
}