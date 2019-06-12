package cn.work.erp.biz.impl;

import java.util.List;

import cn.work.erp.biz.IDepBiz;
import cn.work.erp.dao.IDepDao;
import cn.work.erp.entity.Dep;
/**
 * 部门业务实现
 * @author MRZHU
 *
 */
public class DepBiz extends BaseBiz<Dep> implements IDepBiz{
	
	private IDepDao depDao;
	
	public void setDepDao(IDepDao depDao) {
		this.depDao = depDao;
		super.setBaseDao(this.depDao);
	}

}
