package com.firstclub.service;

import com.firstclub.domain.subscription.Subscription;
import com.firstclub.dto.request.SubscribeRequest;

public interface MembershipService {

    Subscription subscribe(
            SubscribeRequest request);

    Subscription upgrade(
            String userId);

    Subscription downgrade(
            String userId);

    void cancel(
            String userId);

    Subscription getCurrentMembership(
            String userId);
}