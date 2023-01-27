package tw.survival.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionControllerHandler {

	@ExceptionHandler(Exception.class)
	public Object myExceptionHandle(Exception e) {
		String errMsg1 = "Error: Exception";
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMsg1);
	}
	
	@ExceptionHandler(MySystemException.class)
	public Object myExceptionHandle(MySystemException e) {
		String errMsg2 = "Error: " + e.getMsg();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errMsg2);
	}
}