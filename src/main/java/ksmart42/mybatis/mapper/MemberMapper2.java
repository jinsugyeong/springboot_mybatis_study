package ksmart42.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.mybatis.dto.Member;
import ksmart42.mybatis.dto.MemberLevel;

@Mapper
public interface MemberMapper2 {
	//회원 등급 목록 조회
		public List<MemberLevel> getMemberLevelList();
		
	//회원 전체목록 조회 
	public List<Member> getMemberList();
	
	//회원 가입 
	public int addMember(Member member);
}
