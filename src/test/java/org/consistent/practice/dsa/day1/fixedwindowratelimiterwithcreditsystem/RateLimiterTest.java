package org.consistent.practice.dsa.day1.fixedwindowratelimiterwithcreditsystem;

import org.consistent.practice.dsa.day1.ratelimiter.fixedwindowwithcreditsystem.RateLimiter;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class RateLimiterTest {

    @Test
    void testBasicRateLimiting() {
        RateLimiter rateLimiter = new RateLimiter(5, 10, Duration.ofSeconds(10));
        int customerId = 1;

        // First 5 requests should pass
        for (int i = 0; i < 5; i++) {
            assertFalse(rateLimiter.rateLimit(customerId));
        }

        // Next request should be rate-limited
        assertTrue(rateLimiter.rateLimit(customerId));
    }

    @Test
    void testExceedingWindowLimitWithoutCredits() {
        RateLimiter rateLimiter = new RateLimiter(5, 10, Duration.ofSeconds(10));
        int customerId = 1;

        // First 5 requests should pass
        for (int i = 0; i < 5; i++) {
            assertFalse(rateLimiter.rateLimit(customerId));
        }

        // 6th and 7th requests should be rate-limited
        assertTrue(rateLimiter.rateLimit(customerId));
        assertTrue(rateLimiter.rateLimit(customerId));
    }

//    @Test
//    void testAccumulatingCredits() throws InterruptedException {
//        RateLimiter rateLimiter = new RateLimiter(5, 10, Duration.ofSeconds(10));
//        int customerId = 1;
//
//        // Use 3 out of 5 requests in the first window
//        for (int i = 0; i < 3; i++) {
//            assertFalse(rateLimiter.rateLimit(customerId));
//        }
//
//        // Wait for the next window
//        Thread.sleep(10000);
//
//        // First 5 requests in the new window should pass
//        for (int i = 0; i < 5; i++) {
//            assertFalse(rateLimiter.rateLimit(customerId));
//        }
//
//        // Verify no credits are used
//        assertTrue(rateLimiter.rateLimit(customerId));
//    }

//    @Test
//    void testUsingCredits() throws InterruptedException {
//        RateLimiter rateLimiter = new RateLimiter(5, 10, Duration.ofSeconds(10));
//        int customerId = 1;
//
//        // Use 3 out of 5 requests in the first window
//        for (int i = 0; i < 3; i++) {
//            assertFalse(rateLimiter.rateLimit(customerId));
//        }
//
//        // Wait for the next window
//        Thread.sleep(10000);
//
//        // Use all 5 requests in the second window
//        for (int i = 0; i < 4; i++) {
//            assertFalse(rateLimiter.rateLimit(customerId));
//        }
//
//        // Next request should use 1 credit
//        assertFalse(rateLimiter.rateLimit(customerId));
//
//        // Next request should be rate-limited as no credits remain
//        assertTrue(rateLimiter.rateLimit(customerId));
//    }

    @Test
    void testExceedingCredits() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 10, Duration.ofSeconds(10));
        int customerId = 1;

        // Use 3 out of 5 requests in the first window
        for (int i = 0; i < 3; i++) {
            assertFalse(rateLimiter.rateLimit(customerId));
        }

        // Wait for the next window
        Thread.sleep(10000);

        // Use all 5 requests in the second window
        for (int i = 0; i < 5; i++) {
            assertFalse(rateLimiter.rateLimit(customerId));
        }

        // Use 2 credits
        assertFalse(rateLimiter.rateLimit(customerId));
        assertFalse(rateLimiter.rateLimit(customerId));

        // Next request should be rate-limited
        assertTrue(rateLimiter.rateLimit(customerId));
    }

    @Test
    void testMaximumCreditCap() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 3, Duration.ofSeconds(10)); // Max credits = 3
        int customerId = 1;
        assertFalse(rateLimiter.rateLimit(customerId));
        // Wait for one window without making requests
        Thread.sleep(10000);

        // Use 8 requests:
        for (int i = 0; i < 8; i++) {
            if (i < 5) {
                // First 5 requests use the current window
                assertFalse(rateLimiter.rateLimit(customerId));
            } else if (i < 8) {
                // Next 3 requests use accumulated credits
                assertFalse(rateLimiter.rateLimit(customerId));
            } else {
                // After credits are exhausted, customer should be rate-limited
                assertTrue(rateLimiter.rateLimit(customerId));
            }
        }
    }

//    @Test
//    void testNoRequests() throws InterruptedException {
//        RateLimiter rateLimiter = new RateLimiter(5, 10, Duration.ofSeconds(10));
//        int customerId = 1;
//        assertFalse(rateLimiter.rateLimit(customerId));
//        // Make no requests for 2 windows
//        Thread.sleep(20000);
//
//        // Customer should accumulate 10 credits (capped)
//        for (int i = 0; i < 15; i++) {
//            if (i < 5) {
//                // Use the current window
//                assertFalse(rateLimiter.rateLimit(customerId));
//            } else if (i < 15) {
//                // Use 10 accumulated credits
//                assertFalse(rateLimiter.rateLimit(customerId));
//            } else {
//                // Rate limit after credits are exhausted
//                assertTrue(rateLimiter.rateLimit(customerId));
//            }
//        }
//    }

    @Test
    void testRapidRequests() {
        RateLimiter rateLimiter = new RateLimiter(5, 10, Duration.ofSeconds(10));
        int customerId = 1;

        // Send 10 requests in rapid succession
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                // First 5 requests should be allowed
                assertFalse(rateLimiter.rateLimit(customerId));
            } else {
                // Next 5 requests should be rate-limited
                assertTrue(rateLimiter.rateLimit(customerId));
            }
        }
    }

    @Test
    void testWindowTransition() throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 10, Duration.ofSeconds(10));
        int customerId = 1;

        // First 5 requests in the first window
        for (int i = 0; i < 5; i++) {
            assertFalse(rateLimiter.rateLimit(customerId));
        }

        // Wait for the next window
        Thread.sleep(10000);

        // Next 5 requests in the new window
        for (int i = 0; i < 5; i++) {
            assertFalse(rateLimiter.rateLimit(customerId));
        }
    }
}
