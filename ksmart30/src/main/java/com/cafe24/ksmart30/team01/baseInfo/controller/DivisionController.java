package com.cafe24.ksmart30.team01.baseInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DivisionController {

	@GetMapping("/baseInfo/divisionView")
	public String divisionView() {
		return "baseInfo/divisionView";
	}
}
