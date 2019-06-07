package com.ranck.study.controller;

import com.ranck.study.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class IndexController {

    @Autowired
    private TradeService tradeService;

    @PostMapping("/trade")
    public String trade (@RequestParam Integer payerId, @RequestParam Integer payeeId, @RequestParam BigDecimal money) {
        tradeService.trade(payerId, payeeId, money);
        return "ok";
    }
}
