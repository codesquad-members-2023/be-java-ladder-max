package kr.codesquad.domain;

public class Result {

    private SearchType searchType;
    private String name;

    public Result(SearchType searchType) {
        this.searchType = searchType;
    }

    public Result(SearchType searchType, String name) {
        this.searchType = searchType;
        this.name = name;
    }

    public SearchType getSearchType() {
        return searchType;
    }

    public void setSearchType(SearchType searchType) {
        this.searchType = searchType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
