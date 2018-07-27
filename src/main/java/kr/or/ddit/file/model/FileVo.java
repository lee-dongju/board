package kr.or.ddit.file.model;

public class FileVo {
	private int file_id;
	private int board_num;
	private String file_path;
	private String file_name;
	
	public int getFile_id() {
		return file_id;
	}
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	@Override
	public String toString() {
		return "FileVo [file_id=" + file_id + ", board_num=" + board_num
				+ ", file_path=" + file_path + ", file_name=" + file_name + "]";
	}
}
