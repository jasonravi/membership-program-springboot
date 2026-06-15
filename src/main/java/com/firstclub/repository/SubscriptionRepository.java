package com.firstclub.repository;

import com.firstclub.domain.subscription.Subscription;

import java.util.Optional;

public interface SubscriptionRepository {

    void save(
            Subscription subscription);

    Optional<Subscription> findByUserId(
            String userId);

    void delete(
            String userId);
}