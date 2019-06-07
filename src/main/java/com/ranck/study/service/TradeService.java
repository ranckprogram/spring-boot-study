package com.ranck.study.service;

import com.ranck.study.domain.User;
import com.ranck.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TradeService {
    @Autowired
    private UserRepository userRepository;

    public String trade (Integer payerId, Integer payeeId, BigDecimal money) {
        Optional<User> payerOptional = userRepository.findAllById(payerId);
        Optional<User> payeeOptional = userRepository.findAllById(payeeId);

        if (payerOptional.isPresent() && payeeOptional.isPresent()) {
            User payer = payerOptional.get();
            User payee = payeeOptional.get();
            payer.setMoney(payer.getMoney().subtract(money));
            payee.setMoney(payee.getMoney().add(money));
            userRepository.save(payer);
            userRepository.save(payee);
        }

        return "";
    }
}
