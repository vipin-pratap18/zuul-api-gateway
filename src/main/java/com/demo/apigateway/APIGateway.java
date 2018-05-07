package com.demo.apigateway;

import org.eclipse.jetty.servlets.DoSFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import java.util.Date;

import javax.servlet.SessionCookieConfig;

/**
 * This is zuul proxy server starting point which configures zuul proxy server and register it with
 * service discovery.
 * Also enabling hystrix dashboard to monitor the success and failed requests.
 * taking too long to respond.
 *
 * @VipinK
 */
@EnableHystrixDashboard
@EnableZuulProxy
@SpringBootApplication
public class APIGateway {
	
	private static final Logger LOG = LoggerFactory.getLogger(APIGateway.class);

    public static void main(String[] args) {
    		LOG.info("***** STARTING API GATEWAY at :{} *****", new Date());
        SpringApplication.run(APIGateway.class, args);
        LOG.info("***** STARTEDs API GATEWAY at :{} *****", new Date());
    }

}
