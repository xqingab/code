package org.forten.sample.ro;

import java.util.List;

import org.forten.sample.vo.NotebookVoForAdmin;
import org.forten.utils.collection.CollectionUtil;
import org.forten.utils.system.PageInfo;

public class NotebookRoWithPage {
	private List<NotebookVoForAdmin> data;
	private PageInfo page;

	public NotebookRoWithPage(List<NotebookVoForAdmin> data, PageInfo page) {
		super();
		this.data = data;
		this.page = page;
	}

	public List<NotebookVoForAdmin> getData() {
		return data;
	}

	public PageInfo getPage() {
		return page;
	}

	public boolean isEmptyData() {
		return CollectionUtil.isEmpty(data);
	}
}
