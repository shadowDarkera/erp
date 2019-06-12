package cn.work.erp.action;
import com.alibaba.fastjson.JSON;

import cn.work.erp.biz.IEmpBiz;
import cn.work.erp.biz.IMenuBiz;
import cn.work.erp.entity.Menu;

/**
 * 菜单Action 
 * @author Administrator
 *
 */
public class MenuAction extends BaseAction<Menu> {

	private IMenuBiz menuBiz;
	private IEmpBiz empBiz;

	public void setEmpBiz(IEmpBiz empBiz) {
		this.empBiz = empBiz;
	}

	public void setMenuBiz(IMenuBiz menuBiz) {
		this.menuBiz = menuBiz;
		super.setBaseBiz(this.menuBiz);
	}
	
	/**
	 * 获取菜单数据
	 */
	public void getMenuTree(){
		//通过获取主菜单，自关联就会带其下所有的菜单
		Menu menu = empBiz.readMenusByEmpuuid(getLoginUser().getUuid());
		write(JSON.toJSONString(menu));
	}

}
