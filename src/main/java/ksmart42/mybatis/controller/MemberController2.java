package ksmart42.mybatis.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart42.mybatis.dto.Member;
import ksmart42.mybatis.dto.MemberLevel;
import ksmart42.mybatis.service.MemberService2;

@Controller
@RequestMapping("/member2")
public class MemberController2 {
	
	private MemberService2 memberService2;
	
	public MemberController2(MemberService2 memberService2) {
		this.memberService2 = memberService2;
	}
	
	@GetMapping("/memberList")
	public String getMemberList(Model model) {
		
		List<Member> memberList = memberService2.getmemberList();
		
		model.addAttribute("title", "두번째 회원목록");
		model.addAttribute("memberList", memberList);
		
		return "exMember/memberList";		
	}
	
	@GetMapping("/addMember")
	public String addMember(Model model) {
		List<MemberLevel> memberLevelList= memberService2.getMemberLevelList();
		
		model.addAttribute("title", "두번째 회원가입");
		model.addAttribute("memberLevelList", memberLevelList);
		
		return "exMember/addMember";
	}
	
	@PostMapping("/addMember")
	public String addMember(Member member) {
		
		memberService2.addMember(member);
		return "redirect:/exMember/memberList";
	}
}
