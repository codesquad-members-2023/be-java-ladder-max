package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LadderGameController {

    private final LadderResultRepository ladderResultRepository;
    private final LadderService ladderService;

    public LadderGameController(
            LadderResultRepository ladderResultRepository,
            LadderService ladderService) {
        this.ladderResultRepository = ladderResultRepository;
        this.ladderService = ladderService;
    }


    @GetMapping("/")
    public ModelAndView indexPage(Model model) {
        model.addAttribute(new InputForm());
        ladderResultRepository.clear();
        return new ModelAndView("game/start");
    }

    @PostMapping("/")
    public ModelAndView newLadder(@Valid InputForm inputForm, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return new ModelAndView("game/start");
        }

        List<String> names = Arrays.stream(inputForm.getNames().split(",")).collect(Collectors.toList());
        List<String> resultInfo = Arrays.stream(inputForm.getResultInfo().split(",")).collect(Collectors.toList());
        if (names.size() != resultInfo.size()) {
            model.addAttribute("sizeMatchError", "이름과 결과의 수량이 일치하지 않습니다.");
            return new ModelAndView("game/start");
        }

        LinesInfo linesInfo = LinesInfo.create(names.size(), inputForm.getLadderHeight());
        String drawLadder = linesInfo.draw();
        String drawnLadder = ladderService.printLadder(names, drawLadder, resultInfo);

        model.addAttribute("drawnLadder", drawnLadder);
        linesInfo.calculatorAndSaveResult(ladderResultRepository, names, resultInfo);
        model.addAttribute(new SearchInfoForm());
        return new ModelAndView("game/search");
    }

    @PostMapping("/search")
    public ModelAndView searchInfo(SearchInfoForm searchInfoForm, Model model) {
        String command = searchInfoForm.getCommand();
        SearchInfo searchInfo = ladderService.checkCommand(command);

        String result = ladderService.inputSearchInfo(searchInfo);

        if (result == null) {
            model.addAttribute("nameError", "존재하지 않는 이름입니다.");
            return new ModelAndView("game/search");
        }
        if (searchInfo.getSearchType() == SearchType.SINGLE) {
            model.addAttribute("single", result);
            return new ModelAndView("game/search");
        }
        if (searchInfo.getSearchType() == SearchType.ALL) {
            model.addAttribute("all", result);
            return new ModelAndView("game/search");
        }
        return new ModelAndView("redirect:/");
    }


}
