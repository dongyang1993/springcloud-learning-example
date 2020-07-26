package org.springcloud.service;

import org.springcloud.entity.CommonResult;
import org.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient("CLOUD-PAYMET-SERVICE")
public interface PaymentFeignService {

    @PostMapping("/payment/create")
    CommonResult<Integer> create(@ModelAttribute Payment payment);


    @GetMapping("/payment/get")
    CommonResult<Payment> getPaymentById(@RequestParam("id") Long id);
}
