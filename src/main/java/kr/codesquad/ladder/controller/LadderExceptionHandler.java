package kr.codesquad.ladder.controller;

import kr.codesquad.ladder.exception.InvalidCountOfDestinationsException;
import kr.codesquad.ladder.exception.InvalidCountOfPeopleException;
import kr.codesquad.ladder.exception.InvalidFormatOfDestinationException;
import kr.codesquad.ladder.exception.InvalidNameFormatOfPeopleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> handleInvalidCountOfPeopleException(
        InvalidCountOfPeopleException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleInvalidCountOfDestinationException(
        InvalidCountOfDestinationsException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> handleInvalidFormatOfDestinationException(
        InvalidFormatOfDestinationException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
}
