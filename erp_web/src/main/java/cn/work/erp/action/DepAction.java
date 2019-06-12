package cn.work.erp.action;

import cn.work.erp.biz.IDepBiz;
import cn.work.erp.entity.Dep;
/**
 * 部门Action
 * @author MRZHU
 *
 */
public class DepAction extends BaseAction<Dep>{
	
	private IDepBiz depBiz;

	public void setDepBiz(IDepBiz depBiz) {
		this.depBiz = depBiz;
		super.setBaseBiz(this.depBiz);
	}
	
	
	
}
