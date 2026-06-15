package com.firstclub.factory;

import com.firstclub.domain.membership.MembershipPlan;
import com.firstclub.domain.subscription.Subscription;
import com.firstclub.domain.subscription.SubscriptionStatus;
import com.firstclub.domain.tier.MembershipTier;

import java.time.LocalDate;
import java.util.UUID;

public class SubscriptionFactory {

    public Subscription create(
            String userId,
            MembershipPlan plan,
            MembershipTier tier) {

        return new Subscription(
                UUID.randomUUID().toString(),
                userId,
                plan,
                tier,
                LocalDate.now(),
                LocalDate.now()
                        .plusDays(
                                plan.getDuration()
                                        .toDays()
                        ),
                SubscriptionStatus.ACTIVE
        );
    }
}