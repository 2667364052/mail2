package org.mail.service.commodity;

import org.mail.entity.Commodity;

/**
 * 商品业务接口
 * @author VIC
 *
 */
public interface ICommodityService {
	
	Commodity findCommodityById(Integer cid);

}
