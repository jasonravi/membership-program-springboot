package com.firstclub.strategy.impl;

import com.firstclub.domain.user.UserMetrics;
import com.firstclub.strategy.TierEligibilityStrategy;

import java.math.BigDecimal;

public class OrderValueStrategy
        implements TierEligibilityStrategy {

    private final BigDecimal threshold;

    public OrderValueStrategy(
            BigDecimal threshold) {

        this.threshold = threshold;
    }

    @Override
    public boolean isEligible(
            UserMetrics metrics) {

        return metrics.getMonthlyOrderValue()
                .compareTo(threshold) >= 0;
    }
}