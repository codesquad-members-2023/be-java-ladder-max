package kr.codesquad.ladder.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import kr.codesquad.ladder.domain.Destination;
import kr.codesquad.ladder.domain.LadderResult;
import kr.codesquad.ladder.domain.LadderResults;
import kr.codesquad.ladder.domain.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;

class LadderResultsDtoTest {

    ModelMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
            .setFieldAccessLevel(AccessLevel.PRIVATE)
            .setFieldMatchingEnabled(true);
    }

    @Test
    @DisplayName("ladderResults 객체를 dto 객체로 매핑되는지 테스트")
    public void map() {
        //given
        LadderResult ladderResult1 = new LadderResult(new Name("pobi"), new Destination("꽝"));
        LadderResult ladderResult2 = new LadderResult(new Name("crong"), new Destination("5000"));
        List<LadderResult> ladderResultList = new ArrayList<>(
            List.of(ladderResult1, ladderResult2));
        LadderResults ladderResults = new LadderResults(ladderResultList);
        //when
        LadderResultsDto actual = mapper.map(ladderResults, LadderResultsDto.class);
        //then
        LadderResultDto ladderResultDto1 = new LadderResultDto(new NameDto("pobi"),
            new DestinationDto("꽝"));
        LadderResultDto ladderResultDto2 = new LadderResultDto(new NameDto("crong"),
            new DestinationDto("5000"));
        List<LadderResultDto> ladderResultDtoList = new ArrayList<>(
            List.of(ladderResultDto1, ladderResultDto2));
        LadderResultsDto expected = new LadderResultsDto(ladderResultDtoList);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
