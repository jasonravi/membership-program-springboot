package com.firstclub.domain.benefit.impl;

import com.firstclub.domain.benefit.Benefit;

public class FreeDeliveryBenefit implements Benefit {

    @Override
    public String getName() {
        return "FREE_DELIVERY";
    }

    @Override
    public String getDescription() {
        return "Unlimited free delivery";
    }
}