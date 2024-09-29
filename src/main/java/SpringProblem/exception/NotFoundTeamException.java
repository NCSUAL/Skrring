package SpringProblem.exception;

import lombok.Getter;

@Getter
public class NotFoundTeamException extends RuntimeException{
    public NotFoundTeamException(String message){
        super(message);
    }
}
