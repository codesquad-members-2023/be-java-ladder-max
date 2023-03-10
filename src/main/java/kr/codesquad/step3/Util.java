package kr.codesquad.step3;

import java.util.ArrayList;
import java.util.List;

public class Util {
    static List<Participate> splitParticipatePeopleNameLine(String participatePeopleName){
        String [] participateNames = participatePeopleName.split(",");
        return makeParticipates(participateNames);
    }

    static List<Participate> makeParticipates(String [] participateNames ){
        List<Participate> participates = new ArrayList<>();
        int position = 0;
        for(String participateName : participateNames){
            participates.add(new Participate(position++,participateName));
        }
        return participates;
    }
}
