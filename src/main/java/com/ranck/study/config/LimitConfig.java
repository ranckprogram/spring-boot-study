package com.ranck.study.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ConfigurationProperties(prefix = "limit")
public class LimitConfig {
    private BigDecimal maxMoney;
    private String show;

    public BigDecimal getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(BigDecimal maxMoney) {
        this.maxMoney = maxMoney;
    }

    public String getShow() {
        return show;
    }

    public void  setShow(String show) {
        this.show = show;
    }
}
