package kr.codesquad.ladder.dto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.Line;
import kr.codesquad.ladder.domain.Point;
import kr.codesquad.ladder.domain.Points;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;

class LadderDtoTest {

    ModelMapper mapper;

    @BeforeEach
    public void setup() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
            .setFieldAccessLevel(AccessLevel.PRIVATE)
            .setFieldMatchingEnabled(true);
    }

    @Test
    @DisplayName("ladder 객체가 dto 객체로 매핑되는지 테스트")
    public void map() {
        //given
        Line line1 = new Line(new Points(List.of(Point.ofBar(), Point.ofBridge(), Point.ofBar())));
        List<Line> lines = new ArrayList<>(List.of(line1));
        Ladder ladder = new Ladder(lines);
        //when
        LadderDto actual = mapper.map(ladder, LadderDto.class);
        //then
        LineDto lineDto1 = new LineDto(new PointsDto(
            new ArrayList<>(List.of(new PointDto("|"),
                new PointDto("-----"),
                new PointDto("|")))));
        List<LineDto> linesDto = new ArrayList<>(List.of(lineDto1));
        LadderDto expected = new LadderDto(linesDto);
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
