package com.demo.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.demo.apigateway.constants.GatewayConstants.*;

@Component
public class CORSFilter implements Filter {

	private static final Logger LOG = LoggerFactory.getLogger(CORSFilter.class);

	@Value("${request.allowed.origins}")
	private String allowedOrigins;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//No need to provide initialization logic manually
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String method = "doFilter()";
		LOG.debug(METHOD_ENTER, method);
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest req  = (HttpServletRequest) request;
		res.setHeader("Access-Control-Allow-Origin", allowedOrigins);
		res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept, x-requested-with, Cache-Control");
		if("OPTIONS".equalsIgnoreCase(req.getMethod())) {
			LOG.debug(OPTION_REQUEST);
			return;
		}
		if ("TRACE".equalsIgnoreCase(req.getMethod())){
			LOG.debug("TRACE request");
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return;
		}
		res.addHeader("Strict-Transport-Security", "max-age=31536000");
		LOG.debug(NORMAL_REQUEST);
		chain.doFilter(request, res);
	}

	@Override
	public void destroy() {
		//No need to provide destroy logic manually
	}
}