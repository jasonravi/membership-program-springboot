package com.firstclub.strategy;

import com.firstclub.domain.user.UserMetrics;

public interface TierEligibilityStrategy {

    boolean isEligible(UserMetrics metrics);
}