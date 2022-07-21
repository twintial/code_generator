package com.example.virtual.campus.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:Shen Junjie
 * @Description:UserClassroom业务层接口实现类
 * @Date:2022/07/20
 *****/
@Service
public class UserClassroomServiceImpl implements UserClassroomService {

    @Autowired
    private UserClassroomMapper userClassroomMapper;


    /**
     * UserClassroom条件+分页查询
     * @param userClassroom 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UserClassroom> findPage(UserClassroom userClassroom, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(userClassroom);
        //执行搜索
        return new PageInfo<UserClassroom>(userClassroomMapper.selectByExample(example));
    }

    /**
     * UserClassroom分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UserClassroom> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UserClassroom>(userClassroomMapper.selectAll());
    }

    /**
     * UserClassroom条件查询
     * @param userClassroom
     * @return
     */
    @Override
    public List<UserClassroom> findList(UserClassroom userClassroom) {
        //构建查询条件
        Example example = createExample(userClassroom);
        //根据构建的条件查询数据
        return userClassroomMapper.selectByExample(example);
    }


    /**
     * UserClassroom构建查询对象
     * @param userClassroom
     * @return
     */
    public Example createExample(UserClassroom userClassroom) {
        Example example = new Example(UserClassroom.class);
        Example.Criteria criteria = example.createCriteria();
        if(userClassroom != null) {
            // write it yourself
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id) {
        userClassroomMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UserClassroom
     * @param userClassroom
     */
    @Override
    public void update(UserClassroom userClassroom) {
        userClassroomMapper.updateByPrimaryKey(userClassroom);
    }

    /**
     * 增加UserClassroom
     * @param userClassroom
     */
    @Override
    public void add(UserClassroom userClassroom) {
        userClassroomMapper.insert(userClassroom);
    }

    /**
     * 根据ID查询UserClassroom
     * @param id
     * @return
     */
    @Override
    public UserClassroom findById(Integer id) {
        return  userClassroomMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UserClassroom全部数据
     * @return
     */
    @Override
    public List<UserClassroom> findAll() {
        return userClassroomMapper.selectAll();
    }
}
