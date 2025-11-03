package com.gym.crm.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryApplication {

	private static final Logger logger = LoggerFactory.getLogger(ServiceRegistryApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ServiceRegistryApplication.class, args);

		String port = context.getEnvironment().getProperty("server.port");
		logger.info("=================================================");
		logger.info("Eureka Service Registry Started Successfully");
		logger.info("URL: http://localhost:{}", port);
		logger.info("=================================================");
	}
}