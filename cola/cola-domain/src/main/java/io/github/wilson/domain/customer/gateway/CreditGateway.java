package io.github.wilson.domain.customer.gateway;

import io.github.wilson.domain.customer.Customer;
import io.github.wilson.domain.customer.Credit;

//Assume that the credit info is in antoher distributed Service
public interface CreditGateway {
    public Credit getCredit(String customerId);
}
