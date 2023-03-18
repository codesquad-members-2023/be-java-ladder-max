package kr.codesquad.ladder.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import kr.codesquad.ladder.domain.Name;
import kr.codesquad.ladder.domain.Names;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;

class NamesDtoTest {

    ModelMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
            .setFieldAccessLevel(AccessLevel.PRIVATE)
            .setFieldMatchingEnabled(true);
    }

    @Test
    @DisplayName("Names 객체안에 Name 타입 리스트들도 복사하여 매핑되는 테스트")
    public void map() {
        //given
        List<Name> nameList = new ArrayList<>(List.of(new Name("pobi"), new Name("jk")));
        Names names = new Names(nameList);
        //when
        NamesDto actual = mapper.map(names, NamesDto.class);
        //then
        NamesDto expected = new NamesDto(
            new ArrayList<>(List.of(new NameDto("pobi"), new NameDto("jk"))));

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
