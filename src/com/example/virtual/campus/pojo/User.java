package com.example.virtual.campus.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/**
 * @Author:Shen Junjie
 * @Description:User构建
 * @Date:2022/07/20
 */

@ApiModel(description = "User",value = "User")
@Table(name="tb_user")
public class User implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "用户名/昵称",required = false)
    @Column(name = "nickname")
	private String nickname;//

	@ApiModelProperty(value = "密码",required = false)
    @Column(name = "password")
	private String password;//

	@ApiModelProperty(value = "邮箱",required = false)
    @Column(name = "email")
	private String email;//

	@ApiModelProperty(value = "电话号码",required = false)
    @Column(name = "phone")
	private String phone;//

	@ApiModelProperty(value = "学校",required = false)
    @Column(name = "university")
	private String university;//

	@ApiModelProperty(value = "学院",required = false)
    @Column(name = "faculty")
	private String faculty;//

	@ApiModelProperty(value = "专业",required = false)
    @Column(name = "major")
	private String major;//

	@ApiModelProperty(value = "头像url",required = false)
    @Column(name = "avator")
	private String avator;//

	@ApiModelProperty(value = "介绍",required = false)
    @Column(name = "description")
	private String description;//

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//

	@ApiModelProperty(value = "修改时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getNickname() {
		return nickname;
	}

	//set方法
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	//get方法
	public String getPassword() {
		return password;
	}

	//set方法
	public void setPassword(String password) {
		this.password = password;
	}
	//get方法
	public String getEmail() {
		return email;
	}

	//set方法
	public void setEmail(String email) {
		this.email = email;
	}
	//get方法
	public String getPhone() {
		return phone;
	}

	//set方法
	public void setPhone(String phone) {
		this.phone = phone;
	}
	//get方法
	public String getUniversity() {
		return university;
	}

	//set方法
	public void setUniversity(String university) {
		this.university = university;
	}
	//get方法
	public String getFaculty() {
		return faculty;
	}

	//set方法
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	//get方法
	public String getMajor() {
		return major;
	}

	//set方法
	public void setMajor(String major) {
		this.major = major;
	}
	//get方法
	public String getAvator() {
		return avator;
	}

	//set方法
	public void setAvator(String avator) {
		this.avator = avator;
	}
	//get方法
	public String getDescription() {
		return description;
	}

	//set方法
	public void setDescription(String description) {
		this.description = description;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}


}
