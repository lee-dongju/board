package kr.or.ddit.file.service;

import kr.or.ddit.file.dao.FileDao;
import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;

public class FileService implements FileServiceInf{
	FileDaoInf fileDao = new FileDao();
	
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
		return fileDao.getFile(file_id);
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
		return fileDao.insertFile(fileVo);
	}
}
