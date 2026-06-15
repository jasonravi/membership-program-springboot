package com.firstclub.exception;

public class SubscriptionNotFoundException
        extends RuntimeException {

    public SubscriptionNotFoundException(
            String userId) {

        super("Subscription not found : "
                + userId);
    }
}