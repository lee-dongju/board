package kr.or.ddit.file;

import static org.junit.Assert.*;
import kr.or.ddit.file.dao.FileDao;
import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;

import org.junit.Test;

public class FileDaoTest {

	@Test
	public void getFileTest() {
		/***Given***/
		FileDaoInf fileDao = new FileDao();
		
		int num = 3;
		/***When***/
		FileVo fileVo = fileDao.getFile(num);
		
		/***Then***/
		
	}

}
