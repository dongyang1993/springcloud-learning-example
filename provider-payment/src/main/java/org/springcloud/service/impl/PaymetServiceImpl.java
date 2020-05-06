package org.springcloud.service.impl;

import org.springcloud.dao.PaymentDao;
import org.springcloud.entity.Payment;
import org.springcloud.service.PaymetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymetServiceImpl implements PaymetService {


    /**
     * Mybatis的mapper注入爆红的解决办法
     * 方法1. 用@Resource注解，就可以了，这是JSR250提供的注解
     * 方法2. 在Mapper上除了@Mapper注解之外，再加一个@Repository/@Component注解，将其注册为一个Bean
     */
    private final PaymentDao paymentDao;

    @Autowired
    public PaymetServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
