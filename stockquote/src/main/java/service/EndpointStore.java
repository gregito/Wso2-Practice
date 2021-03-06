package service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import service.controller.StockController;

class EndpointStore {

    private static final List<Class<?>> SERVICES = new LinkedList<>();

    static {
        initEndpoints();
    }

    private EndpointStore() {}

    static List<Class<?>> getEndpoints() {
        return SERVICES;
    }

    private static void initEndpoints() {
        SERVICES.addAll(Arrays.asList(
                StockController.class
        ));
    }

}
