package com.impactzb.countriesroutedemo.conf;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.impactzb.countriesroutedemo.domain.Country;
import com.impactzb.countriesroutedemo.util.CountryGraphBuilder;
import com.impactzb.countriesroutedemo.util.Graph;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

@Configuration
public class GraphBeanConfiguration {

    @Bean
    public Graph<String> countryGraph(@Value("classpath:data/countryData.json") Resource resourceFile,
                                      ObjectMapper objectMapper,
                                      CountryGraphBuilder countryGraphBuilder) throws IOException {
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        List<Country> countries = objectMapper.readValue(resourceFile.getFile(), new TypeReference<List<Country>>(){});
        return countryGraphBuilder.buildCountryGraph(countries);
    }
}
