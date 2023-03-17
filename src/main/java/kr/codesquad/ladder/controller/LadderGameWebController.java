package kr.codesquad.ladder.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Random;
import kr.codesquad.ladder.domain.Destinations;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.LadderResults;
import kr.codesquad.ladder.domain.LadderResultsFactory;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.exception.InvalidCountOfPeopleException;
import kr.codesquad.ladder.view.LadderConsoleReader;
import kr.codesquad.ladder.view.LadderConsoleWriter;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class LadderGameWebController {

    private final Random random = new Random();

    @GetMapping("/ladder")
    public ModelAndView ladderCountOfPeopleForm() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping("/ladder/form")
    public ModelAndView ladderFormByCountOfPeople(
        @RequestParam("countOfPeople") int countOfPeople) {
        if (countOfPeople < 2) {
            throw new InvalidCountOfPeopleException();
        }

        ModelAndView mav = new ModelAndView("ladderForm");
        mav.getModelMap().addAttribute("countOfPeople", countOfPeople);
        return mav;
    }

    @PostMapping("/ladder/result")
    public ModelAndView ladderResultView(
        @RequestParam("nameOfPeople") String[] nameOfPeople,
        @RequestParam("destination") String[] destinationArray,
        @RequestParam("maximumLadderHeight") int maximumLadderHeight) {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
            toInputStream(nameOfPeople, destinationArray, maximumLadderHeight))));
        LadderWriter ladderWriter = new LadderConsoleWriter();
        LadderReader ladderReader = new LadderConsoleReader(br, ladderWriter);
        LadderGameManager consoleController = new LadderGameManager(
            ladderReader, ladderWriter);

        ModelAndView mav = new ModelAndView("ladder");
        Names names = consoleController.getNamesOfPeoples();
        Destinations destinations = consoleController.getDestinations(names.size());
        LadderGenerator ladderGenerator = consoleController.getLadderGenerator();
        Ladder ladder = ladderGenerator.createLines(names.size(), random);
        LadderResultsFactory ladderResultsFactory = new LadderResultsFactory();
        LadderResults ladderResults =
            ladderResultsFactory.getLadderResults(names, ladder, destinations);

        mav.getModelMap().addAttribute("names", names);
        mav.getModelMap().addAttribute("ladder", ladder);
        mav.getModelMap().addAttribute("destinations", destinations);
        mav.getModelMap().addAttribute("ladderResults", ladderResults);
        return mav;
    }

    private byte[] toInputStream(String[] nameOfPeople, String[] destinationArray,
        int maximumLadderHeight) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", nameOfPeople)).append("\n");
        sb.append(String.join(",", destinationArray)).append("\n");
        sb.append(maximumLadderHeight);
        return sb.toString().getBytes();
    }

}
