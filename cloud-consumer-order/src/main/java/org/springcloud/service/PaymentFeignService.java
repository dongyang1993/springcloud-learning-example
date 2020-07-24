package org.springcloud.service;

import org.springcloud.entity.CommonResult;
import org.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient("CLOUD-PAYMET-SERVICE")
public interface PaymentFeignService {

    String PREFFIX = "payment";

    @PostMapping(PREFFIX + "/create")
    CommonResult<Integer> create(@ModelAttribute Payment payment);


    @GetMapping(PREFFIX + "/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}
