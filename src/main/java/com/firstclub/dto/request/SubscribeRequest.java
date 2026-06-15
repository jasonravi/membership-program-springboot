package com.firstclub.dto.request;

import com.firstclub.domain.membership.MembershipPlanType;
import com.firstclub.domain.user.UserMetrics;
import org.jetbrains.annotations.NotNull;

public class SubscribeRequest {

    private String userId;

    private MembershipPlanType planType;

    @NotNull
    private UserMetrics metrics;

    public String getUserId() {
        return userId;
    }

    public MembershipPlanType getPlanType() {
        return planType;
    }

    public UserMetrics getMetrics() {
        return metrics;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPlanType(
            MembershipPlanType planType) {

        this.planType = planType;
    }

    public void setMetrics(
            UserMetrics metrics) {

        this.metrics = metrics;
    }
}