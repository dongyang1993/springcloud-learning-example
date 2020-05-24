package org.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springcloud.entity.CommonResult;
import org.springcloud.entity.Payment;
import org.springcloud.service.PaymetService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PaymentController {

    private final PaymetService paymetService;

    public PaymentController(PaymetService paymetService) {
        this.paymetService = paymetService;
    }

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@ModelAttribute Payment payment) {
        int result = paymetService.create(payment);
        log.info("********插入结果：{}*******", result);
        if (result > 0) {
            return new CommonResult<>(200, "插入数据库成功", result);
        } else {
            return new CommonResult<>(444, "插入数据库失败", result);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymetService.getPaymentById(id);
        log.info("插入结果:{}", payment);

        if (payment != null) {
            return new CommonResult<>(200, "查询成功", payment);
        } else {
            return new CommonResult<>(444, "没有对应记录", null);
        }
    }
}
