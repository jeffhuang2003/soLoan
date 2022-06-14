package com.psc.scLoan.config;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fori.util.DateUtil;
import com.psc.scLoan.Application;
import com.psc.scLoan.constants.Constants;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(Application.class)
public class SwaggerConfig {
	@Autowired
	private PropConfig fileConfig;
	@Bean
	public Docket petApi() {
		ArrayList<ResponseMessage> responseMessages = new ArrayList<ResponseMessage>() {
			private static final long serialVersionUID = 1L;

			{
				add(new ResponseMessageBuilder().code(200).message("成功").build());
			}
		};

		ParameterBuilder tokenPar = new ParameterBuilder();
		// JWT TOKEN HEADER
		List<Parameter> pars = new ArrayList<>();
		tokenPar.name("Authorization").description("JWT TOKEN").modelRef(new ModelRef("string")).parameterType("header")
				.required(false).build();
		pars.add(tokenPar.build());

		return new Docket(DocumentationType.SWAGGER_2).groupName("scLoan").apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.psc.scLoan")).paths(PathSelectors.any()).build()
				.pathMapping("/").useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, responseMessages)
				.globalResponseMessage(RequestMethod.POST, responseMessages)
				.globalResponseMessage(RequestMethod.PUT, responseMessages)
				.globalResponseMessage(RequestMethod.DELETE, responseMessages);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("PSC-scLoan").description(fileConfig.getProjectName()+fileConfig.getDomainUrl())
				.version(DateUtil.format(new Date(), Constants.DATE_PATTERN)).build();
	}

}