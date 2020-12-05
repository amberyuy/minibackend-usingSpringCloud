package com.minibackend.homepage.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

/**
 * 在过滤器中存储客户端发起请求的时间戳
 */
@Slf4j
@Component
public class PreRequestFilter extends ZuulFilter {

    @Override
    public String filterType() {

        // 过滤器的类型
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    } // 过滤器的执行顺序，越小优先级越高

    @Override
    public boolean shouldFilter() {

        // 是否启用当前的过滤器
        return true;
    }

    @Override
    public Object run() {

        // 用于在过滤器之间传递消息。它的数据保存在每个请求的 ThreadLocal 中。它用于存储请求路由到哪里、错误、HttpServletRequest、
        // HttpServletResponse 都存储在 RequestContext中。RequestContext 扩展了 ConcurrentHashMap, 所以,
        // 任何数据都可以存储在上下文中。
        RequestContext ctx = RequestContext.getCurrentContext();

        // 存储客户端发起请求的时间戳
        ctx.set("startTime", System.currentTimeMillis());

        return null;
    }
}
