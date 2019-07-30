package com.ityongman.ctl;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ityongman.exception.BusinessException;
import com.ityongman.model.Add;
import com.ityongman.model.Business;
import com.ityongman.model.Update;
import com.ityongman.util.RespResult;

@RestController
public class BusinessController {
	@RequestMapping("/global")
	@ResponseBody
	public RespResult<Business> global() {
		int result = 1 / 0 ;
		
		return RespResult.successResult(200, new Business());
	}

	@RequestMapping("/business")
	@ResponseBody
	public RespResult<Business> business(@RequestParam int index) {
		if(index % 2 == 0) {
			throw new BusinessException(304, "business exception message");
		}
		
		return RespResult.successResult(200, new Business());
	}
	
	@RequestMapping("/validate")
	@ResponseBody
	public RespResult<Business> validate(@Validated @RequestBody Business business) {
		return RespResult.successResult(200, business);
	}
}
