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
 * @Description:UserRelationship业务层接口实现类
 * @Date:2022/07/20
 *****/
@Service
public class UserRelationshipServiceImpl implements UserRelationshipService {

    @Autowired
    private UserRelationshipMapper userRelationshipMapper;


    /**
     * UserRelationship条件+分页查询
     * @param userRelationship 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<UserRelationship> findPage(UserRelationship userRelationship, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(userRelationship);
        //执行搜索
        return new PageInfo<UserRelationship>(userRelationshipMapper.selectByExample(example));
    }

    /**
     * UserRelationship分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<UserRelationship> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<UserRelationship>(userRelationshipMapper.selectAll());
    }

    /**
     * UserRelationship条件查询
     * @param userRelationship
     * @return
     */
    @Override
    public List<UserRelationship> findList(UserRelationship userRelationship) {
        //构建查询条件
        Example example = createExample(userRelationship);
        //根据构建的条件查询数据
        return userRelationshipMapper.selectByExample(example);
    }


    /**
     * UserRelationship构建查询对象
     * @param userRelationship
     * @return
     */
    public Example createExample(UserRelationship userRelationship) {
        Example example = new Example(UserRelationship.class);
        Example.Criteria criteria = example.createCriteria();
        if(userRelationship != null) {
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
        userRelationshipMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改UserRelationship
     * @param userRelationship
     */
    @Override
    public void update(UserRelationship userRelationship) {
        userRelationshipMapper.updateByPrimaryKey(userRelationship);
    }

    /**
     * 增加UserRelationship
     * @param userRelationship
     */
    @Override
    public void add(UserRelationship userRelationship) {
        userRelationshipMapper.insert(userRelationship);
    }

    /**
     * 根据ID查询UserRelationship
     * @param id
     * @return
     */
    @Override
    public UserRelationship findById(Integer id) {
        return  userRelationshipMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询UserRelationship全部数据
     * @return
     */
    @Override
    public List<UserRelationship> findAll() {
        return userRelationshipMapper.selectAll();
    }
}
