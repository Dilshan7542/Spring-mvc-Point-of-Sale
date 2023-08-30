package org.thogakade.advisor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.thogakade.util.ResponseUtil;

@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {
 /*   @ExceptionHandler({Exception.class})
    public ResponseUtil getExceptionHandler(Exception e){
        return new ResponseUtil(e.getLocalizedMessage(),"Failed",null); // we cant send status code (500) its always going to (200)
    }*/

   /* @ExceptionHandler({Exception.class}) // OPTION 1: we can use states code changed (500)
    public ResponseEntity getExceptionsHandler(Exception e){
        return new ResponseEntity(new ResponseUtil(e.getLocalizedMessage(),"Failed",null), HttpStatus.INTERNAL_SERVER_ERROR);
    }*/
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)//OPTION 2: we can use states code changed (500)
        @ExceptionHandler({Exception.class})
    public ResponseUtil getExceptionHandler(Exception e){
        return new ResponseUtil(e.getLocalizedMessage(),"Failed",null);
    }
}
