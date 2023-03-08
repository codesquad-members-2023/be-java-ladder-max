package kr.codesquad.domain;

public class SearchInfo {

    private final SearchType searchType;
    private String name;

    public SearchInfo(SearchType searchType) {
        this.searchType = searchType;
    }

    public SearchInfo(SearchType searchType, String name) {
        this.searchType = searchType;
        this.name = name;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public String getName() {
        return name;
    }

}
