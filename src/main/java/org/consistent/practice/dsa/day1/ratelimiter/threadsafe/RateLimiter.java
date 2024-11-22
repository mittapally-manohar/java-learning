package org.consistent.practice.dsa.day1.ratelimiter.threadsafe;

import java.time.Duration;
import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentMap;

public class RateLimiter {
    private final int requestLimit;
    private final Duration windowSize;
    private final ConcurrentMap<Integer, Deque<Long>> customerRequests = new ConcurrentHashMap<>();

    public RateLimiter(int requestLimit, Duration windowSize) {
        this.requestLimit = requestLimit;
        this.windowSize = windowSize;
    }

    public boolean rateLimit(int customerId) {
        long currentTimeMillis = System.currentTimeMillis();
        long windowStart = currentTimeMillis - windowSize.toMillis();

        Deque<Long> requestsTimeStamp = customerRequests.computeIfAbsent(customerId, (x) -> new ConcurrentLinkedDeque<>());

        synchronized (requestsTimeStamp) {
            while (!requestsTimeStamp.isEmpty() && requestsTimeStamp.peekFirst() < windowStart) {
                requestsTimeStamp.pollFirst();
            }

            if (requestsTimeStamp.size() < requestLimit) {
                requestsTimeStamp.addLast(currentTimeMillis);
                return false;
            }
            return true;
        }
    }
}
