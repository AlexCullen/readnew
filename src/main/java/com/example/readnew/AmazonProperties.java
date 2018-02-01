package com.example.readnew;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: cpzh
 * @Date: 2018/2/1 21:47
 * TODO:
 */
@Component
@ConfigurationProperties("amazon")
public class AmazonProperties {
    private String associateId;

    public String getAssociateId() {
        return associateId;
    }

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }
}
