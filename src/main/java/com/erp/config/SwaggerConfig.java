package com.erp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: guarantee-card
 * @description: swagger配置
 * @author: Pandora
 * @create: 2020-02-05 15:42
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 通过 createRestApi函数来构建一个DocketBean
     * 函数名,可以随意命名,喜欢什么命名就什么命名
     */
    @Bean
    public Docket createRestApi(){
        //控制暴露出去的路径下的实例
        //如果某个接口不想暴露,可以使用以下注解
        //@ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
//        return new Docket(DocumentationType.SWAGGER_2)
//                .enable(true)
//                .apiInfo(apiInfo()).select()  //调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
//                .paths(PathSelectors.any())
//                .build();
        ParameterBuilder token = new ParameterBuilder();
        ParameterBuilder adminId = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        token.name("token").description("token").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        adminId.name("adminId").description("adminId").modelRef(new ModelRef("integer")).parameterType("header")
                .required(false).build();
        pars.add(token.build());
        pars.add(adminId.build());

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.erp.controller"))// 扫描该包下的所有需要在Swagger中展示的API，@ApiIgnore注解标注的除外
                .paths(PathSelectors.any()).build().globalOperationParameters(pars);
    }

    //构建 api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("api 文档")
                //版本号
                .version("1.0")
                //描述
                .description("restful api接口文档")
                .build();
    }
}
