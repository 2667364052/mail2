/***********************************************************************
 * Module:  Email.java
 * Author:  VIC
 * Purpose: Defines the Class Email
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

/** 系统邮件，注册邮件，订单邮件 */
@Entity
@Table(name = "emails")
public class Email implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "seq_generator", sequenceName = "EMAIL_SEQ")
	@GeneratedValue(generator = "seq_generator", strategy = GenerationType.SEQUENCE)
	@Column(name = "eid")
	private Integer eid;
	@Column(name = "title")
	private String title;
	@Column(name = "content")
	private String content;
	@Column(name = "email")
	private String email;
	@Column(name = "sendTime")
	private Date sendTime;
	@Column(name = "createTime")
	private Date createTime;
	@Column(name = "creator")
	private String creator;
	@Column(name = "sendState")
	private String sendState;
	@Column(name = "state")
	private String state;
	@Column(name = "emailType")
	private String emailType;

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
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

	public String getSendState() {
		return sendState;
	}

	public void setSendState(String sendState) {
		this.sendState = sendState;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmailType() {
		return emailType;
	}

	public void setEmailType(String emailType) {
		this.emailType = emailType;
	}

}