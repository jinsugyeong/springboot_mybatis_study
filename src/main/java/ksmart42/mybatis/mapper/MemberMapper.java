package ksmart42.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart42.mybatis.dto.Member;
import ksmart42.mybatis.dto.MemberLevel;

@Mapper
public interface MemberMapper {
	
	//회원 전체목록 조회 
	public List<Member> getMemberList();
	
	//회원 가입 
	public int addMember(Member member);
	
	//회원 등급 목록 조회
	public List<MemberLevel> getMemberLevelList();
	
	//회원 아이디 중복 체크
	public boolean isIdCheck(String memberId);
	
	//회원별 회원정보 조회
	public Member selectMember(String memberId);
	
	//회원 수정 처리
	public void modifyMember(Member member);
	
	
	//상품코드에 따른 구매이력 삭제
	public void removeOrderBySellerId(String memberId);
	
	//상품코드에 따른 구매이력 삭제
	public void removeGoodsBySellerId(String memberId);
	
	//구매자가 구매한 이력 
	public void removeOrder(String memberId);
	
	//회원의 로그인 이력 삭제
	public void removeLoginHistory(String memberId);
	
	//회원 삭제
	public void removeMember(String memberId);
	
	//로그인
	public Member login(String memberId, String memberPw);
	

}
