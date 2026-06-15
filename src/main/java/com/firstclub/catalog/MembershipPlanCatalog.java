package com.firstclub.catalog;

import com.firstclub.domain.membership.*;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Map;

public final class MembershipPlanCatalog {

    private MembershipPlanCatalog(){}

    private static final Map<MembershipPlanType,
            MembershipPlan> PLANS =
            Map.of(

                    MembershipPlanType.MONTHLY,

                    new MembershipPlan(
                            MembershipPlanType.MONTHLY,
                            BigDecimal.valueOf(99),
                            Duration.ofDays(30)
                    ),

                    MembershipPlanType.QUARTERLY,

                    new MembershipPlan(
                            MembershipPlanType.QUARTERLY,
                            BigDecimal.valueOf(249),
                            Duration.ofDays(90)
                    ),

                    MembershipPlanType.YEARLY,

                    new MembershipPlan(
                            MembershipPlanType.YEARLY,
                            BigDecimal.valueOf(799),
                            Duration.ofDays(365)
                    )
            );

    public static MembershipPlan getPlan(
            MembershipPlanType type) {

        return PLANS.get(type);
    }

    public static Map<MembershipPlanType,
            MembershipPlan> getPlans() {

        return PLANS;
    }
}