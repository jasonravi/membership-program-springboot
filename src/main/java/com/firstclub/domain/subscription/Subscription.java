package com.firstclub.domain.subscription;

import com.firstclub.domain.membership.MembershipPlan;
import com.firstclub.domain.tier.MembershipTier;

import java.time.LocalDate;

public class Subscription {

    private final String id;

    private final String userId;

    private final MembershipPlan plan;

    private final MembershipTier tier;

    private final LocalDate startDate;

    private final LocalDate expiryDate;

    private final SubscriptionStatus status;

    public Subscription(
            String id,
            String userId,
            MembershipPlan plan,
            MembershipTier tier,
            LocalDate startDate,
            LocalDate expiryDate,
            SubscriptionStatus status) {

        this.id = id;
        this.userId = userId;
        this.plan = plan;
        this.tier = tier;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public MembershipTier getTier() {
        return tier;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public SubscriptionStatus getStatus() {
        return status;
    }
}