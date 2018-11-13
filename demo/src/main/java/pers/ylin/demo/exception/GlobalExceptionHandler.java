package pers.ylin.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import pers.ylin.demo.entity.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Ylin on 2018/9/5
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IOException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "IOException occured")
    public void handleIOException(HttpServletRequest request, Exception ex){

    }

    @ExceptionHandler(RuntimeException.class)
    public @ResponseBody Result handleRuntimeException(HttpServletRequest request, Exception ex){

        Result result = new Result();
        result.setResultCode(Result.ResultCode.CODE_800000.getResultCode());
        result.setResultMsg(ex.getMessage());
        return result;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(HttpServletRequest request, Exception ex){
        log.error(Result.ResultCode.CODE_800000.getResultMsg(),ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
