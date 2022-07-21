package com.example.virtual.campus.service;

import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:Shen Junjie
 * @Description:Classroom业务层接口
 * @Date:2022/07/20
 *****/
public interface ClassroomService {

    /***
     * Classroom多条件分页查询
     * @param classroom
     * @param page
     * @param size
     * @return
     */
    PageInfo<Classroom> findPage(Classroom classroom, int page, int size);

    /***
     * Classroom分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<Classroom> findPage(int page, int size);

    /***
     * Classroom多条件搜索方法
     * @param classroom
     * @return
     */
    List<Classroom> findList(Classroom classroom);

    /***
     * 删除Classroom
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改Classroom数据
     * @param classroom
     */
    void update(Classroom classroom);

    /***
     * 新增Classroom
     * @param classroom
     */
    void add(Classroom classroom);

    /**
     * 根据ID查询Classroom
     * @param id
     * @return
     */
     Classroom findById(Integer id);

    /***
     * 查询所有Classroom
     * @return
     */
    List<Classroom> findAll();
}
