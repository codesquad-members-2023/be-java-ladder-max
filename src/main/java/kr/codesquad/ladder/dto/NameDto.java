package kr.codesquad.ladder.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NameDto {

    private String name;

    public NameDto(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
