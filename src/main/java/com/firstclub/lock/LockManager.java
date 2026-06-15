package com.firstclub.lock;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class LockManager {

    private final ConcurrentHashMap<
            String,
            ReentrantLock> locks =
            new ConcurrentHashMap<>();

    public ReentrantLock getLock(
            String userId) {

        return locks.computeIfAbsent(
                userId,
                key -> new ReentrantLock()
        );
    }
}