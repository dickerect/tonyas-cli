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
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@Configuration
// for importing a spring XML context file
@ImportResource(locations = "/application-context.xml")
// for importing a spring config class
@Import(SampleConfiguration.class)

/**
 * This is the equalivalent of your current Main class.
 */
public class TonyasCliApplication {

    private static final Logger LOG = LoggerFactory.getLogger(TonyasCliApplication.class);

    /**
     * This is the entry point.  Note lack of any code, just calling SpringApplication.run.
     * Spring boot has its own way of consuming/parsing cli args.  Basically, any arg that's in the format of
     * --[arg name]=[arg value] when invoking the jar is made available for use in @Value.
     *
     * But what you want is to define where a whole properties file exists, and that's explained in the
     * README.
     *
     * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(TonyasCliApplication.class, args);
	}

    @Value("${cli.message}")
    private String message;

    @Resource
    private KeithsSillyBean keithsSillyBean;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
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
