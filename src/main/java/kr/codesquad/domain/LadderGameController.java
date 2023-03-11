package kr.codesquad.domain;

import java.util.List;
import javax.validation.Valid;
import kr.codesquad.view.InputView;
import kr.codesquad.view.OutputView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LadderGameController {

    public static final String NOT_EXIST_NAME = "존재하지 않는 이름입니다.";
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderResultRepository ladderResultRepository;

    public LadderGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.ladderResultRepository = new LadderResultRepository();
    }

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute(new InputForm());
        return "game/start";
    }

    @PostMapping("/")
    public String newLadder(@Valid InputForm inputForm, Errors errors) {
        if (errors.hasErrors()) {
            return "game/start";
        }

        return "game/search";
    }

    public void run() {
        List<String> names = inputView.inputNames();
        int nameSize = names.size();

        List<String> resultInfo = inputView.inputResultInfo(nameSize);
        int ladderHeight = inputView.inputLadderHeight();

        LinesInfo linesInfo = LinesInfo.create(nameSize, ladderHeight);
        String drawnLadder = drawLadder(linesInfo);
        printLadder(names, drawnLadder, resultInfo);

        linesInfo.calculatorAndSaveResult(ladderResultRepository, names, resultInfo);

        inputSearchInfo();
    }

    private void inputSearchInfo() {
        SearchInfo searchInfo = inputView.inputSearchInfo();
        SearchType searchType = searchInfo.getSearchType();
        switch (searchType) {
            case CLOSE:
                outputView.printClose();
                return;
            case ALL: {
                String searchAll = ladderResultRepository.searchAll();
                outputView.printResult(searchAll);
                break;
            }
            case SINGLE: {
                String name = searchInfo.getName();
                if (ladderResultRepository.containsName(name)) {
                    String singleResult = ladderResultRepository.searchSingleResult(name);
                    outputView.printResult(singleResult);
                    break;
                }
                System.out.println(NOT_EXIST_NAME);
                break;
            }
        }
        inputSearchInfo();
    }

    private void printLadder(List<String> names, String drawnLadder, List<String> result) {
        outputView.printLadder(names, drawnLadder, result);
    }

    private String drawLadder(LinesInfo linesInfo) {
        return linesInfo.draw();
    }
}
