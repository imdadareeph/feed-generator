package com.solvians.feedgenerator;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class FeedGeneratorApplication extends SpringBootServletInitializer {

        public static void main(String[] args) {
            SpringApplication.run(com.solvians.feedgenerator.FeedGeneratorApplication.class, args);
            //List<String> input = new ArrayList<>();
            int noOfThreads=0;
            int noOfCertificates = 0;
            if(null!=args && args.length>2 || args.length==1){
                System.out.println("Please enter only 2 arguments noOfThreads and noOfCertificates");
            }else{
                noOfThreads=Integer.valueOf(args[0]);
                noOfCertificates=Integer.valueOf(args[1]);
            }

            CertificateUpdaterMainClass.runCertificateUpdater(noOfThreads,noOfCertificates);

        }


	// adding this in case we go via open api approach to check the feed generator algorithm
	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption, @Value("${application-version}") String appVersion) {
		return new OpenAPI()
				.info(new Info()
						.title("feedgenerator application API")
						.version(appVersion)
						.description(appDesciption)
						.termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
