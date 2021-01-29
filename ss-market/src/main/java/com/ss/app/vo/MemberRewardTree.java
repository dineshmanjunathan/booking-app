package com.ss.app.vo;

import java.util.ArrayList;
import java.util.List;

public class MemberRewardTree {

	private String id;
	private String parentId;
	private String sponserId;
	private String text;
	
	private List<MemberRewardTree> children = new ArrayList<MemberRewardTree>();
	
	private int level;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	@Override
	public String toString() {
		return "MemberRewardTree [MemberId=" + id + ", parent=" + parentId + ", level=" + level + "]";
	}

	
	
}
