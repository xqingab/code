package org.forten.sample.qo;

import java.util.List;

import org.forten.utils.collection.CollectionUtil;
import org.forten.utils.system.PageInfo;

public class RoWithPage<T> {
	private List<T> dataList;
	private PageInfo page;

	public RoWithPage() {
		super();
	}

	public RoWithPage(List<T> dataList, PageInfo page) {
		super();
		this.dataList = dataList;
		this.page = page;
	}

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public PageInfo getPage() {
		return page;
	}

	public void setPage(PageInfo page) {
		this.page = page;
	}

	public boolean isEmptyData() {
		return CollectionUtil.isEmpty(dataList);
	}

	@Override
	public String toString() {
		return "RoWithPage [dataList=" + dataList + ", page=" + page + "]";
	}
}
