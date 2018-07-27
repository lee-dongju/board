package kr.or.ddit.student;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Test;

public class studentDaoTest {

	@Test
	public void studentDaoTest() {
		/***Given***/
		StudentDaoInf studentDao = new StudentDao();
		Map<String, String> stdInfo = new HashMap<String, String>();
		StudentVo studenVo = new StudentVo();
		
		/***When***/
		studenVo.setStd_id("ehdwn");
		studenVo.setPass("1234");
		
		stdInfo.put("std_id", studenVo.getStd_id());
		stdInfo.put("pass", studenVo.getPass());
		
		StudentVo student = studentDao.getStudentInfo(stdInfo);
		/***Then***/
		assertEquals("ehdwn", student.getStd_id());
	}
}
