package kr.or.ddit.post;

import static org.junit.Assert.*;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

import org.junit.Test;

public class PostServiceTest {

	@Test
	public void insertPostTest() {
		/***Given***/
		PostServiceInf postService = new PostService();
		PostVo postVo = new PostVo();
		
		postVo.setPostList_use("y");
		postVo.setPostName("테스트111.");
		
		/***When***/
		System.out.println(postVo.getPostList_num());
		int result = postService.insertPost(postVo);

		/***Then***/
		assertEquals(1, result);

	}
	
	@Test
	public void deleteBoardTest(){
		/***Given***/
		BoardServiceInf boardService = new BoardService();
		/***When***/
		int result = boardService.deleteBoard(26);

		/***Then***/
		assertEquals(1, result);
	}

}
