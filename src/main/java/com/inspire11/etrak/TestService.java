package com.inspire11.etrak;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestService {

	@RequestMapping("/hello")
	public @ResponseBody String Hello()
	{
		return "Hello world";
	}
}
