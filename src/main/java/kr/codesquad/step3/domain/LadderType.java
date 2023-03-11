package kr.codesquad.step3.domain;

public enum LadderType {
    CONNECT(true, "-----|"),
    DISCONNECT(false,"     |");

    private final boolean isConnected;
    private final String ladderType;

    LadderType(boolean isConnected, String ladderType) {
        this.isConnected = isConnected;
        this.ladderType = ladderType;
    }

    public static LadderType getLadderType(boolean isConnected){
        if(isConnected){
            return CONNECT;
        }
        return DISCONNECT;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public String getLadderType() {
        return ladderType;
    }
}
