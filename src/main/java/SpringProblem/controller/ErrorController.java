package SpringProblem.controller;

import SpringProblem.exception.NotFoundTeamException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

@RestControllerAdvice
@Slf4j
public class ErrorController {

    @ExceptionHandler(NotFoundTeamException.class)
    public ResponseEntity<?> handleNotFoundTeamException(NotFoundTeamException e){
        log.error("해당 팀은 존재하지 않음");
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<?> handleDateTimeParseException(DateTimeParseException e){
        log.error("유효한 날짜가 아님");
        return ResponseEntity.badRequest().body("유효한 날짜가 아님");
    }

}
