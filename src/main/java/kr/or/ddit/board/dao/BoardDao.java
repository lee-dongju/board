package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class BoardDao implements BoardDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	 * 
	 * Method : selectAllBoard
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @return
	 * Method 설명 :모든 게시물 조회
	 */
	@Override
	public List<BoardVo> selectAllBoard() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.selectAllBoard");
		session.close();
		
		return boardList;
	}

	/**
	 * 
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 게시판 페이지 리스트 조회
	 */
	@Override
	public List<BoardVo> getBoardPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.getBoardPageList", map);
		session.close();
		
		return boardList;
	}

	/**
	 * 
	 * Method : getBoardTotCnt
	 * 최초작성일 : 2018. 7. 19.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 건수 조회
	 */
	@Override
	public int getBoardTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.selectOne("board.getBoardTotCnt");
		session.close();
		
		return result;
	}

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
	@Override
	public BoardVo getBoard(int num) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardVo board = session.selectOne("board.getBoard", num);
		session.close();
		
		return board;
	}

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
	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println(boardVo);
		int result = session.insert("board.insertBoard", boardVo);
		session.commit();
		session.close();
		
		return result;
	}

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
	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.update("board.updateBoard", boardVo);
		session.commit();
		session.close();
		
		return result;
	}

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
	@Override
	public int deleteBoard(int board_num) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.delete("board.deleteBoard", board_num);
		session.commit();
		session.close();
		
		return result;
	}
}
