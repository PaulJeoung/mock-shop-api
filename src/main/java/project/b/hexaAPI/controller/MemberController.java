package project.b.hexaAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.b.hexaAPI.dao.MemberDAO;
import project.b.hexaAPI.dao.ProductDAO;
import project.b.hexaAPI.service.MemberService;

@RestController
@RequestMapping("/api/member")
public class MemberController {
	
	/*
	 * 전체 회원 조회
	 * id로 회원 조회
	 * 회원 이메일로 조회
	 * 회원 가입
	 * 이메일로 회원 정보 업데이트
	 * id로 회원 삭제 (미지원)
	 */
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/")
	public List<MemberDAO> getAllMembers() {
		return memberService.getAllMemberInfo();
	}
	
    @GetMapping("/{id}")
    public MemberDAO getMemberById(@PathVariable Long id) {
        Optional<MemberDAO> member = memberService.getMemberById(id);
        return member.orElse(null);
    }
    
    @GetMapping("/m/{userid}")
    public MemberDAO getMemberByUserId(@PathVariable String userid) {
    	Optional<MemberDAO> member = memberService.getMemberByUserId(userid);
    	return member.orElse(null);
    }

    @PostMapping("/")
    public MemberDAO addMember(@RequestBody MemberDAO member) {
        return memberService.addMember(member);
    }

    @PutMapping("/m/{userid}")
    public MemberDAO updateMember(@PathVariable String userid, @RequestBody MemberDAO memberForm) {
        return memberService.updateMemberInfo(userid, memberForm);
    }

}
