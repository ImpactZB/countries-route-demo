package com.impactzb.countriesroutedemo.api;

import com.impactzb.countriesroutedemo.dto.RouteDto;
import com.impactzb.countriesroutedemo.service.RoutingService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(path = RoutingController.ROUTING_ENDPOINT)
public class RoutingController {

    public static final String ROUTING_ENDPOINT = "/routing";

    private final RoutingService routingService;

    @Operation(description="Find route for given origin and destination")
    @GetMapping(path = "/{origin}/{destination}",  produces = "application/json")
    public ResponseEntity<?> getDiscountsForProduct(@PathVariable("origin") String origin, @PathVariable("destination") String destination){
        RouteDto route = routingService.findRoutes(origin, destination);
        return new ResponseEntity<>(route, new HttpHeaders(), HttpStatus.OK);
    }
}
