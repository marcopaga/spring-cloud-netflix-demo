package de.codecentric.cloud.edgeservice;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

@Component
public class SleuthResponseFilter extends ZuulFilter {

    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;
    private static final Logger LOGGER = LoggerFactory.getLogger(SleuthResponseFilter.class);

    @Autowired
    private Tracer tracer;

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() {
        final String traceIdString = tracer.getCurrentSpan().traceIdString();
        LOGGER.debug("Response for Span: {}", traceIdString);
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getResponse().addHeader("tmx-correlation-id", traceIdString);
        return null;
    }}
