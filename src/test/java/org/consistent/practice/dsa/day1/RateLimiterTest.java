package org.consistent.practice.dsa.day1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class RateLimiterTest {
    RateLimiter rateLimiter;

    @BeforeEach
    void setUp(){
        rateLimiter = new RateLimiter(10, Duration.ofSeconds(5));
    }

    @Test
    void shouldNotRateLimitCustomerWithInAllowedLimit(){
        boolean rateLimited = rateLimiter.rateLimit(1000);
        Assertions.assertFalse(rateLimited);
    }

    @Test
    void shouldRateLimitCustomerIfLimitExceeded(){
        for(int i=0;i<10;i++){
            Assertions.assertFalse(rateLimiter.rateLimit(1000));
        }
        Assertions.assertTrue(rateLimiter.rateLimit(1000));
    }

}
