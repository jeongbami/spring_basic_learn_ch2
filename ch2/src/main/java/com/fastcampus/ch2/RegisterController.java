package com.fastcampus.ch2;

import java.net.URLEncoder;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
	//@RequestMapping("/register/add", method={RequestMethod.GET, RequestMethod.POST})
	//Method가 생략되어 있으면 GET,POST 둘 다 허용한다는 의미.
//	@GetMapping("/register/add")
//	public String register() { 
//		//신규 회원 가입 화면 
//		return "registerForm"; // WEB-INF/view/registerForm.jsp
//	}
//	
	//@RequestMapping("/register/save" method=RequestMethod.POST)
	
	
	@PostMapping("/register/save")
	public String save(User user, Model model) throws Exception {
		// 요청이 들어왔을 때 해야 할 일
		// 1. 유효성 검사
				
		
			if(!isValid(user)) { // 유효하지 않을 때
				String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
					
					model.addAttribute("msg",msg);
					return "redirect:/register/add";
					// == return "redirect:/register/add?msg="+msg; 
 				// 유효성 검사시 화면 되돌아갈 때 오류 msg와 함께 보내는 것을 URL 재작성 이라고 한다.
 				// URLEncoder -- 오류 메세지를 인코딩 해주는 코드 
			}
		
		
		
		// 2. DB에 신규회원 정보를 저장 
		return "registerInfo";
	}

	private boolean isValid(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}