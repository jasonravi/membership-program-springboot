package com.firstclub.service;

import com.firstclub.domain.tier.MembershipTier;
import com.firstclub.domain.user.UserMetrics;

public interface TierService {

    MembershipTier determineTier(
            UserMetrics metrics);
}