package org.forten.sample.ro;

import java.util.List;

import org.forten.sample.vo.HouseVo;
import org.forten.utils.collection.CollectionUtil;
import org.forten.utils.system.PageInfo;

public class HouseRo {
	private List<HouseVo> dataList;
	private PageInfo page;

	public HouseRo() {
		super();
	}

	public HouseRo(List<HouseVo> dataList, PageInfo page) {
		super();
		this.dataList = dataList;
		this.page = page;
	}

	public List<HouseVo> getDataList() {
		return dataList;
	}

	public void setDataList(List<HouseVo> dataList) {
		this.dataList = dataList;
	}

	public PageInfo getPage() {
		return page;
	}

	public void setPage(PageInfo page) {
		this.page = page;
	}
	
	public boolean isEmptyData(){
		return CollectionUtil.isEmpty(dataList);
	}

	@Override
	public String toString() {
		return "HouseRo [dataList=" + dataList + ", page=" + page + "]";
	}
}
