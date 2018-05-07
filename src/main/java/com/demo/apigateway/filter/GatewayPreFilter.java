package com.demo.apigateway.filter;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import static com.demo.apigateway.constants.GatewayConstants.*;

/**
 * This is API gateway pre-filter for validating the request token and stamping the gateway secret
 * @VipinK 
 */
@Component
public class GatewayPreFilter extends ZuulFilter {

	private static final Logger LOG = LoggerFactory.getLogger(GatewayPreFilter.class);
	@Autowired
	private DiscoveryClient discoveryClient;

	@Override
	public Object run() {
		String method = "run()";
		LOG.debug(METHOD_ENTER, method);
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		LOG.debug("Requested URL is : {}", request.getRequestURL());
		LOG.debug(METHOD_EXIT, method);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return PRE_TYPE;
	}
}
