package ksmart42.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ksmart42.mybatis.dto.Member;
import ksmart42.mybatis.dto.MemberLevel;
import ksmart42.mybatis.mapper.MemberMapper2;

@Service
@Transactional
public class MemberService2 {

	private MemberMapper2 memberMapper2;
	
	public MemberService2(MemberMapper2 memberMapper2) {
		this.memberMapper2 = memberMapper2;
	}
	
	public List<Member> getmemberList(){
		
		List<Member> memberList = memberMapper2.getMemberList();
		return memberList;
	}
	
	public int addMember(Member member) {
		int result = memberMapper2.addMember(member);
		return result;
	}

	public List<MemberLevel> getMemberLevelList() {
		List<MemberLevel> memberLevelList = memberMapper2.getMemberLevelList();
		return memberLevelList;
	}
}
