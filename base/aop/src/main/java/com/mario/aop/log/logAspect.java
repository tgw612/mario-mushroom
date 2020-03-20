package com.mario.aop.log;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
public class logAspect {
    //定义一个切面@Configurationpublicclass LogRecordAspect
    private static final Logger log = LoggerFactory.getLogger(logAspect.class);

    // 定义切点Pointcut
    @Pointcut(value = "execution(* com.mario.aop.*Controller.*(..))")
    public void excudeService() {

    }

    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
//        String queryString = request.getQueryString();
        String queryString = JSONObject.toJSONString(pjp.getArgs());
        log.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
        // result的值就是被拦截方法的返回值Object result = pjp.proceed();
        Object result = pjp.proceed();
        log.info("请求结束，controller的返回值是 " + JSONObject.toJSONString(result));
        return result;

    }

}
