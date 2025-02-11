package org.consistent.practice.assessment;/* Save this in a file called Main.java to compile and test it */

/* Do not add a package declaration */
import java.util.*;
import java.io.*;

/* DO NOT CHANGE ANYTHING ABOVE THIS LINE */
/* You may add any imports here, if you wish, but only from the
   standard library */

/* Do not add a namespace declaration */

public class LinesProcListStdin {
    public static List<String> processData(ArrayList<String> lines) {
        Map<String, Map<String, Integer>> maxPriceMap = new HashMap<>();
        Map<String, Set<String>> customerPurchases = new HashMap<>();

        for (String entry : lines) {
            String[] parts = entry.split(", ");
            String customer = parts[0];
            String product = parts[3];
            int price = Integer.parseInt(parts[4].substring(3));

            maxPriceMap.putIfAbsent(product, new HashMap<>());
            maxPriceMap.get(product).put(customer, Math.max(
                    maxPriceMap.get(product).getOrDefault(customer, 0), price));

            customerPurchases.putIfAbsent(customer, new HashSet<>());
            customerPurchases.get(customer).add(product + ":" + price);
        }

        Set<String> discountOnlyBuyers = new HashSet<>(customerPurchases.keySet());

        for (String customer : customerPurchases.keySet()) {
            for (String item : customerPurchases.get(customer)) {
                String[] parts = item.split(":");
                String product = parts[0];
                int price = Integer.parseInt(parts[1]);

                int maxPrice = maxPriceMap.get(product).values().stream().max(Integer::compare).orElse(0);
                if (price == maxPrice) {
                    discountOnlyBuyers.remove(customer);
                    break;
                }
            }
        }

        return new ArrayList<>(discountOnlyBuyers);
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine())
            inputData.add(in.nextLine());
        List<String> retVal = processData(inputData);
        PrintWriter output = new PrintWriter(System.out);
        for(String str: retVal)
            output.println(str);
        output.close();
    }
}
