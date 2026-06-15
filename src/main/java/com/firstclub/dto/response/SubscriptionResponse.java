package com.firstclub.dto.response;

import com.firstclub.domain.subscription.Subscription;

import java.time.LocalDate;

public class SubscriptionResponse {

    private String subscriptionId;

    private String tier;

    private String plan;

    private LocalDate expiryDate;

    public static SubscriptionResponse from(
            Subscription subscription) {

        SubscriptionResponse response =
                new SubscriptionResponse();

        response.subscriptionId =
                subscription.getId();

        response.tier =
                subscription.getTier().name();

        response.plan =
                subscription.getPlan()
                        .getType()
                        .name();

        response.expiryDate =
                subscription.getExpiryDate();

        return response;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public String getTier() {
        return tier;
    }

    public String getPlan() {
        return plan;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}