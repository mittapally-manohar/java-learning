package org.consistent.practice.dsa.day1.ratelimiter.fixedwindowwithcreditsystem;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private final int requestLimit;
    private final Duration windowSize;
    private final int maxCredits;

    Map<Integer, Customer> customers = new HashMap<>();

    public RateLimiter(int requestLimit, int maxCredits, Duration windowSize) {
        this.requestLimit = requestLimit;
        this.windowSize = windowSize;
        this.maxCredits = maxCredits;
    }

    public boolean rateLimit(int customerId) {
        long currentWindowNumber = System.currentTimeMillis() / windowSize.toMillis();

        Customer customer = customers.computeIfAbsent(customerId, (x) -> new Customer(0, currentWindowNumber, 0));

        if (currentWindowNumber > customer.getWindowNumber()) {
            int unusedRequest = requestLimit - customer.getRequestCount();
            customer.addCredits(unusedRequest, maxCredits);
            customer.reset(currentWindowNumber); // following tell, don't ask principle
        }

        if (customer.getRequestCount() < requestLimit) {
            customer.increment();
            return false;
        } else if (customer.getCredits() > 0) {
            customer.useCredits();
            return false;
        }
        return true;
    }
}
