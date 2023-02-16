package com.impactzb.countriesroutedemo.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GraphTest {

    Graph<String> graph = new Graph<>();

    @BeforeAll
    void init(){
        graph.addEdge("CZE","AUT");
        graph.addEdge("CZE","POL");
        graph.addEdge("CZE","DEU");
        graph.addEdge("CZE","SVK");

        graph.addEdge("AUT","DEU");
        graph.addEdge("AUT","CZE");
        graph.addEdge("AUT","HUN");
        graph.addEdge("AUT","SVK");
        graph.addEdge("AUT","SVN");
        graph.addEdge("AUT","LIE");
        graph.addEdge("AUT","ITA");
        graph.addEdge("AUT","CHE");

        graph.addEdge("DEU","FRA");
        graph.addEdge("DEU","AUT");
        graph.addEdge("DEU","CZE");
        graph.addEdge("DEU","POL");
        graph.addEdge("DEU","CHE");
        graph.addEdge("DEU","DNK");
        graph.addEdge("DEU","BEL");
        graph.addEdge("DEU","LUX");
        graph.addEdge("DEU","NLD");
        graph.addEdge("DEU","NLD");

        graph.addEdge("CHE","DEU");
        graph.addEdge("CHE","LIE");
        graph.addEdge("CHE","AUT");
        graph.addEdge("CHE","ITA");
        graph.addEdge("CHE","FRA");
        graph.addEdge("CHE","DEU");

        graph.addEdge("ITA","AUT");
        graph.addEdge("ITA","SVN");
        graph.addEdge("ITA","CHE");
        graph.addEdge("ITA","FRA");
    }

    @Test
    void getEdges_should_find_route_from_CZE_to_ITA(){
        //given
        Set<List<String>> possibleRoutes = Set.of(
                List.of("CZE", "AUT", "ITA"),
                List.of("CZE", "DEU", "AUT", "ITA"),
                List.of("CZE", "DEU", "CHE", "ITA"));

        //when
        List<String> route = graph.getEdges("CZE", "ITA");

        //then
        assertFalse(route.isEmpty());
        assertTrue(possibleRoutes.contains(route));
    }
}
