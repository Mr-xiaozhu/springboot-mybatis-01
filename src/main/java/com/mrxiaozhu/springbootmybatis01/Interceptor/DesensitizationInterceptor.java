package com.mrxiaozhu.springbootmybatis01.Interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

@RestControllerAdvice("com.mrxiaozhu.springbootmybatis01.controller")
public class DesensitizationInterceptor implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
//        Annotation[] annotations = returnType.getMethodAnnotations();
//        for (Annotation annotation : annotations) {
//            if (annotation instanceof Desensitization) {
//                return true;
//            }
//        }
//        return false;
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        JSONObject responseJson = JSONObject.parseObject(JSON.toJSONString(body));
//        responseJson.keySet().forEach(x -> {
//            if (StatusEnum.valueCode(x) != null) {
//                String data = String.valueOf(responseJson.get(x));
//                responseJson.put(x, mobilePhone(data));
//            }
//        });
        System.out.println("拦截到了。。。。。");
        return JSONObject.parseObject(JSON.toJSONString(body, ValueDesensitizeFilter.instance));
    }


    public static String mobilePhone(String num) {
        if (StringUtils.isEmpty(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }
}
