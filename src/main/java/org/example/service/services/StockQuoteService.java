package org.example.service.services;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.example.service.exception.impl.SymbolNotFoundException;
import org.example.service.model.Stock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StockQuoteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StockQuoteService.class.getName());

    private Map<String, Stock> quotes = new LinkedHashMap<>();

    public Response getStock(String symbol) throws SymbolNotFoundException {
        Stock stock = quotes.get(symbol);
        if (stock == null) {
                throw new SymbolNotFoundException("Symbol " + symbol + " not found");
        }
        return Response.status(Response.Status.OK).entity(stock).build();
    }

    public Response addStock(Stock stock) {
        if(quotes.get(stock.getSymbol()) != null) {
            LOGGER.info(String.format("There is already a Stock with symbol \"%s\"", stock.getSymbol()));
            return Response.status(Response.Status.FORBIDDEN).entity("Access Denied!").build();
        }
        quotes.put(stock.getSymbol(), stock);
        return Response.status(Response.Status.OK).
                entity("{\"result\":\"Updated the stock with symbol = " + stock.getSymbol() + "\"}").build();
    }

}
