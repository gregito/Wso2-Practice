package service.controller;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import service.model.Stock;
import service.services.StockQuoteService;

@Path("/stockquote")
public class StockController {

    private StockQuoteService stockQuoteService = new StockQuoteService();

    @GET
    @Path("/{symbol}")
    @Produces("application/json")
    public Stock get(@PathParam("symbol") String symbol) {
        return stockQuoteService.getStock(symbol);
    }

    @GET
    @Path("/list")
    public Set<Stock> listStocks() {
        return stockQuoteService.listStocks();
    }

    @POST
    @Path("/")
    @Consumes("application/json")
    public Stock post(Stock stock) {
        return stockQuoteService.addStock(stock);
    }

    @PUT
    @Path("/")
    public void put(Stock stock) {
        stockQuoteService.modifyStock(stock);
    }

    @DELETE
    @Path("/{symbol}")
    public void delete(@PathParam("symbol") String symbol) {
        stockQuoteService.delete(symbol);
    }

}
