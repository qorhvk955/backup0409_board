package com.green.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.VO.ConditionValue;
import com.green.VO.PageVO;
import com.green.service.BoardService;

@Controller
@RequestMapping(value={"/", "/main"})
public class MainController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("")
	public String goToMain(Model model) {
		
		model.addAttribute("vrList", service.getMainVrList());
		model.addAttribute("videoList", service.getMainVideoList());	
		System.out.println("goToMain");
		return "/main/mainpage";
	}
	
	@GetMapping("/signin")
	public String goToSignIn() {
		System.out.println("goToSignIn");
		return "/main/signinpage";
	}
	
	@GetMapping("/signup")
	public String goToSignUp() {
		System.out.println("goToSignUp");
		return "/main/signuppage";
	}
	
	@PostMapping("/signup")
	public String submitSignup() {		
		return "";
	}
	
	@GetMapping("/vr")
	public String goToVr(Model model, ConditionValue cv) {
		
		long total = service.getVrCount();
		
		model.addAttribute("list", service.getVrList(cv));
		model.addAttribute("page", new PageVO(cv, total));
		
		return "/section/vr";
	}
	
	@GetMapping("/clip")
	public String goToClip(Model model, ConditionValue cv) {
		
		long total = service.getVideoCount();
		
		model.addAttribute("list", service.getVideoList(cv));
		model.addAttribute("page", new PageVO(cv, total));
		
		return "/section/clip";
	}
	
	@GetMapping("/viewmap")
	public String goToViewMap() {
		return "/section/viewmap";
	}
}
