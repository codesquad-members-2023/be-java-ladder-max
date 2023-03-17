package kr.codesquad.ladder.controller;

import java.util.Random;
import kr.codesquad.ladder.domain.Destinations;
import kr.codesquad.ladder.domain.DestinationsFactory;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.LadderResults;
import kr.codesquad.ladder.domain.LadderResultsFactory;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.domain.NamesFactory;
import kr.codesquad.ladder.exception.InvalidCountOfPeopleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class LadderGameWebController {

    private final NamesFactory namesFactory;
    private final DestinationsFactory destinationsFactory;
    private final Random random = new Random();

    @Autowired
    public LadderGameWebController(NamesFactory namesFactory,
        DestinationsFactory destinationsFactory) {
        this.namesFactory = namesFactory;
        this.destinationsFactory = destinationsFactory;
    }

    @GetMapping("/ladder")
    public ModelAndView ladderCountOfPeopleForm() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping("/ladder/form")
    public ModelAndView ladderFormByCountOfPeople(
        @RequestParam("countOfPeople") int countOfPeople) {
        if (countOfPeople < 2) {
            log.info("countOfPeople : " + countOfPeople);
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
        ModelAndView mav = new ModelAndView("ladder");
        Names names = namesFactory.createNames(nameOfPeople);
        Destinations destinations = destinationsFactory.createDestinations(destinationArray,
            nameOfPeople.length);
        LadderGenerator ladderGenerator = new LadderGenerator(maximumLadderHeight);
        LadderResultsFactory ladderResultsFactory = new LadderResultsFactory();
        Ladder ladder = ladderGenerator.createLines(nameOfPeople.length, random);
        LadderResults ladderResults =
            ladderResultsFactory.getAllLadderResult(names, ladder, destinations);

        mav.getModelMap().addAttribute("names", names);
        mav.getModelMap().addAttribute("ladder", ladder);
        mav.getModelMap().addAttribute("destinations", destinations);
        mav.getModelMap().addAttribute("ladderResults", ladderResults);
        return mav;
    }

}
