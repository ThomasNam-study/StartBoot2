package kr.purred.startboot2.model.member.imp;

import kr.purred.startboot2.model.member.MemberService;
import kr.purred.startboot2.model.member.domain.Member;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImp implements MemberService
{
	private final List<Member> members = new ArrayList<> ();

	@PostConstruct
	void init ()
	{
		members.add (new Member ("purred", "남한희", "01053496254", "purred@naver.com"));
	}

	@Override
	public List<Member> findAll ()
	{
		return new ArrayList<> (members);
	}
}
