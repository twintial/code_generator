package com.example.virtual.campus.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/**
 * @Author:Shen Junjie
 * @Description:Building构建
 * @Date:2022/07/20
 */

@ApiModel(description = "Building",value = "Building")
@Table(name="tb_building")
public class Building implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "name")
	private String name;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "floor_num")
	private Integer floorNum;//



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}
	//get方法
	public Integer getFloorNum() {
		return floorNum;
	}

	//set方法
	public void setFloorNum(Integer floorNum) {
		this.floorNum = floorNum;
	}


}
