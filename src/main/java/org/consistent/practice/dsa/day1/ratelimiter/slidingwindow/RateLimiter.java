package org.consistent.practice.dsa.day1.ratelimiter.slidingwindow;

import java.time.Duration;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RateLimiter {
    private final int requestLimit;
    private final Duration windowSize;
    private Map<Integer, Deque<Long>> customerRequests = new HashMap<>();

    public RateLimiter(int requestLimit, Duration windowSize){
        this.requestLimit = requestLimit;
        this.windowSize = windowSize;
    }

    public boolean rateLimit(int customerId){
        long currentTimeMillis = System.currentTimeMillis();
        long currentWindowNumber = currentTimeMillis - windowSize.toMillis();

        Deque<Long> requestsTimeStamp = customerRequests.computeIfAbsent(customerId, (x)-> new LinkedList<>());

        while(!requestsTimeStamp.isEmpty() && requestsTimeStamp.peekFirst() < currentWindowNumber){
            requestsTimeStamp.pollFirst();
        }

        if(requestsTimeStamp.size() < requestLimit){
            requestsTimeStamp.addLast(currentTimeMillis);
            return false;
        }
        return true;
    }
}
