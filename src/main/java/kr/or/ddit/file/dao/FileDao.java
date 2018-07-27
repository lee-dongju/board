package kr.or.ddit.file.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class FileDao implements FileDaoInf {
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	 * 
	 * Method : getFile
	 * 최초작성일 : 2018. 7. 26.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param file_id
	 * @return
	 * Method 설명 :해당 파일 id를 받아 파일을 반환
	 */
	@Override
	public FileVo getFile(int file_id) {
		SqlSession session = sqlSessionFactory.openSession();
		FileVo fileVo = session.selectOne("file.getFile", file_id);
		session.close();
		
		return fileVo;
	}

	/**
	 * 
	 * Method : insertFile
	 * 최초작성일 : 2018. 7. 26.
	 * 작성자 : pc19
	 * 변경이력 :
	 * @param fileVo
	 * @return
	 * Method 설명 :첨부파일 추가
	 */
	@Override
	public int insertFile(FileVo fileVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int result = session.insert("file.insertFile", fileVo);
		session.commit();
		session.close();
		
		return result;
	}
}
