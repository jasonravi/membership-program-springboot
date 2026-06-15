package com.firstclub.domain.user;

import java.math.BigDecimal;

public class UserMetrics {

    private final int monthlyOrderCount;

    private final BigDecimal monthlyOrderValue;

    private final String cohort;

    public UserMetrics(
            int monthlyOrderCount,
            BigDecimal monthlyOrderValue,
            String cohort) {

        this.monthlyOrderCount = monthlyOrderCount;
        this.monthlyOrderValue = monthlyOrderValue;
        this.cohort = cohort;
    }

    public int getMonthlyOrderCount() {
        return monthlyOrderCount;
    }

    public BigDecimal getMonthlyOrderValue() {
        return monthlyOrderValue;
    }

    public String getCohort() {
        return cohort;
    }
}