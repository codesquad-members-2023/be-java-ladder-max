package kr.codesquad.ladder.dto;

import java.util.List;
import java.util.stream.Collectors;
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

    @Override
    public String toString() {
        return names.stream()
            .map(name -> String.format("%-5s", name))
            .collect(Collectors.joining(" "));
    }
}
