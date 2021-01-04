package com.ss.app.vo;

import java.util.ArrayList;
import java.util.List;

public class MemberTree {
	
	private String id;
	private String parent;
	private String text;
	
	private List<MemberTree> children = new ArrayList<MemberTree>();

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

	public List<MemberTree> getChildren() {
		return children;
	}

	public void setChildren(List<MemberTree> children) {
		this.children = children;
	}
	
	

}
