package kr.or.ddit.post.model;

public class PostVo {
	private int postList_num;
	private String postList_use;
	private String postName;
	
	public int getPostList_num() {
		return postList_num;
	}
	public void setPostList_num(int postList_num) {
		this.postList_num = postList_num;
	}
	public String getPostList_use() {
		return postList_use;
	}
	public void setPostList_use(String postList_use) {
		this.postList_use = postList_use;
	}
	public String getPostName() {
		return postName;
	}
	public void setPostName(String postName) {
		this.postName = postName;
	}
	
	@Override
	public String toString() {
		return "PostVo [postList_num=" + postList_num + ", postList_use="
				+ postList_use + ", postName=" + postName + "]";
	}
}
