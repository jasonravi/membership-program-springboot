package com.firstclub.repository.impl;

import com.firstclub.domain.subscription.Subscription;
import com.firstclub.repository.SubscriptionRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemorySubscriptionRepository
        implements SubscriptionRepository {

    private final ConcurrentHashMap<String,
            Subscription> store =
            new ConcurrentHashMap<>();

    @Override
    public void save(
            Subscription subscription) {

        store.put(
                subscription.getUserId(),
                subscription
        );
    }

    @Override
    public Optional<Subscription>
    findByUserId(String userId) {

        return Optional.ofNullable(
                store.get(userId)
        );
    }

    @Override
    public void delete(
            String userId) {

        store.remove(userId);
    }
}