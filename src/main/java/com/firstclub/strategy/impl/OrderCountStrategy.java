package com.firstclub.strategy.impl;

import com.firstclub.domain.user.UserMetrics;
import com.firstclub.strategy.TierEligibilityStrategy;

public class OrderCountStrategy
        implements TierEligibilityStrategy {

    private final int threshold;

    public OrderCountStrategy(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean isEligible(
            UserMetrics metrics) {

        return metrics.getMonthlyOrderCount()
                >= threshold;
    }
}