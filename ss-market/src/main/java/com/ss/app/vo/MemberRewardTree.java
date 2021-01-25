package com.ss.app.vo;

import java.util.ArrayList;
import java.util.List;

public class MemberRewardTree {
	
	private String id;
	private String parent;
	private String text;
	private String level = "L";
	private List<MemberRewardTree> child = new ArrayList<>();
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	public List<MemberRewardTree> getChild() {
		return child;
	}

	public void setChild(List<MemberRewardTree> child) {
		this.child = child;
	}

	@Override
	public String toString() {
		return "MemberRewardTree [id=" + id + ", parent=" + parent + ", text=" + text + ", level=" + level + ", child="
				+ child + "]";
	}

	


}
