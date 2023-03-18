package kr.codesquad.ladder.dto;

import java.util.List;
import kr.codesquad.ladder.domain.Destination;
import kr.codesquad.ladder.domain.LadderResult;
import kr.codesquad.ladder.domain.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LadderResultsDto {

    private List<LadderResultDto> ladderResults;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderResultDto ladderResult : ladderResults) {
            sb.append(ladderResult).append("\n");
        }
        return sb.toString();
    }
}
