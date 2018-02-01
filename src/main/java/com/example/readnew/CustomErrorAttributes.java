package com.example.readnew;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * @Author: cpzh
 * @Date: 2018/2/1 22:03
 * TODO:
 */
public class CustomErrorAttributes extends DefaultErrorAttributes{
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes,
                                                  boolean includeStackTrace) {
        Map<String, Object> attributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
        attributes.put("foo", "bar");
        return attributes;
    }
}
