package kr.codesquad.ladder.dto;

import kr.codesquad.ladder.domain.Destination;
import kr.codesquad.ladder.domain.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LadderResultDto {

    private NameDto name;
    private DestinationDto destination;

    @Override
    public String toString() {
        return String.format("%s : %s", name, destination);
    }
}
