package kr.codesquad.domain;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LadderService {

    public static final String SEARCH_CLOSE_DESCRIPTION = "게임을 종료합니다.";

    public static final int LIMIT_LENGTH = 5;
    public static final int NAME_AREA = 6;

    private final LadderResultRepository ladderResultRepository;

    public LadderService(LadderResultRepository ladderResultRepository) {
        this.ladderResultRepository = ladderResultRepository;
    }

    public SearchInfo checkCommand(String command) {
        if (isSearchAll(command)) {
            return new SearchInfo(SearchType.ALL);
        }
        if (isClose(command)) {
            return new SearchInfo(SearchType.CLOSE);
        }
        return new SearchInfo(SearchType.SINGLE, command);
    }


    static boolean isClose(String input) {
        return input.equals(SearchType.CLOSE.getValue());
    }

    static boolean isSearchAll(String input) {
        return input.equals(SearchType.ALL.getValue());
    }


    public String inputSearchInfo(SearchInfo searchInfo) {
        SearchType searchType = searchInfo.getSearchType();
        switch (searchType) {
            case CLOSE:
                return SEARCH_CLOSE_DESCRIPTION;
            case ALL: {
                return ladderResultRepository.searchAll();
            }
            case SINGLE: {
                String name = searchInfo.getName();
                if (ladderResultRepository.containsName(name)) {
                    return ladderResultRepository.searchSingleResult(name);
                }
                return null;
            }
        }
        return null;
    }

    public String printLadder(List<String> names, String drawnLadder, List<String> result) {
        StringBuilder resultSB = new StringBuilder();
        resultSB.append(addNames(names)).append("\n").append(drawnLadder);
        for (String eachResult : result) {
            resultSB.append(StringCenterSorter.center(eachResult, NAME_AREA));
        }
        return resultSB.toString();
    }

    private String addNames(List<String> names) {
        StringBuilder resultSB = new StringBuilder();
        for (String userName : names) {
            userName = limitName(userName);
            resultSB.append(StringCenterSorter.center(userName, NAME_AREA));
        }
        return resultSB.toString();
    }

    static String limitName(String userName) {
        if (userName.length() > LIMIT_LENGTH) {
            userName = userName.substring(0, LIMIT_LENGTH);
        }
        return userName;
    }

    static class StringCenterSorter {

        public static final char SPACER = ' ';

        public static String center(String input, int size) {
            return center(input, size, SPACER);
        }

        public static String center(String input, int size, char delimiter) {
            if (input == null || size <= input.length()) {
                return input;
            }
            StringBuilder sb = new StringBuilder(size);
            sb.append(getPrefix(input, size, delimiter)).append(input);
            while (sb.length() < size) {
                sb.append(delimiter);
            }
            return sb.toString();
        }

        private static String getPrefix(String input, int size, char delimiter) {
            return String.valueOf(delimiter).repeat((size - input.length()) / 2);
        }
    }

}
