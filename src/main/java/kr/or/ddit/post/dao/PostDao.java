package kr.or.ddit.post.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.post.model.PostVo;

public class PostDao implements PostDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * 
	 * Method : insertPost
	 * 최초작성일 : 2018. 7. 20.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 새로운 게시판 생성
	 */
	@Override
	public int insertPost(PostVo postVo) {
		SqlSession session = sqlSessionFactory.openSession();
		System.out.println("dao postVo : " + postVo.getPostName());
		int result = session.insert("post.insertPost", postVo);
		session.commit();
		session.close();
		
		return result;
	}

	/**
	 * 
	 * Method : getPost
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param postList_num
	 * @return
	 * Method 설명 : 게시판 번호에 해당하는 게시판 호출
	 */
	@Override
	public PostVo getPost(int postList_num) {
		SqlSession session = sqlSessionFactory.openSession();
		PostVo postList = session.selectOne("post.getPost", postList_num);
		session.close();
		
		return postList;
	}
	
	/**
	 * 
	 * Method : getAllPost
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 모든 게시판 리스트 불러오기
	 */
	@Override
	public List<PostVo> getAllPost() {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.getAllPost");
		session.close();
		
		return postList;
	}

	@Override
	public List<PostVo> typePost(String postList_use) {
		SqlSession session = sqlSessionFactory.openSession();
		List<PostVo> postList = session.selectList("post.typePost", postList_use);
		session.close();
		
		return postList;
	}

}
