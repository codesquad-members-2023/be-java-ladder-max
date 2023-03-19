package kr.codesquad.ladder.Controller;

import kr.codesquad.ladder.Service.LadderService;
import kr.codesquad.ladder.domain.Ladder;
import kr.codesquad.ladder.domain.Line;
import kr.codesquad.ladder.domain.ResultLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class WebController {
    LadderService ladderService = new LadderService();
    @PostMapping("/ladder")
    public String postLadder (HttpServletRequest request,Model model){
        String name = request.getParameter("name");
        String result = request.getParameter("result");
        int length = Integer.parseInt(request.getParameter("length"));
        String ladder = ladderService.makeLadder(length,name,result).toString();
        model.addAttribute("value",ladder);
        model.addAttribute("userName",name.split(","));
        model.addAttribute("resultName",result.split(","));
        return"ladder";
    }
    @PostMapping("/result")
    public String postResultPage(HttpServletRequest request,Model model)  {
        String str =request.getParameter("search");
        model.addAttribute("resultLadder",ladderService.resultLadder(str));
        return "result";
    }

}
