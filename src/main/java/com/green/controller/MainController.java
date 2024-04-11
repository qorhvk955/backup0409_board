package com.green.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.VO.ConditionValue;
import com.green.VO.PageVO;
import com.green.service.BoardService;

@CrossOrigin
@Controller
@RequestMapping(value={"/", "/main"})
public class MainController {
	
	@Autowired
	BoardService service;
	
	///////////////////////////////////////////////////////////
	/*	JSP 형식	*/
//	@GetMapping("/")
//	public String goToMain(Model model, ConditionValue cv) {
//		
//		long total = service.getVrCount();
//		
//		model.addAttribute("vrList", service.getMainVrList());
//		model.addAttribute("videoList", service.getMainVideoList());
//		model.addAttribute("page", new PageVO(cv, total));		
//		return "/main/mainpage";
//	}
	
	/*	Json 형식	*/
	@GetMapping("/")
	public ResponseEntity<Map<String, Object>> goToMain() {
		
	    Map<String, Object> response = new HashMap<>();
	    response.put("vrList", service.getMainVrList());
	    response.put("videoList", service.getMainVideoList());    
	    return ResponseEntity.ok(response);
	}
	
	//////////////////////////////////////////////////////////////
	
	@GetMapping("/signin")
	public String goToSignIn() {
		return "/main/signinpage";
	}
	
	@GetMapping("/signup")
	public String goToSignUp() {
		return "/main/signuppage";
	}
	
	@PostMapping("/signup")
	public String submitSignup() {		
		return "";
	}
//	
	/*	JSP 형식	*/	
//	@GetMapping("/vr")
//	public String goToVr(Model model, ConditionValue cv) {
//		
//		long total = service.getVrCount();
//		
//		model.addAttribute("list", service.getVrList(cv));
//		model.addAttribute("page", new PageVO(cv, total));
//		
//		return "/section/vr";
//	}
	
	/*	Json 형식	*/
	@GetMapping("/vr")
    public ResponseEntity<Map<String, Object>> goToVr(ConditionValue cv) {
        long total = service.getVrCount();
        Map<String, Object> response = new HashMap<>();
        response.put("list", service.getVrList(cv));
        response.put("page", new PageVO(cv, total));
         
        return ResponseEntity.ok(response);
    }
	
	
//	
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
