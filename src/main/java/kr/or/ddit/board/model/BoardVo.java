package kr.or.ddit.board.model;

import java.util.Date;

public class BoardVo {
	private int board_num;
	private String std_id;
	private String board_title;
	private String board_content;
	private Date board_reg;
	private String board_file;
	private String board_filename;
	private int board_reply;
	private String board_delete;
	private int board_parent;
	private String board_pic;
	
	
	public String getBoard_pic() {
		return board_pic;
	}
	public void setBoard_pic(String board_pic) {
		this.board_pic = board_pic;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public Date getBoard_reg() {
		return board_reg;
	}
	public void setBoard_reg(Date board_reg) {
		this.board_reg = board_reg;
	}
	public String getBoard_file() {
		return board_file;
	}
	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}
	public String getBoard_filename() {
		return board_filename;
	}
	public void setBoard_filename(String board_filename) {
		this.board_filename = board_filename;
	}
	public int getBoard_reply() {
		return board_reply;
	}
	public void setBoard_reply(int board_reply) {
		this.board_reply = board_reply;
	}
	public String getBoard_delete() {
		return board_delete;
	}
	public void setBoard_delete(String board_delete) {
		this.board_delete = board_delete;
	}
	public int getBoard_parent() {
		return board_parent;
	}
	public void setBoard_parent(int board_parent) {
		this.board_parent = board_parent;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_num=" + board_num + ", std_id=" + std_id
				+ ", board_title=" + board_title + ", board_content="
				+ board_content + ", board_reg=" + board_reg + ", board_file="
				+ board_file + ", board_filename=" + board_filename
				+ ", board_reply=" + board_reply + ", board_delete="
				+ board_delete + ", board_parent=" + board_parent
				+ ", board_pic=" + board_pic + "]";
	}
}
