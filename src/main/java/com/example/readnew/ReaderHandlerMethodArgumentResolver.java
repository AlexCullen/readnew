package com.example.readnew;

import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Author: cpzh
 * @Date: 2018/2/1 21:30
 * TODO:
 */
@Component
public class ReaderHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    /**
     * 用于判定是否需要处理该参数分解
     * @param methodParameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return Reader.class.isAssignableFrom(methodParameter.getParameterType());
    }

    /**
     * 真正用于处理参数分解的方法
     * @param methodParameter
     * @param modelAndViewContainer
     * @param nativeWebRequest
     * @param webDataBinderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) throws Exception {
        Authentication auth = (Authentication) nativeWebRequest.getUserPrincipal();
        return auth != null && auth.getPrincipal() instanceof Reader ? auth.getPrincipal() : null;
    }
}
