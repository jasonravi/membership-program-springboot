package com.firstclub.domain.tier;

import com.firstclub.domain.benefit.Benefit;

import java.util.List;

public class TierConfiguration {

    private final MembershipTier tier;

    private final List<Benefit> benefits;

    public TierConfiguration(
            MembershipTier tier,
            List<Benefit> benefits) {

        this.tier = tier;
        this.benefits = benefits;
    }

    public MembershipTier getTier() {
        return tier;
    }

    public List<Benefit> getBenefits() {
        return benefits;
    }
}