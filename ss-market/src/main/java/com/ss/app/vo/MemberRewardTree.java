package com.ss.app.vo;

import java.util.ArrayList;
import java.util.List;

public class MemberRewardTree {

	private String id;
	private String sponserId;
	private List<MemberRewardTree> children = new ArrayList<MemberRewardTree>();
	private int level;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<MemberRewardTree> getChildren() {
		return children;
	}

	public void setChildren(List<MemberRewardTree> children) {
		this.children = children;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getSponserId() {
		return sponserId;
	}

	public void setSponserId(String sponserId) {
		this.sponserId = sponserId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MemberRewardTree [id=" + id + ", sponserId=" + sponserId + ", children=" + children + ", level=" + level
				+ ", status=" + status + "]";
	}

	

	

	
	
}
