package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.student.model.StudentVo;

public interface StudentDaoInf {
	
	/**
	 * 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	List<StudentVo> selectAllStudents();
	
	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 학생 id를 입력받아 학생정보를 조회한다.
	 */
	StudentVo getStudent(int id);
	
	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param name
	 * @return
	 * Method 설명 : studentVo 타입으로 입력받아 학생정보를 조회
	 */
	StudentVo getStudent(StudentVo student);
	
	/**
	 * 
	 * Method : getStudentPageList
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param map
	 * @return
	 * Method 설명 : 학생 페이지 리스트 조회
	 */
	List<StudentVo> getStudentPageList(Map<String, Integer> map);
	
	/**
	 * 
	 * Method : getStudentTotCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param totalCnt
	 * @return
	 * Method 설명 : 전체 건수를 구하기
	 */
	int getStudentTotCnt();
	
	/**
	 * 
	 * Method : studentUpdate
	 * 최초작성일 : 2018. 7. 17.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param studentVo
	 * @return
	 * Method 설명 : 학생 정보 업데이트
	 */
	int studentUpdate(StudentVo studentVo);
	
	/**
	 * 
	 * Method : getStudentInfo
	 * 최초작성일 : 2018. 7. 18.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 로그인 아이디 패스워드 확인
	 */
	public StudentVo getStudentInfo(Map<String, String> stdInfo);
}
