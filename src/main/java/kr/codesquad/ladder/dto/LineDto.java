package kr.codesquad.ladder.dto;

import kr.codesquad.ladder.domain.Points;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineDto {

    private PointsDto points;
}
