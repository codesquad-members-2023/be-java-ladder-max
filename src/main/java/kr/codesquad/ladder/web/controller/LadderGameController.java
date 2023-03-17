package kr.codesquad.ladder.web.controller;

import java.util.Optional;
import java.util.Random;
import kr.codesquad.ladder.domain.Destinations;
import kr.codesquad.ladder.domain.DestinationsFactory;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.LadderResults;
import kr.codesquad.ladder.domain.LadderResultsFactory;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.domain.NamesFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class LadderGameController {

    private final NamesFactory namesFactory;
    private final DestinationsFactory destinationsFactory;
    private final Random random = new Random();

    @Autowired
    public LadderGameController(NamesFactory namesFactory,
        DestinationsFactory destinationsFactory) {
        this.namesFactory = namesFactory;
        this.destinationsFactory = destinationsFactory;
    }

    @GetMapping("/")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @PostMapping("/")
    public ModelAndView readLadderInfo(@RequestParam("countOfPeople") int countOfPeople) {
        ModelAndView mav = new ModelAndView("ladderForm");
        mav.getModelMap().addAttribute("countOfPeople", countOfPeople);
        return mav;
    }

    @PostMapping("/start")
    public ModelAndView drawLadder(@RequestParam("nameOfPeople") String[] nameOfPeople,
        @RequestParam("destination") String[] destinationArray,
        @RequestParam("maximumLadderHeight") int maximumLadderHeight) {
        ModelAndView mav = new ModelAndView("ladder");
        Optional<Names> optionalNames = namesFactory.createNames(nameOfPeople);
        Optional<Destinations> optionalDestinations = destinationsFactory.getDestinationsInstance(
            destinationArray, nameOfPeople.length);

        Names names = optionalNames.orElseThrow(() -> {
            throw new IllegalStateException();
        });
        Destinations destinations = optionalDestinations.orElseThrow(() -> {
            throw new IllegalStateException();
        });
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
