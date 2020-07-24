package org.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springcloud.entity.CommonResult;
import org.springcloud.entity.Payment;
import org.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/consumer/payment")
@RestController
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/create")
    public CommonResult<Integer> create(Payment payment) {
        return paymentFeignService.create(payment);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
