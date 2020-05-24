package org.springcloud.service;

import org.springcloud.entity.Payment;

public interface PaymetService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
