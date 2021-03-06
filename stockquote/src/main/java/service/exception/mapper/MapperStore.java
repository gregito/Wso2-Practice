package service.exception.mapper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.ext.ExceptionMapper;

import service.exception.mapper.mappers.GeneralExceptionMapper;
import service.exception.mapper.mappers.JsonConversionExceptionMapper;
import service.exception.mapper.mappers.ServiceInstantiationExceptionMapper;
import service.exception.mapper.mappers.SymbolNotFoundMapper;

public class MapperStore {

    private static final List<ExceptionMapper> MAPPERS = new LinkedList<>();

    static {
        initMappers();
    }

    private MapperStore() {

    }

    public static List<ExceptionMapper> getMappers() {
        return MAPPERS;
    }

    private static void initMappers() {
        MAPPERS.addAll(Arrays.asList(
                new SymbolNotFoundMapper(),
                new GeneralExceptionMapper(),
                new JsonConversionExceptionMapper(),
                new ServiceInstantiationExceptionMapper()
        ));
    }

}
