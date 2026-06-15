package com.firstclub.domain.membership;

import java.math.BigDecimal;
import java.time.Duration;

public class MembershipPlan {

    private final MembershipPlanType type;

    private final BigDecimal price;

    private final Duration duration;

    public MembershipPlan(
            MembershipPlanType type,
            BigDecimal price,
            Duration duration) {

        this.type = type;
        this.price = price;
        this.duration = duration;
    }

    public MembershipPlanType getType() {
        return type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Duration getDuration() {
        return duration;
    }
}