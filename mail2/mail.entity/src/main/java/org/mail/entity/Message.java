/***********************************************************************
 * Module:  Message.java
 * Author:  VIC
 * Purpose: Defines the Class Message
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

/** 注册短信，订单短信，支付短信，验证码短信 */
@Entity
@Table(name = "messages")
public class Message implements Serializable {
	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "seq_generator", sequenceName = "MESSAGE_SEQ")
	@GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE)
	@Column(name = "mid")
	private Integer mid;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "phone")
	private String phone;
	@Column(name = "sendTime")
	private Date sendTime;
	@Column(name = "sendState")
	private String sendState;
	@Column(name = "messageType")
	private String messageType;
	@Column(name = "createTime")
	private Date createTime;
	@Column(name = "creator")
	private String creator;
	@Column(name = "state")
	private String state;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getSendState() {
		return sendState;
	}

	public void setSendState(String sendState) {
		this.sendState = sendState;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}