package org.mail.common;

/**
 * 购物车商品类
 * @author VIC
 *
 */
public class ShopCartCommodity {
	
	private Integer id;// 商品ID
	private String name;// 商品名称
	private float price;// 商品单价
	private Integer count;// 商品数量
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ShopCartCommodity [id=" + id + ", name=" + name + ", price=" + price + ", count=" + count + "]";
	}

}
