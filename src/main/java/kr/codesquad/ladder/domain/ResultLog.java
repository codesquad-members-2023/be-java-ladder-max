package kr.codesquad.ladder.domain;

import kr.codesquad.ladder.domain.dto.ResultDto;
import kr.codesquad.ladder.view.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultLog {

    private List<ResultDto> resultLog;

    public ResultLog(Ladder ladder,User user,Result result,int userCount) {
        resultLog = makeResultLog(ladder,user,result,userCount);
    }

    private List<ResultDto> makeResultLog(Ladder ladder,User user,Result result,int userCount){
        List<ResultDto> list = new ArrayList<>();
        for(int i= 0; i<userCount; i++ ){
            int userNumber = ladder.ladderMove(i);
            ResultDto resultDto = new ResultDto(user.individualUser(i),result.individualResult(userNumber));
            list.add(resultDto);
        }
        return list;
    }

    private String findResult(String name) {
        for (ResultDto temp : resultLog) {
            if(temp.getUserName().equals(String.format("%-6s",name))) {
                return temp.getUserName()+"\n실행결과\n"+temp.getResult();
            }
        }
        throw new IllegalArgumentException("해당 유저 존재하지 않음");
    }


    public String existValidate(String name,Input input) throws IOException {
        if(name.equals("춘식이")){
            return "춘식이 입력 게임종료";
        }
        if(name.equals("all")){
            return toString();
        }
        try {
            return findResult(name);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return existValidate(input.insertFindUser(),input);
    }

    public String existValidate(String name) {
        if(name.equals("춘식이")){
            return "춘식이 입력 게임종료";
        }
        if(name.equals("all")){
            return toString();
        }
        try {
            return findResult(name);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return "해당유저 존재하지 않음";
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("실행결과\n");
        for(ResultDto temp : resultLog) {
            stringBuilder.append(temp.getUserName());
            stringBuilder.append(" : ");
            stringBuilder.append(temp.getResult());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}