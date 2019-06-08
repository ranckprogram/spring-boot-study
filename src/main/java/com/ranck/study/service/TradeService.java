package com.ranck.study.service;

import com.ranck.study.domain.User;
import com.ranck.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TradeService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String trade(Integer payerId, Integer payeeId, BigDecimal money) {
        User payer = userRepository.findAllById(payerId);
        User payee = userRepository.findAllById(payeeId);


        payer.setMoney(payer.getMoney().subtract(money));
        payee.setMoney(payee.getMoney().add(money));
        userRepository.save(payer);
        userRepository.save(payee);


        return "";
    }
}
