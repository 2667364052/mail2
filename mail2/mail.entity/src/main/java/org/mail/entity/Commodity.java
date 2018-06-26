package org.mail.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 商品
 * 
 * @author VIC
 *
 */
@Entity
@Table(name = "commonditys")
public class Commodity implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;
	/** 商品ID */
	@Id
	@SequenceGenerator(name = "seq_generator", sequenceName = "COMMONDITY_SEQ")
	@GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE)
	@Column(name = "cid")
	private Integer cid;
	/** 商品名称 */
	@Column(name = "name")
	private String name;
	/** 商品地址 */
	@Column(name = "url")
	private String url;
	/** 商品描述 */
	@Column(name = "describe")
	private String describe;
	/** 商品关键字 */
	@Column(name = "keywords")
	private String keywords;
	/** 商品价格 */
	@Column(name = "price")
	private String price;
	/** 商品图片: 图片存储的相对路径或绝对路径 */
	@Column(name = "pic")
	private String pic;
	/** 商品状态: 新建/上架/下架/删除 */
	@Column(name = "state")
	private String state;
	/** 创建时间(当前系统时间) */
	@Column(name = "createTime")
	private Date createTime;
	/** 创建人(管理员账号) */
	@Column(name = "creator")
	private String creator;
	/** 更新时间(当前系统时间) */
	@Column(name = "updateTime")
	private Date updateTime;
	/** 更新人(管理员账号) */
	@Column(name = "updateAreator")
	private String updateAreator;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateAreator() {
		return updateAreator;
	}

	public void setUpdateAreator(String updateAreator) {
		this.updateAreator = updateAreator;
	}

}