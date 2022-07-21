package com.example.virtual.campus.service;

import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:Shen Junjie
 * @Description:Building业务层接口
 * @Date:2022/07/20
 *****/
public interface BuildingService {

    /***
     * Building多条件分页查询
     * @param building
     * @param page
     * @param size
     * @return
     */
    PageInfo<Building> findPage(Building building, int page, int size);

    /***
     * Building分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Building> findPage(int page, int size);

    /***
     * Building多条件搜索方法
     * @param building
     * @return
     */
    List<Building> findList(Building building);

    /***
     * 删除Building
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Building数据
     * @param building
     */
    void update(Building building);

    /***
     * 新增Building
     * @param building
     */
    void add(Building building);

    /**
     * 根据ID查询Building
     * @param id
     * @return
     */
     Building findById(Integer id);

    /***
     * 查询所有Building
     * @return
     */
    List<Building> findAll();
}
