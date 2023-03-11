package kr.codesquad.step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import kr.codesquad.step3.util.Util;
import kr.codesquad.step3.util.Validation;

public class Participates {
    public final List<Participate> participatesNames;

    public Participates(List<Participate> participates) {
        this.participatesNames = participates;
    }


    private static List<String> makeEachParticipateNameGroup(String participateNames){
        Validation.validateInputNames(participateNames);
        List<String> eachParticipateName = stringToList(participateNames);
        Validation.validateMinimumParticipates(eachParticipateName);
        return eachParticipateName;
    }

    private static List<String> stringToList(String participateNames){
        return Arrays.asList(Util.splitParticipateName(participateNames));
    }
}
