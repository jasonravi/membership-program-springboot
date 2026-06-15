package com.firstclub.domain.benefit.impl;

import com.firstclub.domain.benefit.Benefit;

public class DiscountBenefit implements Benefit {

    private final double percentage;

    public DiscountBenefit(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }

    @Override
    public String getName() {
        return "DISCOUNT";
    }

    @Override
    public String getDescription() {
        return percentage + "% Discount";
    }
}