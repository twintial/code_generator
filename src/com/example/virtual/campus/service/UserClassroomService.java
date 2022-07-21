package com.example.virtual.campus.service;

import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:Shen Junjie
 * @Description:UserClassroom业务层接口
 * @Date:2022/07/20
 *****/
public interface UserClassroomService {

    /***
     * UserClassroom多条件分页查询
     * @param userClassroom
     * @param page
     * @param size
     * @return
     */
    PageInfo<UserClassroom> findPage(UserClassroom userClassroom, int page, int size);

    /***
     * UserClassroom分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<UserClassroom> findPage(int page, int size);

    /***
     * UserClassroom多条件搜索方法
     * @param userClassroom
     * @return
     */
    List<UserClassroom> findList(UserClassroom userClassroom);

    /***
     * 删除UserClassroom
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改UserClassroom数据
     * @param userClassroom
     */
    void update(UserClassroom userClassroom);

    /***
     * 新增UserClassroom
     * @param userClassroom
     */
    void add(UserClassroom userClassroom);

    /**
     * 根据ID查询UserClassroom
     * @param id
     * @return
     */
     UserClassroom findById(Integer id);

    /***
     * 查询所有UserClassroom
     * @return
     */
    List<UserClassroom> findAll();
}
