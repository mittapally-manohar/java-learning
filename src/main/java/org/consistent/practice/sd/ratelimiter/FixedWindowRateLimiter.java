package org.consistent.practice.sd.ratelimiter;

import java.util.HashMap;
import java.util.Map;

/**
 * Verdict: ❌ Worst choice! No thread safety, no scalability, and bursty traffic issues.
 */
public class FixedWindowRateLimiter {
    private final int maxRequests;
    private final long windowSizeInMillis;
    private final Map<String, Integer> requestCounts  = new HashMap<>();
    private long windowStart;

    public FixedWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        windowStart = System.currentTimeMillis();
    }

    public boolean allowRequest(String userId) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - windowStart > windowSizeInMillis) {
            requestCounts.clear();
            windowStart = currentTime;
        }
        requestCounts .put(userId, requestCounts .getOrDefault(userId,0)+1);

        return requestCounts.get(userId) <= maxRequests;
    }

    public static void main(String[] args) throws InterruptedException {
        FixedWindowRateLimiter rateLimiter = new FixedWindowRateLimiter(5, 10000); // 5 requests per 10 seconds

        String userId = "user1";

        // Simulate 6 requests
        for (int i = 0; i < 6; i++) {
            if (rateLimiter.allowRequest(userId)) {
                System.out.println("Request " + (i + 1) + " allowed");
            } else {
                System.out.println("Request " + (i + 1) + " denied");
            }
        }

        // Wait for the window to reset
        Thread.sleep(10000);

        // Simulate another request after the window reset
        if (rateLimiter.allowRequest(userId)) {
            System.out.println("Request after window reset allowed");
        } else {
            System.out.println("Request after window reset denied");
        }
    }
}
