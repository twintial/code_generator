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
 * @Description:Building业务层接口实现类
 * @Date:2022/07/20
 *****/
@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingMapper buildingMapper;


    /**
     * Building条件+分页查询
     * @param building 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Building> findPage(Building building, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(building);
        //执行搜索
        return new PageInfo<Building>(buildingMapper.selectByExample(example));
    }

    /**
     * Building分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Building> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Building>(buildingMapper.selectAll());
    }

    /**
     * Building条件查询
     * @param building
     * @return
     */
    @Override
    public List<Building> findList(Building building) {
        //构建查询条件
        Example example = createExample(building);
        //根据构建的条件查询数据
        return buildingMapper.selectByExample(example);
    }


    /**
     * Building构建查询对象
     * @param building
     * @return
     */
    public Example createExample(Building building) {
        Example example = new Example(Building.class);
        Example.Criteria criteria = example.createCriteria();
        if(building != null) {
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
        buildingMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Building
     * @param building
     */
    @Override
    public void update(Building building) {
        buildingMapper.updateByPrimaryKey(building);
    }

    /**
     * 增加Building
     * @param building
     */
    @Override
    public void add(Building building) {
        buildingMapper.insert(building);
    }

    /**
     * 根据ID查询Building
     * @param id
     * @return
     */
    @Override
    public Building findById(Integer id) {
        return  buildingMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Building全部数据
     * @return
     */
    @Override
    public List<Building> findAll() {
        return buildingMapper.selectAll();
    }
}
