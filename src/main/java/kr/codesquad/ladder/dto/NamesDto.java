package kr.codesquad.ladder.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NamesDto {

    private List<NameDto> names;

    @Builder
    public NamesDto(List<NameDto> names) {
        this.names = names;
    }
}
