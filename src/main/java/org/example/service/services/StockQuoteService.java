package org.example.service.services;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.example.service.exception.impl.AccessDeniedException;
import org.example.service.exception.impl.SymbolNotFoundException;
import org.example.service.model.Stock;


public class StockQuoteService {

    private Map<String, Stock> quotes = new LinkedHashMap<>();

    public Stock getStock(String symbol) throws SymbolNotFoundException {
        Optional<Stock> stock = Optional.ofNullable(quotes.get(symbol));
        if (!stock.isPresent()) {
                throw new SymbolNotFoundException("Symbol " + symbol + " not found");
        }
        return stock.get();
    }

    public Stock addStock(Stock stock) {
        if(quotes.get(stock.getSymbol()) != null) {
            throw new AccessDeniedException(String.format("There is already a Stock with symbol \"%s\"", stock.getSymbol()));
        }
        quotes.put(stock.getSymbol(), stock);
        return stock;
    }

    public void modifyStock(Stock stock) {
        quotes.put(stock.getSymbol(), Optional.ofNullable(quotes.get(stock.getSymbol()))
                .orElseThrow(() -> new SymbolNotFoundException(String.format("Symbol %s not found", stock.getSymbol()))));
    }

    public void delete(String symbol) {
        Optional<Stock> stock = Optional.ofNullable(quotes.get(symbol));
        if (!stock.isPresent()) {
            throw new SymbolNotFoundException("Symbol " + symbol + " not found");
        }
        quotes.remove(symbol);
    }

    public Set<Stock> listStocks() {
        return quotes.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toSet());
    }

}
