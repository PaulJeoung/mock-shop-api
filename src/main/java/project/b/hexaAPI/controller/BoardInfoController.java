package project.b.hexaAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.b.hexaAPI.dao.BoardInfoDAO;
import project.b.hexaAPI.service.BoardInfoService;

@RestController
@RequestMapping("/api/board/info")
public class BoardInfoController {
	
	/*
	 * 전체 공지사항 조회
	 * id별 공지사항 조회
	 * 공지사항 등록
	 * 공지사항 수정
	 */
	
	@Autowired
	private BoardInfoService boardInfoService;
	
	@GetMapping ("/")
	public List<BoardInfoDAO> getAllBoardInfo() {
		return boardInfoService.getAllBoardInfo();
	}
	
	@GetMapping ("/{id}")
	public BoardInfoDAO getBoardInfoById(@PathVariable Long id) {
		Optional<BoardInfoDAO> boardInfo = boardInfoService.getInfoById(id);
		return boardInfo.orElse(null);
	}
	
	@PostMapping ("/")
	public BoardInfoDAO addBoardInfo(@RequestBody BoardInfoDAO boardInfoDAO) {
		return boardInfoService.addBoardInfo(boardInfoDAO);
	}
	
	@PutMapping("{id}")
	public BoardInfoDAO updateBoardInfo(@PathVariable Long id, @RequestBody BoardInfoDAO boardInfoDAO) {
		return boardInfoService.updateInfo(id, boardInfoDAO);
	}

}
