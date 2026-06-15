package com.firstclub.tier;

import com.firstclub.domain.tier.MembershipTier;
import com.firstclub.domain.user.UserMetrics;

import java.util.List;

public class TierEngine {

    private final List<TierRule> rules;

    public TierEngine(
            List<TierRule> rules) {

        this.rules = rules;
    }

    public MembershipTier determineTier(
            UserMetrics metrics) {

        MembershipTier result =
                MembershipTier.SILVER;

        for (TierRule rule : rules) {

            if (rule.evaluate(metrics)) {
                result = rule.getTier();
            }
        }

        return result;
    }
}