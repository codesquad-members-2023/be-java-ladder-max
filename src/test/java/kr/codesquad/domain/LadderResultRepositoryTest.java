package kr.codesquad.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultRepositoryTest {

    LadderResultRepository ladderResultRepository;

    @BeforeEach
    void setLadderResultRepository() {
        ladderResultRepository = new LadderResultRepository();
        ladderResultRepository.put("jack", "꽝");
    }

    @Test
    @DisplayName("값을 저장하고 지정한 값을 찾는다.")
    void put() {
        Assertions.assertThat(ladderResultRepository.searchSingleResult("jack")).isEqualTo("꽝");
    }

    @Test
    @DisplayName("모둔 결과를 string으로 return")
    void searchAll() {
        ladderResultRepository.put("crong", "100");
        Assertions.assertThat(ladderResultRepository.searchAll()).contains("jack : 꽝", "crong : 100");
    }

    @Test
    @DisplayName("이름 포함 여부 확인")
    void containsName() {
        Assertions.assertThat(ladderResultRepository.containsName("jack")).isTrue();
        Assertions.assertThat(ladderResultRepository.containsName("crong")).isFalse();

    }
}
