package kr.codesquad.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LadderResultTest {

    @Test
    void findByUser() {
        // |-| |
        // | |-|
        // given
        Users users = new Users("jk,crong,honux");
        Results results = new Results("꽝,1만원,꽝", users.count());
        List<RowLines> rowLisnesList = List.of(new RowLines(List.of(true, false))
            , new RowLines(List.of(false, true)));
        Ladder ladder = new Ladder(rowLisnesList);
        LadderResult ladderResult = new LadderResult(users, results, ladder);

        Result expected1 = new Result("꽝");
        Result expected2 = new Result("1만원");

        // when
        Result actual1 = ladderResult.findByUser("jk");
        Result actual2 = ladderResult.findByUser("crong");
        Result actual3 = ladderResult.findByUser("honux");

        // then
        Assertions.assertAll(
            () -> Assertions.assertEquals(expected1, actual1),
            () -> Assertions.assertEquals(expected1, actual2),
            () -> Assertions.assertEquals(expected2, actual3));
    }
}
