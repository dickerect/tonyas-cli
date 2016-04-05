package com.throwawaycode;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class TonyasCliApplication {

	public static void main(String[] args) {
		SpringApplication.run(TonyasCliApplication.class, args);
	}


    private static final Logger LOG = LoggerFactory.getLogger(TonyasCliApplication.class);

    @Value("${cli.message}")
    private String message;

    @Resource
    private KeithsSillyBean keithsSillyBean;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return strings -> {
            LOG.info("=================================================================================");
            LOG.info("Put your run logic here!  (whatever is currently in your current main method)");
            LOG.info("output of value for 'cli.message' --->{}", message);
            LOG.info("---------------------------------------------------------------------------------");
            LOG.info("If you need to grab an existing bean, just add an @Resource to TonyasCliApplication.");
            LOG.info("I've injected KeithsSillyBean to demonstrate calling a bean's method:");
            keithsSillyBean.makeStuffHappen();
            LOG.info("=================================================================================");
        };
    }
}
