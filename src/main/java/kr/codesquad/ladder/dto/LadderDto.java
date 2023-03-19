package kr.codesquad.ladder.dto;

import java.util.List;
import kr.codesquad.ladder.domain.Line;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LadderDto {

    private List<LineDto> lines;
}
