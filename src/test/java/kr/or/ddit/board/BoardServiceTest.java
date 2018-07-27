package kr.or.ddit.board;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

import org.junit.Test;

public class BoardServiceTest {
	BoardServiceInf boardService = new BoardService();

	@Test
	public void selectAllBoardTest() {
		/***Given***/

		/***When***/
		List<BoardVo> boardList = boardService.selectAllBoard();
		for(BoardVo vo : boardList){
			System.out.println(vo);
		}
		
		/***Then***/
		assertEquals(2, boardList.size());
	}
	
	@Test
	public void getBoardTest(){

		/***When***/
		BoardVo boardVo = boardService.getBoard(1);
		System.out.println(boardVo.getBoard_content());
		/***Then***/
		
		assertEquals("시험용입니다.", boardVo.getBoard_content());

	}
	
	@Test
	public void insertBoardTest(){
		/***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBoard_content("테스트중입니다.(내용)");
		boardVo.setBoard_file("테스트중(파일경로)");
		boardVo.setBoard_filename("테스트중(파일네임)");
		boardVo.setBoard_parent(1);
		boardVo.setBoard_reply(1);
		boardVo.setBoard_title("테스트중입니다.(제목)");
		
		/***When***/
		int result = boardService.insertBoard(boardVo);
		/***Then***/
		assertEquals(1, result);
	}
	
	@Test
	public void updateBoardTest(){
		/***Given***/
		BoardVo boardVo = boardService.getBoard(23);
		

		/***When***/
		boardVo.setBoard_title("수정중2");
		boardVo.setBoard_content("내용 수정2");
		boardVo.setBoard_file("asdfaf821748sdafadsf2");
		
		System.out.println(boardVo);
		
		int result = boardService.updateBoard(boardVo);
		
		/***Then***/
		assertEquals(1, result);
	}
}
