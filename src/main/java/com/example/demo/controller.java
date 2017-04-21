package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class controller {

	@RequestMapping(value="/", method=RequestMethod.POST)
	public Demo create(@RequestBody Demo demo)
	{
		return demo;
	}
}
