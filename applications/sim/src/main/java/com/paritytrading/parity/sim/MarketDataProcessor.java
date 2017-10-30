package com.paritytrading.parity.sim;

import com.paritytrading.parity.book.Market;
import com.paritytrading.parity.book.Side;
import com.paritytrading.parity.net.pmd.PMD;
import com.paritytrading.parity.net.pmd.PMDListener;

import org.slf4j.*;

class MarketDataProcessor implements PMDListener {

    static Logger logger = LoggerFactory.getLogger(MarketDataProcessor.class);

    private Market market;

    public MarketDataProcessor(Market market) {
        this.market = market;
    }

    @Override
    public void version(PMD.Version message) {
    }

    @Override
    public void orderAdded(PMD.OrderAdded message) {
        market.add(message.instrument, message.orderNumber, side(message.side),
                message.price, message.quantity);
        logger.info("PMD.OrderAdded orderNumber={} side={} price={}", message.orderNumber, side(message.side), message.price);
    }

    @Override
    public void orderExecuted(PMD.OrderExecuted message) {
        market.execute(message.orderNumber, message.quantity);
        logger.info("PMD.OrderExecuted orderNumber={}", message.orderNumber);
    }

    @Override
    public void orderCanceled(PMD.OrderCanceled message) {
        market.cancel(message.orderNumber, message.canceledQuantity);
        logger.info("PMD.OrderCanceled orderNumber={}", message.orderNumber);
    }

    private Side side(byte side) {
        switch (side) {
        case PMD.BUY:
            return Side.BUY;
        case PMD.SELL:
            return Side.SELL;
        }

        return null;
    }

}
