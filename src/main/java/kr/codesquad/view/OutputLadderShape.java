package kr.codesquad.view;

import kr.codesquad.domain.LadderResult;
import kr.codesquad.domain.Line;

import java.util.List;

public class OutputLadderShape {
    private final LadderResult ladderResult;

    private final String LINE_COLUMN = "ㅣ";
    private final String LINE_ROW = "-----";
    private final String LINE_ROW_BLANK = "     ";


    public OutputLadderShape(LadderResult ladderResult){
        this.ladderResult = ladderResult;
    }

    // 첫 줄인 플레이어 이름 라인 빌더
    public String getPlayerNameLine(){
        StringBuilder playersString = new StringBuilder();
        List<String> players = ladderResult.getPlayers();

        for(String player : players){
            playersString.append(String.format("%-6s",player));
        }
        playersString.append("\n");

        return playersString.toString();
    }
    // 사다리 모양 빌더
    public String getLadderLine(){
        StringBuilder ladderLineBuilder = new StringBuilder();
        List<Line> lines = ladderResult.getLines();
        for(Line line : lines){
            ladderLineBuilder.append(buildOneLadderLine(line.getLine()));
        }

        return ladderLineBuilder.toString();
    }

    public String buildOneLadderLine(List<Boolean> line){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LINE_COLUMN);
        for(int i = 0; i < line.size(); i++){
            stringBuilder.append(isThereRowLine(line.get(i))).append(LINE_COLUMN);
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    public String isThereRowLine(Boolean line){
        if(line){
            return LINE_ROW;
        }
        return LINE_ROW_BLANK;
    }
}
