package org.consistent.practice.dsa.day1.fixedwindowratelimiterwithcreditsystem;

public class Customer {
    private int requestCount;
    private long windowNumber;
    private int credits;

    public Customer(int requestCount, long windowNumber, int credits) {
        this.requestCount = requestCount;
        this.windowNumber = windowNumber;
        this.credits = credits;
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

    public int getCredits() {
        return credits;
    }

    public void increment() {
        this.requestCount ++;
    }

    public void addCredits(int unusedRequests, int maxCredits) {
        this.credits = Math.min(this.credits+ Math.max(unusedRequests, 0), maxCredits);
    }

    public void useCredits() {
        if(this.credits>0){
            this.credits--;
        }
    }
}
