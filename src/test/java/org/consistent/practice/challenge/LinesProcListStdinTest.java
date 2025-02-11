package org.consistent.practice.challenge;

import org.consistent.practice.assessment.LinesProcListStdin;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinesProcListStdinTest {

    @Test
    public void testProcessDataWithBasicInput() {
        // Basic test input with discounted price
        ArrayList<String> inputData = new ArrayList<>();
        inputData.add("Rajan Patil, Aundh, 1, Phone Cover, Rs 170, Cash");
        inputData.add("Mohit Gupta, Baner, 1, Samsung Battery, Rs 900, Credit Card");
        inputData.add("Rajan Patil, Aundh, 3, Samsung Battery, Rs 1000, Cash");
        inputData.add("Nina Kothari, Baner, 4, Earphones, Rs 500, Credit Card");
        inputData.add("T Sunitha, Shivajinagar, 5, Earphones, Rs 550, Credit Card");
        inputData.add("Rohan Gade, Aundh, 10, Motorola Battery, Rs 1000, Credit Card");
        inputData.add("Rajan Patil, Shivajinagar, 21, Earphones, Rs 550, Credit Card");
        inputData.add("Rajan Patil, Aundh, 22, USB Cable, Rs 150, UPI");
        inputData.add("Meena Kothari, Baner, 23, USB Cable, Rs 100, Cash");
        inputData.add("Nina Kothari, Baner, 24, USB Cable, Rs 200, UPI");
        inputData.add("Mohit Gupta, Baner, 25, USB Cable, Rs 150, UPI");

        List<String> result = LinesProcListStdin.processData(inputData);

        // Expected customers who bought at the most discounted price
        List<String> expected = Arrays.asList("Mohit Gupta", "Meena Kothari");

        assertEquals(expected, result);
    }

    @Test
    public void testProcessDataWithNoDiscountedProducts() {
        // Input where no product has been sold at a discounted price
        ArrayList<String> inputData = new ArrayList<>();
        inputData.add("Rajan Patil, Aundh, 1, Phone Cover, Rs 170, Cash");
        inputData.add("Mohit Gupta, Baner, 1, Battery, Rs 900, Credit Card");
        inputData.add("Rajan Patil, Aundh, 3, Samsung Battery, Rs 1000, Cash");

        List<String> result = LinesProcListStdin.processData(inputData);

        // No discounted product, so the expected result is an empty list
        assertTrue(result.isEmpty());
    }

    @Test
    public void testProcessDataWithEmptyInput() {
        // Test with empty input
        ArrayList<String> inputData = new ArrayList<>();

        List<String> result = LinesProcListStdin.processData(inputData);

        // With no input data, the result should be an empty list
        assertTrue(result.isEmpty());
    }

    @Test
    public void testProcessDataWithOneProduct() {
        // Input with one product and one sale price (no discount)
        ArrayList<String> inputData = new ArrayList<>();
        inputData.add("Rajan Patil, Aundh, 1, Phone Cover, Rs 170, Cash");

        List<String> result = LinesProcListStdin.processData(inputData);

        // No discounts as there is only one price, so the expected result is an empty list
        assertTrue(result.isEmpty());
    }

    @Test
    public void testProcessDataWithMultipleSalesAtSamePrice() {
        // Test case where multiple sales are made at the same price, no discount
        ArrayList<String> inputData = new ArrayList<>();
        inputData.add("Rajan Patil, Aundh, 1, Phone Cover, Rs 170, Cash");
        inputData.add("Mohit Gupta, Baner, 1, Phone Cover, Rs 170, Credit Card");

        List<String> result = LinesProcListStdin.processData(inputData);

        // No discount because all sales were at the same price, so the expected result is an empty list
        assertTrue(result.isEmpty());
    }
}