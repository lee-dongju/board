package kr.or.ddit.student.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {
	private Logger logger = LoggerFactory.getLogger(StudentDao.class);
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	/**
	 * 
	 * Method : selectAllStudents
	 * 최초작성일 : 2018. 7. 9.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Override
	public List<StudentVo> selectAllStudents() {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.selectAllStudents");
		session.close();
		
		return studentList;
	}
	
	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @return
	 * Method 설명 : 학생 id를 입력받아 학생정보를 조회한다.
	 */
	@Override
	public StudentVo getStudent(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo student = session.selectOne("student.getStudent", id);
		session.close();
		
		return student;
	}

	/**
	 * 
	 * Method : getStudent
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param student
	 * @return
	 * Method 설명 : studentVo 타입으로 입력받아 학생정보를 조회
	 */
	@Override
	public StudentVo getStudent(StudentVo student) {
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo studentVo = session.selectOne("student.getStudentVo", student);
		session.close();
		
		return studentVo;
	}

	
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
	@Override
	public List<StudentVo> getStudentPageList(Map<String, Integer> map) {
		SqlSession session = sqlSessionFactory.openSession();
		List<StudentVo> studentList = session.selectList("student.getStudentPageList", map);
		session.close();
		
		return studentList;
	}

	/**
	 * 
	 * Method : getStudentTotCnt
	 * 최초작성일 : 2018. 7. 11.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param totalCnt
	 * @return
	 * Method 설명 : 전체 건수를 조회
	 */
	@Override
	public int getStudentTotCnt() {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.selectOne("student.getStudentTotCnt");
		session.close();
		
		return result;
	}

	@Override
	public int studentUpdate(StudentVo studentVo) {
		System.out.println(studentVo.getName());
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.update("student.studentUpdate", studentVo);
		session.commit();
		session.close();
		return result;
	}

	@Override
	public StudentVo getStudentInfo(Map<String, String> stdInfo) {
		logger.debug("dao 실행");
		StudentVo student = new StudentVo();
		System.out.println("실행전 결과 : " + stdInfo.get("std_id"));
		SqlSession session = sqlSessionFactory.openSession();
		student = session.selectOne("student.getStudentInfo", stdInfo);
		session.close();
		
		return student;
	}
}
