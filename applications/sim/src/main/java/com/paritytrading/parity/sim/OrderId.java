package com.paritytrading.parity.sim;

import com.paritytrading.parity.util.OrderIDGenerator;

public class OrderId {

    private static OrderIDGenerator generator = new OrderIDGenerator();

    private OrderId() {}

    static synchronized String next() {
        return generator.next();
    }
}
