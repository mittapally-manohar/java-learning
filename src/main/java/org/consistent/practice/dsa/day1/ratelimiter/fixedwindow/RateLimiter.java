package org.consistent.practice.dsa.day1.ratelimiter.fixedwindow;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private final int requestLimit;
    private final Duration windowSize;

    Map<Integer, Customer> customers = new HashMap<>();

    public RateLimiter(int requestLimit, Duration windowSize) {
        this.requestLimit = requestLimit;
        this.windowSize = windowSize;
    }

    public boolean rateLimit(int customerId){
        long currentWindowNumber = System.currentTimeMillis()/windowSize.toMillis();
        Customer customer = customers.computeIfAbsent(customerId,(x)->new Customer(0,currentWindowNumber));
        if(currentWindowNumber > customer.getWindowNumber()){
            customer.reset(currentWindowNumber); // following tell, don't ask principle
        }
        if(customer.getRequestCount() < requestLimit){
            customer.increment();
            return false;
        }
        return true;
    }
}
