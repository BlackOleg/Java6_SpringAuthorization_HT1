package olegivanov.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> credentialsHandler(InvalidCredentials e) {
        return new ResponseEntity<>("Invalid gredentials in " + e,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unauthorizedHandler(UnauthorizedUser e) {
        return new ResponseEntity<>( "Unauthorized access in " + e ,
                HttpStatus.UNAUTHORIZED);
    }

}
