/*
 * Copyright 2003-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.forten.scss.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 * 
 * 
 * @author <a href="mailto:du_yi@bbn.cn">Duyi</a>
 * @since 2012-12-18
 */
public abstract class BaseAction implements SessionAware, ServletRequestAware,
		ServletResponseAware, ApplicationAware {
	protected Map<String, Object> session;
	protected Map<String, Object> application;
	protected HttpServletRequest request;
	protected HttpServletResponse response;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.ApplicationAware#setApplication(java.util
	 * .Map)
	 */
	@Override
	public void setApplication(Map<String, Object> app) {
		this.application = app;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.ServletResponseAware#setServletResponse
	 * (javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.ServletRequestAware#setServletRequest(
	 * javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
