package com.ss.app.vo;

public class MemberStat {

	private Long level = 0L;
	private Long totalCount = 0L;
	private Long activeCount = 0L;
	private Long inActiveCount = 0L;

	public Long getLevel() {
		return level;
	}

	public void setLevel(Long level) {
		this.level = level;
	}

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Long getActiveCount() {
		return activeCount;
	}

	public void setActiveCount(Long activeCount) {
		this.activeCount = activeCount;
	}

	public Long getInActiveCount() {
		return inActiveCount;
	}

	public void setInActiveCount(Long inActiveCount) {
		this.inActiveCount = inActiveCount;
	}

}
