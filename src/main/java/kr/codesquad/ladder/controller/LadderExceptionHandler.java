package kr.codesquad.ladder.controller;

import kr.codesquad.ladder.exception.InvalidCountOfDestinationsException;
import kr.codesquad.ladder.exception.InvalidCountOfPeopleException;
import kr.codesquad.ladder.exception.InvalidFormatOfDestinationException;
import kr.codesquad.ladder.exception.InvalidNameFormatOfPeopleException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@RestControllerAdvice
public class LadderExceptionHandler {

    @ExceptionHandler
    public ModelAndView handleInvalidNameFormatOfPeopleException(
        InvalidNameFormatOfPeopleException exception) {
        return new ModelAndView("redirect:/ladder");
    }

    @ExceptionHandler
    public ModelAndView handleInvalidCountOfPeopleException(
        InvalidCountOfPeopleException exception) {
        return new ModelAndView("redirect:/ladder");
    }

    @ExceptionHandler
    public ModelAndView handleInvalidCountOfDestinationException(
        InvalidCountOfDestinationsException exception) {
        return new ModelAndView("redirect:/ladder/form");
    }

    @ExceptionHandler
    public ModelAndView handleInvalidFormatOfDestinationException(
        InvalidFormatOfDestinationException exception) {
        return new ModelAndView("redirect:/ladder/form");
    }
}
