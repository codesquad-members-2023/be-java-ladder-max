package kr.codesquad.ladder.dto;

import java.util.List;
import kr.codesquad.ladder.domain.Point;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointsDto {
    private List<PointDto> points;
}
