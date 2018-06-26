package org.mail.service.commodity;

import org.mail.dao.ICommodityDao;
import org.mail.entity.Commodity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品业务类
 * @author VIC
 *
 */
@Service("commodityService")
public class CommodityServiceImpl implements ICommodityService {
	
	@Autowired
	private ICommodityDao commodityDao;

	public Commodity findCommodityById(Integer cid) {
		return commodityDao.selectByProperty("id", cid);
	}

}
