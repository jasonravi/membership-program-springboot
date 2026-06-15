package com.firstclub.tier;

import com.firstclub.domain.tier.MembershipTier;
import com.firstclub.domain.user.UserMetrics;
import com.firstclub.strategy.TierEligibilityStrategy;

import java.util.List;

public class TierRule {

    private final MembershipTier tier;

    private final List<TierEligibilityStrategy>
            strategies;

    public TierRule(
            MembershipTier tier,
            List<TierEligibilityStrategy>
                    strategies) {

        this.tier = tier;
        this.strategies = strategies;
    }

    public MembershipTier getTier() {
        return tier;
    }

    public boolean evaluate(
            UserMetrics metrics) {

        return strategies.stream()
                .allMatch(
                        strategy ->
                                strategy.isEligible(
                                        metrics
                                )
                );
    }
}