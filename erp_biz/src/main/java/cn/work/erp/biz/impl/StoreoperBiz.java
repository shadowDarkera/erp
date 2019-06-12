package cn.work.erp.biz.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.work.erp.biz.IStoreoperBiz;
import cn.work.erp.dao.IEmpDao;
import cn.work.erp.dao.IGoodsDao;
import cn.work.erp.dao.IStoreDao;
import cn.work.erp.dao.IStoreoperDao;
import cn.work.erp.entity.Storeoper;
/**
 * 仓库操作记录业务逻辑类
 * @author Administrator
 *
 */
public class StoreoperBiz extends BaseBiz<Storeoper> implements IStoreoperBiz {

	private IStoreoperDao storeoperDao;
	private IEmpDao empDao;
	private IGoodsDao goodsDao;
	private IStoreDao storeDao;
	
	public void setEmpDao(IEmpDao empDao) {
		this.empDao = empDao;
	}

	public void setGoodsDao(IGoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	public void setStoreDao(IStoreDao storeDao) {
		this.storeDao = storeDao;
	}

	public void setStoreoperDao(IStoreoperDao storeoperDao) {
		this.storeoperDao = storeoperDao;
		super.setBaseDao(this.storeoperDao);
	}
	
	public List<Storeoper> getListByPage(Storeoper t1,Storeoper t2,Object param,int firstResult, int maxResults){
		List<Storeoper> logList = super.getListByPage(t1,t2,param,firstResult, maxResults);
		Map<Long, String> empNameMap = new HashMap<Long, String>();
		Map<Long, String> goodsNameMap = new HashMap<Long, String>();
		Map<Long, String> storeNameMap = new HashMap<Long, String>();
		for(Storeoper log : logList){
			log.setEmpName(getEmpName(log.getEmpuuid(),empNameMap, empDao));
			log.setGoodsName(getGoodsName(log.getGoodsuuid(),goodsNameMap,goodsDao));
			log.setStoreName(getStoreName(log.getStoreuuid(),storeNameMap,storeDao));
		}
		return logList;
	}
	
}
