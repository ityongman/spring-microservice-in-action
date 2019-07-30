package com.ityongman.intercept;

import java.util.List;

import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ityongman.exception.BusinessException;
import com.ityongman.util.RespResult;

@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 业务异常
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(BusinessException.class)
	@ResponseBody
	RespResult handleException(BusinessException be) {
		return RespResult.failResult(be.errCode, be.getMessage());
	}
	
	/**
	 * 未知异常
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(Exception.class)
	@ResponseBody
	RespResult handleException(Exception e) {
		return RespResult.failResult(500, e.getMessage());
	}
	
	/**
	 * 校验异常
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	RespResult handleException(MethodArgumentNotValidException manve) {
		List<ObjectError> allErrors = manve.getBindingResult().getAllErrors();
		if(CollectionUtils.isEmpty(allErrors)) {
			return RespResult.failResult(406, "Invalid Param !!!") ;
		}
		String errMsg = allErrors.get(0).getDefaultMessage() ;
		return RespResult.failResult(406, errMsg) ;
	}
}
