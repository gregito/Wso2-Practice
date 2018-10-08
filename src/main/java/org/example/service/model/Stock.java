package org.example.service.model;

public class Stock extends JsonEntity {

    private String symbol;

    private String name;

    private double low;

    private double high;

    public Stock() {
    }

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
