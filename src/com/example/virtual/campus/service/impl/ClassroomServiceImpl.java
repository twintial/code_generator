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
 * @Description:Classroom业务层接口实现类
 * @Date:2022/07/20
 *****/
@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomMapper classroomMapper;


    /**
     * Classroom条件+分页查询
     * @param classroom 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<Classroom> findPage(Classroom classroom, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(classroom);
        //执行搜索
        return new PageInfo<Classroom>(classroomMapper.selectByExample(example));
    }

    /**
     * Classroom分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<Classroom> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<Classroom>(classroomMapper.selectAll());
    }

    /**
     * Classroom条件查询
     * @param classroom
     * @return
     */
    @Override
    public List<Classroom> findList(Classroom classroom) {
        //构建查询条件
        Example example = createExample(classroom);
        //根据构建的条件查询数据
        return classroomMapper.selectByExample(example);
    }


    /**
     * Classroom构建查询对象
     * @param classroom
     * @return
     */
    public Example createExample(Classroom classroom) {
        Example example = new Example(Classroom.class);
        Example.Criteria criteria = example.createCriteria();
        if(classroom != null) {
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
        classroomMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改Classroom
     * @param classroom
     */
    @Override
    public void update(Classroom classroom) {
        classroomMapper.updateByPrimaryKey(classroom);
    }

    /**
     * 增加Classroom
     * @param classroom
     */
    @Override
    public void add(Classroom classroom) {
        classroomMapper.insert(classroom);
    }

    /**
     * 根据ID查询Classroom
     * @param id
     * @return
     */
    @Override
    public Classroom findById(Integer id) {
        return  classroomMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询Classroom全部数据
     * @return
     */
    @Override
    public List<Classroom> findAll() {
        return classroomMapper.selectAll();
    }
}
