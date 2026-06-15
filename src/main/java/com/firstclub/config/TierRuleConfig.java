package com.firstclub.config;

import com.firstclub.domain.tier.MembershipTier;
import com.firstclub.strategy.*;
import com.firstclub.strategy.impl.CohortStrategy;
import com.firstclub.strategy.impl.OrderCountStrategy;
import com.firstclub.strategy.impl.OrderValueStrategy;
import com.firstclub.tier.*;

import org.springframework.context.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Configuration
public class TierRuleConfig {

    @Bean
    public TierEngine tierEngine() {

        TierRule goldRule =
                new TierRule(

                        MembershipTier.GOLD,

                        List.of(
                                new OrderCountStrategy(10),
                                new OrderValueStrategy(
                                        BigDecimal.valueOf(
                                                10000
                                        )
                                )
                        )
                );

        TierRule platinumRule =
                new TierRule(

                        MembershipTier.PLATINUM,

                        List.of(
                                new OrderCountStrategy(25),
                                new OrderValueStrategy(
                                        BigDecimal.valueOf(
                                                25000
                                        )
                                ),
                                new CohortStrategy(
                                        Set.of(
                                                "VIP"
                                        )
                                )
                        )
                );

        return new TierEngine(
                List.of(
                        goldRule,
                        platinumRule
                )
        );
    }
}