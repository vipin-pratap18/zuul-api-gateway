package com.demo.apigateway.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import static com.demo.apigateway.constants.GatewayConstants.*;

/**
 * This is generic fall-back provider for handling the situations where service instance is down or 
 * taking too long to respond.
 * @VipinK 
 */
@Component
public class ServiceFallbackProvider implements ZuulFallbackProvider {

	private static final Logger LOG = LoggerFactory.getLogger(ServiceFallbackProvider.class);
	
	@Override
	public ClientHttpResponse fallbackResponse() {
		String methodName = "fallbackResponse()";
		LOG.debug(EXECUTING, methodName);
		return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.SERVICE_UNAVAILABLE;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 503;
            }

            @Override
            public String getStatusText() throws IOException {
                return SERVICE_UNAVAILABLE;
            }

            @Override
            public void close() {
                //no impl needed
            }

            @Override
            public InputStream getBody() throws IOException {
            	LOG.debug(SERVICE_UNAVAILABLE);
                return new ByteArrayInputStream(SERVICE_UNAVAILABLE_MESSAGE.getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                LOG.debug("Setting the fallback header in response");
                headers.set(FALLBACK_HEADER_KEY, FALLBACK_HEADER_VALUE);
                return headers;
            }
        };
          
	}

	@Override
	public String getRoute() {
		return "*";
	}

}
