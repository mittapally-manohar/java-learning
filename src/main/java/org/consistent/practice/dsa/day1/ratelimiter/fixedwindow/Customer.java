package org.consistent.practice.dsa.day1.ratelimiter.fixedwindow;

public class Customer {
    private int requestCount;
    private long windowNumber;

    public Customer(int requestCount, long windowNumber) {
        this.requestCount = requestCount;
        this.windowNumber = windowNumber;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }

    public long getWindowNumber() {
        return windowNumber;
    }

    public void setWindowNumber(long windowNumber) {
        this.windowNumber = windowNumber;
    }

    public void reset(long currentWindowNumber) {
        this.requestCount = 0;
        this.windowNumber = currentWindowNumber;
    }

    public void increment() {
        this.requestCount ++;
    }
}
