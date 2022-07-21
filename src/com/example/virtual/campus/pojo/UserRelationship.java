package com.example.virtual.campus.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.Integer;
/**
 * @Author:Shen Junjie
 * @Description:UserRelationship构建
 * @Date:2022/07/20
 */

@ApiModel(description = "UserRelationship",value = "UserRelationship")
@Table(name="tb_user_relationship")
public class UserRelationship implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_id")
	private Integer userId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "follow_id")
	private Integer followId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "create_time")
	private Date createTime;//



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public Integer getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	//get方法
	public Integer getFollowId() {
		return followId;
	}

	//set方法
	public void setFollowId(Integer followId) {
		this.followId = followId;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


}
