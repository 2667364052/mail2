/***********************************************************************
 * Module:  Users.java
 * Author:  VIC
 * Purpose: Defines the Class Users
 ***********************************************************************/

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

/** 用户 */
@Entity
@Table(name = "users")
public class User implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	/** 用户ID */
	@Id
	@SequenceGenerator(name = "seq_generator", sequenceName = "USER_SEQ")
	@GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE)
	@Column(name = "userid")
	private Integer USERID;
	/** 用户名 */
	@Column(name = "name")
	private String name;
	/** 用户登录账号 */
	@Column(name = "account")
	private String account;
	/** 用户登录密码 */
	@Column(name = "password")
	private String password;
	/** 用户性别 */
	@Column(name = "sex")
	private String sex;
	/** 用户年龄 */
	@Column(name = "age")
	private Integer age;
	/** 用户头像 */
	@Column(name = "head")
	private String head;
	/** 用户邮箱 */
	@Column(name = "email")
	private String email;
	/** 用户手机 */
	@Column(name = "phone")
	private String phone;
	/** 用户状态 */
	@Column(name = "state")
	private String state;
	/** 注册时间 */
	@Column(name = "createTime")
	private Date createTime;

	public Integer getUSERID() {
		return USERID;
	}

	public void setUSERID(Integer uSERID) {
		USERID = uSERID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

}