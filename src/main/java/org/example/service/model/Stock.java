package org.example.service.model;

public class Stock {

    private final String symbol;

    private final String name;

    private final double low;

    private final double high;

    public Stock(String symbol, String name, double low, double high) {
        this.symbol = symbol;
        this.name = name;
        this.low = low;
        this.high = high;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }

}
