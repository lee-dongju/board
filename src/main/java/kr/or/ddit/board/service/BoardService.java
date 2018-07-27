package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;

public class BoardService implements BoardServiceInf {
	private BoardDaoInf boardDao = new BoardDao();
	
	@Override
	public List<BoardVo> selectAllBoard() {
		return boardDao.selectAllBoard();
	}

	@Override
	public Map<String, Object> getBoardPageList(Map<String, Integer> map) {
		int page = map.get("page");
		int pageSize = map.get("pageSize");

		Map<String, Object> resultMap = new HashMap<String, Object>();

		List<BoardVo> boardList = boardDao.selectAllBoard();
		resultMap.put("boardList", boardList);
		
		List<BoardVo> pageList = boardDao.getBoardPageList(map);
		resultMap.put("pageList", pageList);

		int totCnt = boardDao.getBoardTotCnt();
		resultMap.put("totCnt", totCnt);

		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));

		return resultMap;
	}

	private String makePageNavi(int page, int pageSize, int totCnt){
		int cnt = totCnt / pageSize;
		int mod = totCnt % pageSize;
		
		if(mod > 0){
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : (page-1);
		int nextPage = page == cnt ? cnt : (page+1);
		
		pageNaviStr.append("<li><a href=\"/boardServlet?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\"><span aria-hidden=\"true\">&laquo;</span></a></li>");
		for(int i = 1; i <= cnt; i++){
			String activeClass = "";
			if(i == page){
				activeClass = "class=\"active\"";
			}

			pageNaviStr.append("<li " + activeClass + "><a href=\"/boardServlet?page=" + i + "&pageSize=" + pageSize + "\">" + i + "</a></li>");
		}
		pageNaviStr.append("<li><a href=\"/boardServlet?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\"><span aria-hidden=\"true\">&raquo;</span></a></li>");
		return pageNaviStr.toString();
	}

	@Override
	public BoardVo getBoard(int num) {
		return boardDao.getBoard(num);
	}

	@Override
	public int insertBoard(BoardVo boardVo) {
		return boardDao.insertBoard(boardVo);
	}

	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}

	@Override
	public int deleteBoard(int board_num) {
		return boardDao.deleteBoard(board_num);
	}
}
