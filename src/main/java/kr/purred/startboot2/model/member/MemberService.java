package kr.purred.startboot2.model.member;

import kr.purred.startboot2.model.member.domain.Member;

import java.util.List;

public interface MemberService
{
	List<Member> findAll();
}
