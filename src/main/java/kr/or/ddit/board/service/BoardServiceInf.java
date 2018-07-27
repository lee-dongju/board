package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;

public interface BoardServiceInf {
	/**
	 * 
	 * Method : selectAllBoard
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : pc19
	 * 변경이력 :
	 * Method 설명 : 모든 게시물 조회.
	 */
	public List<BoardVo> selectAllBoard();
	
	/**
	 * 
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 게시물 페이지 리스트 조회
	 */
	public Map<String, Object> getBoardPageList(Map<String, Integer> map);
	
	/**
	 * 
	 * Method : getBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param id
	 * @return
	 * Method 설명 : 게시판 num을 입력받아 게시판을 조회한다.
	 */
	public BoardVo getBoard(int num);
	
	/**
	 * 
	 * Method : insertBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 새 게시글을 추가
	 */
	public int insertBoard(BoardVo boardVo);
	
	/**
	 * 
	 * Method : updateBoard
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시글 수정
	 */
	public int updateBoard(BoardVo boardVo);
	
	/**
	 * 
	 * Method : deleteBoard
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param board_num
	 * @return
	 * Method 설명 : 게시물 번호를 받아 게시물 삭제
	 */
	public int deleteBoard(int board_num);
}
