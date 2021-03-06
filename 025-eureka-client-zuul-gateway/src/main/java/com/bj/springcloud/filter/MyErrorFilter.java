package com.bj.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class MyErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        ZuulException exception = (ZuulException)context.getThrowable();
        HttpServletResponse response = context.getResponse();

        response.setStatus(exception.nStatusCode);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=null;

        try {
            out = response.getWriter();
            out.println(exception.nStatusCode+exception.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out!=null){
                out.close();
            }
        }


        return null;
    }
}
