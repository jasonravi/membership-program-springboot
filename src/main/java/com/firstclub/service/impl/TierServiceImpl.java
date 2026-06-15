package com.firstclub.service.impl;

import com.firstclub.domain.tier.MembershipTier;
import com.firstclub.domain.user.UserMetrics;
import com.firstclub.service.TierService;
import com.firstclub.tier.TierEngine;
import org.springframework.stereotype.Service;

@Service
public class TierServiceImpl
        implements TierService {

    private final TierEngine tierEngine;

    public TierServiceImpl(
            TierEngine tierEngine) {

        this.tierEngine = tierEngine;
    }

    @Override
    public MembershipTier determineTier(
            UserMetrics metrics) {

        return tierEngine
                .determineTier(metrics);
    }
}