package org.consistent.practice.dsa.day1;

import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private final int requestLimit;
    private final int windowSize;

    Map<Integer,Customer> customers = new HashMap<>();

    public RateLimiter(int requestLimit, int windowSize) {
        this.requestLimit = requestLimit;
        this.windowSize = windowSize;
    }

    public boolean rateLimit(int customerId){
        //Get the currentWindowNumber based on the windowSize
        long currentWindowNumber = System.currentTimeMillis()/windowSize*1000;

        //Read the customer from the map using customer ID
        //if customer doesn't exist, create new customer with request count 0 and currentWindowNumber
        Customer customer = customers.computeIfAbsent(customerId,(x)->new Customer(0,currentWindowNumber));

        //if currentWindowNumber > customer window number
        //reset the customer window number, since the window number past requested by customer is in past window
        //the values should be reset to current window number and request count to zero
        if(currentWindowNumber > customer.getWindowNumber()){
            customer.setRequestCount(0);
            customer.setWindowNumber(currentWindowNumber);
        }

        //if customer request count < request limit
        // increment the customer request count + 1 and return false to indicate that the request should not be rate limited.
        if(customer.getRequestCount() < requestLimit){
            customer.setRequestCount(customer.getRequestCount()+1);
            return false;
        }

        //else rate limit the request by sending true
        return true;
    }
}
