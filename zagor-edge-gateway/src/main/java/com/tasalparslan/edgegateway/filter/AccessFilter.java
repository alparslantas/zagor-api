package com.tasalparslan.edgegateway.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class AccessFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		HttpServletResponse response = RequestContext.getCurrentContext().getResponse();

		logger.info("REQUEST :: < " + request.getScheme() + " " + request.getLocalAddr() + ":" + request.getLocalPort());
		logger.info("REQUEST :: < " + request.getMethod() + " " + request.getRequestURI() + " " + request.getProtocol());
		logger.info("RESPONSE:: > HTTP:" + response.getStatus());
		final List<String> routingDebug = (List<String>) RequestContext.getCurrentContext().get("routingDebug");
		routingDebug.forEach(logger::info);
		return null;
	}

}
