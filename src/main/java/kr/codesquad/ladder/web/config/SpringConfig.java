package kr.codesquad.ladder.web.config;

import kr.codesquad.ladder.domain.Destinations;
import kr.codesquad.ladder.domain.DestinationsFactory;
import kr.codesquad.ladder.domain.NamesFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public NamesFactory namesFactory() {
        return new NamesFactory();
    }

    @Bean
    public DestinationsFactory destinationsFactory() {
        return new DestinationsFactory();
    }
}
