package com.example.virtual.campus.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/**
 * @Author:Shen Junjie
 * @Description:Classroom构建
 * @Date:2022/07/20
 */

@ApiModel(description = "Classroom",value = "Classroom")
@Table(name="tb_classroom")
public class Classroom implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "building_id")
	private Integer buildingId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "name")
	private String name;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "floor")
	private Integer floor;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "room_number")
	private String roomNumber;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "capacity")
	private Integer capacity;//



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public Integer getBuildingId() {
		return buildingId;
	}

	//set方法
	public void setBuildingId(Integer buildingId) {
		this.buildingId = buildingId;
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
	public Integer getFloor() {
		return floor;
	}

	//set方法
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	//get方法
	public String getRoomNumber() {
		return roomNumber;
	}

	//set方法
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	//get方法
	public Integer getCapacity() {
		return capacity;
	}

	//set方法
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


}
