package kr.codesquad.ladder.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DestinationsDto {

    private List<DestinationDto> destinations;

    @Override
    public String toString() {
        return destinations.stream()
            .map(ladderResult -> String.format("%-5s", ladderResult.toString()))
            .collect(Collectors.joining());
    }
}
