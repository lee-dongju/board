package kr.or.ddit.post;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;

import org.junit.Test;

public class PostDaoTest {

//	@Test
//	public void insertPostTest() {
//		/***Given***/
//		PostDaoInf postDao = new PostDao();
//		PostVo postVo = new PostVo();
//		
//		postVo.setPostList_use("y");
//		postVo.setPostName("테스트.");
//		
//		/***When***/
//		System.out.println(postVo.getPostList_num());
//		int result = postDao.insertPost(postVo);
//
//		/***Then***/
//		assertEquals(1, result);
//	}
	
	@Test
	public void typePostTest(){
		/***Given***/
		PostDaoInf postDao = new PostDao();
		PostVo postVo = new PostVo();
		
		/***When***/
		String postList_use = "y";
		List<PostVo> postList = postDao.typePost(postList_use);

		/***Then***/
		System.out.println(postList);
		assertEquals(2, postList.size());
	}
}
