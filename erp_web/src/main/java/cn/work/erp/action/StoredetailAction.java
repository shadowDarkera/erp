package cn.work.erp.action;
import java.util.List;

import com.alibaba.fastjson.JSON;

import cn.work.erp.biz.IStoredetailBiz;
import cn.work.erp.entity.Storealert;
import cn.work.erp.entity.Storedetail;
import cn.work.erp.exception.ErpException;

/**
 * 仓库库存Action 
 * @author Administrator
 *
 */
public class StoredetailAction extends BaseAction<Storedetail> {

	private IStoredetailBiz storedetailBiz;

	public void setStoredetailBiz(IStoredetailBiz storedetailBiz) {
		this.storedetailBiz = storedetailBiz;
		super.setBaseBiz(this.storedetailBiz);
	}
	
	/**
	 * 查询库存预警报表
	 */
	public void storealertList(){
		List<Storealert> storealertList = storedetailBiz.getStorealertList();
		write(JSON.toJSONString(storealertList));
	}
	
	/**
	 * 发送库存预警邮件
	 */
	public void sendStorealerMail(){
		try {
			storedetailBiz.sendStorealertMail();
			ajaxReturn(true, "发送邮件成功");
		} catch (ErpException e){
			ajaxReturn(false, e.getMessage());
		} catch (Exception e) {
			ajaxReturn(false, "发送邮件失败");
			e.printStackTrace();
		}
	}

}
