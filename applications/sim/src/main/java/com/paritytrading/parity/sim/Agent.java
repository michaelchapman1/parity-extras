package com.paritytrading.parity.sim;

import java.io.IOException;

abstract class Agent {

    private OrderEntry orderEntry;

    protected Agent(OrderEntry orderEntry) {
        this.orderEntry = orderEntry;
    }

    public OrderEntry getOrderEntry() {
        return orderEntry;
    }

    abstract void start(long currentTimeMillis) throws IOException;

    abstract void tick(MarketData.TopOfBook topOfBook, long currentTimeMillis) throws IOException;

}
