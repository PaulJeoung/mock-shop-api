package project.b.hexaAPI.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import project.b.hexaAPI.dao.BoardInfoDAO;

@Service
public class BoardInfoService {
	
	private List<BoardInfoDAO> infoList = new ArrayList<>();
	
	public BoardInfoService() {
		infoList.add(new BoardInfoDAO(1L, "회원 가입 안내", "어서오게나 용사여", LocalDateTime.now()));
		infoList.add(new BoardInfoDAO(2L, "로그인 회만만 보세요", "도네이션 플리즈", LocalDateTime.now()));
		infoList.add(new BoardInfoDAO(3L, "긴급 공지", "다들 집에 가세요", LocalDateTime.now()));
		infoList.add(new BoardInfoDAO(4L, "배송 지연 안내", "배송기사 퇴사로 인한 지연 안내... 쏘오리", LocalDateTime.now()));
		infoList.add(new BoardInfoDAO(5L, "나이키 에어포스 수급 안내", "짝퉁이 많은 관계로 당분간 판매를 중단 합니다", LocalDateTime.now()));
	}
	
	/*
	 * 전체 공지사항 조회
	 * id별 공지사항 조회
	 * 공지사항 등록
	 * 공지사항 수정
	 */
	
	public List<BoardInfoDAO> getAllBoardInfo() {
		return infoList;
	}
	
	public Optional<BoardInfoDAO> getInfoById (Long id) {
		return infoList.stream()
				.filter(list -> list.getId().equals(id))
				.findFirst();
	}
	
	public BoardInfoDAO addBoardInfo(BoardInfoDAO boardInfoDAO) {
		infoList.add(boardInfoDAO);
		return boardInfoDAO;
	}
	
	public BoardInfoDAO updateInfo(Long id, BoardInfoDAO infoDescription) {
		Optional<BoardInfoDAO> optionalInfo = getInfoById(id);
		if(optionalInfo.isPresent()) {
			BoardInfoDAO info = optionalInfo.get();
			info.setTitle(infoDescription.getTitle());
			info.setDescription(infoDescription.getDescription());
			return info;
		}
		return null;
	}

}
