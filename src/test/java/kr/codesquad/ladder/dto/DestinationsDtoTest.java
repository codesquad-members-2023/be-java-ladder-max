package kr.codesquad.ladder.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import kr.codesquad.ladder.domain.Destination;
import kr.codesquad.ladder.domain.Destinations;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;

class DestinationsDtoTest {

    ModelMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
            .setFieldAccessLevel(AccessLevel.PRIVATE)
            .setFieldMatchingEnabled(true);
    }

    @Test
    @DisplayName("Destinations 객체가 dto 객체로 매핑되는지 테스트")
    public void map() {
        //given
        List<Destination> destinationList = new ArrayList<>(
            List.of(new Destination("꽝"), new Destination("5000")));
        Destinations destinations = new Destinations(destinationList, destinationList.size());
        //when
        DestinationsDto actual = mapper.map(destinations, DestinationsDto.class);
        //then
        List<DestinationDto> destinationDtoList = new ArrayList<>(
            List.of(new DestinationDto("꽝"), new DestinationDto("5000")));
        DestinationsDto expected = new DestinationsDto(destinationDtoList);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
