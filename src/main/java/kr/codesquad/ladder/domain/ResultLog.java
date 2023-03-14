package kr.codesquad.ladder.domain;

import kr.codesquad.ladder.domain.dto.ResultDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultLog {

    private List<ResultDto> resultLog;

    public ResultLog(Ladder ladder,User user,Result result) {
        resultLog = makeResultLog(ladder,user,result);
    }

    private List<ResultDto> makeResultLog(Ladder ladder,User user,Result result){
        List<ResultDto> list = new ArrayList<>();
        List<String> userList = user.userList();
        List<String> resultList = result.resultList();
        int userNumber = 0;
        for(int i= 0; i<userList.size(); i++ ){
            userNumber = ladder.ladderMove(i);
            ResultDto resultDto = new ResultDto(userList.get(i),resultList.get(userNumber));
            list.add(resultDto);
        }
        return list;
    }

    public List<ResultDto> getResultLog() {
        return resultLog;
    }

    public String findResult(String name) {
        for (ResultDto temp : resultLog) {
            if(temp.getUserName().equals(String.format("%-6s",name))) {
                return temp.getResult();
            }
        }
        return "없는이름";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(ResultDto temp : resultLog) {
           stringBuilder.append(temp.getUserName());
           stringBuilder.append(" : ");
           stringBuilder.append(temp.getResult());
           stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
