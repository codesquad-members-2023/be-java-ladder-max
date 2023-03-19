package kr.codesquad.ladder.controller;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import kr.codesquad.ladder.domain.Destinations;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.LadderGenerator;
import kr.codesquad.ladder.domain.LadderResults;
import kr.codesquad.ladder.domain.LadderResultsFactory;
import kr.codesquad.ladder.domain.Names;
import kr.codesquad.ladder.dto.DestinationsDto;
import kr.codesquad.ladder.dto.LadderDto;
import kr.codesquad.ladder.dto.LadderResultsDto;
import kr.codesquad.ladder.dto.NamesDto;
import kr.codesquad.ladder.exception.InvalidCountOfPeopleException;
import kr.codesquad.ladder.view.LadderConsoleReader;
import kr.codesquad.ladder.view.LadderConsoleWriter;
import kr.codesquad.ladder.view.LadderReader;
import kr.codesquad.ladder.view.LadderWriter;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class LadderGameWebController {

    private final Random random;
    private final ModelMapper modelMapper;

    public LadderGameWebController() {
        random = new Random();
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
            .setFieldAccessLevel(AccessLevel.PRIVATE)
            .setFieldMatchingEnabled(true);
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
            throw new InvalidCountOfPeopleException();
        }

        ModelAndView mav = new ModelAndView("ladderForm");
        mav.getModelMap().addAttribute("countOfPeople", countOfPeople);
        return mav;
    }

    @PostMapping("/ladder/result")
    public ModelAndView ladderResultView(@RequestParam String[] nameOfPeople,
        @RequestParam String[] destination,
        @RequestParam Integer maximumLadderHeight) {
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(
            toInputStream(nameOfPeople, destination, maximumLadderHeight))));
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

        NamesDto namesDto = modelMapper.map(names, NamesDto.class);
        DestinationsDto destinationsDto = modelMapper.map(destinations, DestinationsDto.class);
        LadderDto ladderDto = modelMapper.map(ladder, LadderDto.class);
        LadderResultsDto ladderResultsDto = modelMapper.map(ladderResults, LadderResultsDto.class);

        mav.getModelMap().addAttribute("names", namesDto);
        mav.getModelMap().addAttribute("destinations", destinationsDto);
        mav.getModelMap().addAttribute("ladder", ladderDto);
        mav.getModelMap().addAttribute("ladderResults", ladderResultsDto);

        return mav;
    }

    private byte[] toInputStream(String[] nameOfPeople, String[] destinations,
        int maximumLadderHeight) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(",", nameOfPeople)).append("\n");
        sb.append(String.join(",", destinations)).append("\n");
        sb.append(maximumLadderHeight);
        return sb.toString().getBytes();
    }

}
