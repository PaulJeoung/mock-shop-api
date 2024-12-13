package project.b.hexaAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import project.b.hexaAPI.dao.MemberDAO;

@Service
public class MemberService {
	
	private List<MemberDAO> memberList = new ArrayList<>(); // <MemberDAO>
	
	public MemberService() {
		memberList.add(new MemberDAO(1L, false, "hex1@hex.com", "1111", "융석룡", "270", "010-5432-9876", true, ""));
		memberList.add(new MemberDAO(2L, false, "hex2@hex.com", "1111", "워니룔", "245", "010-5454-9126", true, ""));
		memberList.add(new MemberDAO(3L, false, "hex3@hex.com", "1111", "리줸윙", "7.5", "010-5645-9646", false, ""));
		memberList.add(new MemberDAO(4L, true, "hex4@hex.com", "1111", "장첸", "275", "010-6263-1176", true, ""));
		memberList.add(new MemberDAO(5L, false, "hex5@hex.com", "1111", "고둬샴", "260", "010-2355-9663", false, ""));
		memberList.add(new MemberDAO(6L, false, "hex6@hex.com", "1111", "킴댛흍", "8", "010-6477-9254", true, ""));
	}
	
	/*
	 * 전체 회원 조회
	 * id로 회원 조회
	 * 회원 이메일로 조회
	 * 회원 가입
	 * 이메일로 회원 정보 업데이트
	 * id로 회원 삭제 (미지원)
	 */
	
	public List<MemberDAO> getAllMemberInfo() {
		return memberList;
	}
	
	public Optional<MemberDAO> getMemberById(Long id) {
		return memberList.stream()
				.filter(member -> member.getId().equals(id))
				.findFirst();
	}
	
	public Optional<MemberDAO> getMemberByUserId(String userId) {
		return memberList.stream()
				.filter(member -> member.getUserId().equals(userId))
				.findFirst();
	}
	
	public MemberDAO addMember(MemberDAO member) {
		memberList.add(member);
		return member;
	}
	
	public MemberDAO updateMemberInfo(String userId, MemberDAO memberForm) {
		Optional<MemberDAO> memberInfo = getMemberByUserId(userId);
		if(memberInfo.isPresent()) {
			MemberDAO member = memberInfo.get();
			member.setUserNickname(memberForm.getUserNickname());
			member.setUserPassword(memberForm.getUserPassword());
			return member;
		}
		return memberInfo.get();
	}

}
