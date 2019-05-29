package com.yjj.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

@Component
public class LoggerFilter extends ZuulFilter {
    private static final Logger logger=LoggerFactory.getLogger(LoggerFilter.class);

    @Autowired
    private Tracer tracer;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        tracer.addTag("operator","yjj");
        logger.info("---traceId:{}"+tracer.getCurrentSpan().traceIdString());
        return null;
    }
}
