package com.impactzb.countriesroutedemo.service;

import com.impactzb.countriesroutedemo.dto.RouteDto;
import com.impactzb.countriesroutedemo.exception.RouteException;
import com.impactzb.countriesroutedemo.util.Graph;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoutingServiceImpl implements RoutingService {

    private final Graph<String> countryGraph;

    public RouteDto findRoutes(String origin, String destination){
        List<String> path = countryGraph.getEdges(origin, destination);
        if(path.isEmpty()){
            throw new RouteException("There is no land crossing for given origin and destination");
        }
        return new RouteDto(path.toArray(String[]::new));
    }
}
