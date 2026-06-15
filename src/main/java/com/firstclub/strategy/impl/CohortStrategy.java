package com.firstclub.strategy.impl;

import com.firstclub.domain.user.UserMetrics;
import com.firstclub.strategy.TierEligibilityStrategy;

import java.util.Set;

public class CohortStrategy
        implements TierEligibilityStrategy {

    private final Set<String> cohorts;

    public CohortStrategy(
            Set<String> cohorts) {

        this.cohorts = cohorts;
    }

    @Override
    public boolean isEligible(
            UserMetrics metrics) {

        return cohorts.contains(
                metrics.getCohort()
        );
    }
}