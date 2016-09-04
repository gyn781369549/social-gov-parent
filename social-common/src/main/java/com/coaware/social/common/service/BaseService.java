/**
 * 
 */
package com.coaware.social.common.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service基类
 * @author Administrator
 * @version 2015-09-16
 */
@Transactional(readOnly = true)
public abstract class BaseService {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	 

}
