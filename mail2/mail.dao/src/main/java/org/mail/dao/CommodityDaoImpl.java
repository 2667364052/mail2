package org.mail.dao;

import org.mail.entity.Commodity;
import org.springframework.stereotype.Repository;

/**
 * 商品数据Dao接口实现类
 * @author VIC
 *
 */
@Repository("commodityDao")
public class CommodityDaoImpl extends BaseDaoImpl<Commodity, Integer> implements ICommodityDao {

}
