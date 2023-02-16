package com.impactzb.countriesroutedemo.util;

import com.impactzb.countriesroutedemo.domain.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryGraphBuilder {

    public Graph<String> buildCountryGraph(List<Country> countries){
        Graph<String> graph = new Graph<>();
        countries.forEach(country -> mapCountryBordersToGraph(graph, country));
        return graph;
    }

    private void mapCountryBordersToGraph(Graph<String> graph, Country country){
        country.getBorders().forEach(border -> graph.addEdge(country.getCca3(), border));
    }
}
