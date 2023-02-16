package com.impactzb.countriesroutedemo.service;

import com.impactzb.countriesroutedemo.dto.RouteDto;
import com.impactzb.countriesroutedemo.exception.RouteException;
import com.impactzb.countriesroutedemo.util.Graph;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class RoutingServiceImplTest {

    Graph<String> countryGraph = Mockito.mock(Graph.class);

    RoutingService routingService = new RoutingServiceImpl(countryGraph);

    @Test
    void findRoutes_shouldReturnExistingRoute(){
        //given
        String origin = "CZE";
        String destination = "ITA";
        List<String> route = List.of("CZE", "AUT", "ITA");
        when(countryGraph.getEdges(origin, destination)).thenReturn(route);

        //when
        RouteDto routeDto = routingService.findRoutes("CZE", "ITA");

         //then
        assertThat(route).containsExactlyInAnyOrderElementsOf(Arrays.asList(routeDto.getRoute()));
    }

    @Test
    void findRoutes_shouldThrowExceptionInCaseOfNoLandCrossingForGivenOriginAndDestination(){
        //given
        when(countryGraph.getEdges(any(), any())).thenReturn(List.of());


        //when //then
        assertThrows(RouteException.class, () -> {
            routingService.findRoutes("CZE", "USA");
        });
    }
}
