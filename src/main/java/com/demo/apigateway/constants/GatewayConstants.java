package com.demo.apigateway.constants;

/**
 * @author : VipinK
 * @since : Apr 28, 2017
 */
public class GatewayConstants {

	private GatewayConstants() {
		//as no instances should be made
	}

	public static final String FALLBACK_MESSAGE = "Service is down due to maintenance activity";
	public static final String METHOD_ENTER = "Entering into methdod : {}";
	public static final String METHOD_EXIT = "Exiting from methdod : {}";
	public static final String EXECUTING = "Executing {} ";
	public static final String OPTION_REQUEST = "Option preflight request, so returning to allow cross origin requests";
	public static final String NORMAL_REQUEST = "Normal request, so forwarding it by adding CORS headers";
	public static final String FALLBACK_HEADER_KEY = "Fallback_Header";
	public static final String FALLBACK_HEADER_VALUE = "Fallback";
	public static final String SERVICE_UNAVAILABLE = "Service Unavailable";
	public static final String SERVICE_UNAVAILABLE_MESSAGE = "Service Unavailable, Please try again after some time";
}
