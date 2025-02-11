package org.consistent.practice.assessment;

import java.util.*;

class VendingMachine {
    private Map<Integer, Drink> drinks = new HashMap<>();
    private Map<Integer, Integer> stock = new HashMap<>();
    private Map<Integer, Integer> prices = new HashMap<>();

    void registerDrink(int buttonNumber, Drink drink, int price, int quantity) {
        drinks.put(buttonNumber, drink);
        stock.put(buttonNumber, quantity);
        prices.put(buttonNumber, price);
    }

    ServeDrinkSummary dispatch(int buttonPressed, int money)
            throws OutOfStockException, InsufficientMoneyException {
        if (!stock.containsKey(buttonPressed) || stock.get(buttonPressed) == 0) {
            throw new OutOfStockException(drinks.get(buttonPressed).getName() + " is out of stock");
        }
        int price = prices.get(buttonPressed);
        if (money < price) {
            throw new InsufficientMoneyException("Insufficient money");
        }
        stock.put(buttonPressed, stock.get(buttonPressed) - 1);
        return new ServeDrinkSummary(drinks.get(buttonPressed), money - price);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Reading stock quantities
        int cokeQty = scanner.nextInt();
        int fantaQty = scanner.nextInt();
        int spriteQty = scanner.nextInt();

        // Reading prices
        int cokePrice = scanner.nextInt();
        int fantaPrice = scanner.nextInt();
        int spritePrice = scanner.nextInt();

        // Reading button numbers mapping
        int cokeButton = scanner.nextInt();
        int fantaButton = scanner.nextInt();
        int spriteButton = scanner.nextInt();

        // Reading total number of requests
        int totalRequests = scanner.nextInt();

        // Displaying vending machine setup
        System.out.println("Vending machine set up");

        for (int i = 0; i < totalRequests; i++) {
            int buttonNumber = scanner.nextInt();
            int moneyInserted = scanner.nextInt();

            if (buttonNumber == cokeButton) {
                if (cokeQty == 0) {
                    System.out.println("Coke is out of stock");
                } else if (moneyInserted < cokePrice) {
                    System.out.println("Insufficient money");
                } else {
                    System.out.println("Coke " + (moneyInserted - cokePrice));
                    cokeQty--;
                }
            } else if (buttonNumber == fantaButton) {
                if (fantaQty == 0) {
                    System.out.println("Fanta is out of stock");
                } else if (moneyInserted < fantaPrice) {
                    System.out.println("Insufficient money");
                } else {
                    System.out.println("Fanta " + (moneyInserted - fantaPrice));
                    fantaQty--;
                }
            } else if (buttonNumber == spriteButton) {
                if (spriteQty == 0) {
                    System.out.println("Sprite is out of stock");
                } else if (moneyInserted < spritePrice) {
                    System.out.println("Insufficient money");
                } else {
                    System.out.println("Sprite " + (moneyInserted - spritePrice));
                    spriteQty--;
                }
            }
        }
        scanner.close();
    }
}

class Drink {
    private String name;

    public Drink(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class ServeDrinkSummary {
    private Drink drink;
    private int change;

    public ServeDrinkSummary(Drink drink, int change) {
        this.drink = drink;
        this.change = change;
    }

    @Override
    public String toString() {
        return drink + " " + change;
    }
}

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class InsufficientMoneyException extends Exception {
    public InsufficientMoneyException(String message) {
        super(message);
    }
}
