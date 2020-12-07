package io.github.wilson.domain.customer.gateway;

import io.github.wilson.domain.customer.Customer;

public interface CustomerGateway {
    public Customer getByById(String customerId);
}
