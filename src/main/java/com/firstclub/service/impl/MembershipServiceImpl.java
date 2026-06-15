package com.firstclub.service.impl;

import com.firstclub.catalog.MembershipPlanCatalog;
import com.firstclub.domain.membership.MembershipPlan;
import com.firstclub.domain.subscription.Subscription;
import com.firstclub.domain.tier.MembershipTier;
import com.firstclub.domain.user.UserMetrics;
import com.firstclub.dto.request.SubscribeRequest;
import com.firstclub.exception.SubscriptionNotFoundException;
import com.firstclub.factory.SubscriptionFactory;
import com.firstclub.lock.LockManager;
import com.firstclub.repository.SubscriptionRepository;
import com.firstclub.service.MembershipService;
import com.firstclub.service.TierService;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

@Service
public class MembershipServiceImpl
        implements MembershipService {

    private final SubscriptionRepository repository;

    private final TierService tierService;

    private final SubscriptionFactory factory;

    private final LockManager lockManager;

    public MembershipServiceImpl(
            SubscriptionRepository repository,
            TierService tierService,
            SubscriptionFactory factory,
            LockManager lockManager) {

        this.repository = repository;
        this.tierService = tierService;
        this.factory = factory;
        this.lockManager = lockManager;
    }

    @Override
    public Subscription subscribe(
            SubscribeRequest request) {

        ReentrantLock lock =
                lockManager.getLock(
                        request.getUserId()
                );

        lock.lock();

        try {

            MembershipPlan plan =
                    MembershipPlanCatalog
                            .getPlan(
                                    request.getPlanType()
                            );

            UserMetrics metrics =
                    request.getMetrics();

            MembershipTier tier =
                    tierService
                            .determineTier(
                                    metrics
                            );

            Subscription subscription =
                    factory.create(
                            request.getUserId(),
                            plan,
                            tier
                    );

            repository.save(
                    subscription
            );

            return subscription;

        } finally {

            lock.unlock();
        }
    }

    @Override
    public Subscription getCurrentMembership(
            String userId) {

        return repository
                .findByUserId(userId)
                .orElseThrow(
                        () ->
                                new SubscriptionNotFoundException(
                                        userId
                                )
                );
    }

    @Override
    public void cancel(
            String userId) {

        repository.delete(userId);
    }

    @Override
    public Subscription upgrade(
            String userId) {

        return getCurrentMembership(
                userId
        );
    }

    @Override
    public Subscription downgrade(
            String userId) {

        return getCurrentMembership(
                userId
        );
    }
}
