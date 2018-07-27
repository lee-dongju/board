package kr.or.ddit.post.service;

import java.util.List;

import kr.or.ddit.post.model.PostVo;

public interface PostServiceInf {
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
	public int insertPost(PostVo postVo);
	
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
	public PostVo getPost(int postList_num);
	
	/**
	 * 
	 * Method : getAllPost
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 모든 게시판 리스트 불러오기
	 */
	public List<PostVo> getAllPost();
	
	/**
	 * 
	 * Method : typePost
	 * 최초작성일 : 2018. 7. 23.
	 * 작성자 : pc19
	 * 변경이력 : 사용하기로 한 게시판만 표시하기
	 * @return
	 * Method 설명 :
	 */
	public List<PostVo> typePost(String postList_use);
}
