package com.impactzb.countriesroutedemo.service;

import com.impactzb.countriesroutedemo.dto.RouteDto;

public interface RoutingService {

    RouteDto findRoutes(String origin, String destination);

}
