package kr.codesquad.ladder.dto;

import kr.codesquad.ladder.domain.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;

class NameDtoTest {

    ModelMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
            .setFieldAccessLevel(AccessLevel.PRIVATE)
            .setFieldMatchingEnabled(true);
    }

    @Test
    @DisplayName("modelMapper 모듈을 이용하여 Name 객체가 매핑되는지 테스트")
    public void modelMapperTest() {
        //given
        Name name = new Name("pobi");
        //when
        NameDto actual = mapper.map(name, NameDto.class);
        //then
        Assertions.assertThat(actual.getName()).isEqualTo("pobi");
    }
}
