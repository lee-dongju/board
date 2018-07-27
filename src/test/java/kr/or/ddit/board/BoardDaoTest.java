package kr.or.ddit.board;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

import org.junit.Test;

public class BoardDaoTest {
	BoardDaoInf boardDao = new BoardDao();

//	@Test
//	public void selectAllBoardTest() {
//		/***When***/
//		List<BoardVo> boardList = boardDao.selectAllBoard();
//		for(BoardVo vo : boardList){
//			System.out.println(vo);
//		}
//		
//		/***Then***/
//		assertEquals(7, boardList.size());
//	}
	
//	@Test
//	public void getBoardTest(){
//
//		/***When***/
//		BoardVo boardVo = boardDao.getBoard(1);
//		System.out.println(boardVo.getBoard_content());
//		/***Then***/
//		
//		assertEquals("시험용입니다.", boardVo.getBoard_content());
//
//	}
	
	@Test
	public void insertBoardTest(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_content("테스트중입니다.(내용)");
		boardVo.setStd_id("2");
		boardVo.setBoard_file("테스트중(파일경로)");
		boardVo.setBoard_filename("테스트중(파일네임)");
		boardVo.setBoard_parent(43);
		boardVo.setBoard_reply(43);
		boardVo.setBoard_title("테스트중입니다.(제목)");
		boardVo.setBoard_delete("n");
		
		/***When***/
		int result = boardDao.insertBoard(boardVo);
		/***Then***/
		assertEquals(1, result);
	}
	
//	@Test
//	public void updateBoardTest(){
//		/***Given***/
//		BoardVo boardVo = boardDao.getBoard(23);
//		
//
//		/***When***/
//		boardVo.setBoard_title("수정중");
//		boardVo.setBoard_content("내용 수정");
//		boardVo.setBoard_file("asdfaf821748sdafadsf");
//		
//		System.out.println(boardVo);
//		
//		int result = boardDao.updateBoard(boardVo);
//		
//		/***Then***/
//		assertEquals(1, result);
//	}
	
//	@Test
//	public void deleteBoardTest(){
//		/***Given***/
//
//		/***When***/
//		int result = boardDao.deleteBoard(25);
//
//		/***Then***/
//		assertEquals(1, result);
//	}
}
