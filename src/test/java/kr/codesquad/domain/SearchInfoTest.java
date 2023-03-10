package kr.codesquad.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SearchInfoTest {

    @DisplayName("SearchType를 가져온다.")
    @Test
    void getSearchType() {
        SearchInfo searchInfo = new SearchInfo(SearchType.ALL);
        assertThat(searchInfo.getSearchType()).isEqualTo(SearchType.ALL);
    }

    @DisplayName("이름을 가져온다")
    @Test
    void getName() {
        SearchInfo searchInfo = new SearchInfo(SearchType.ALL, "jack");
        assertThat(searchInfo.getName()).isEqualTo("jack");
    }
}
