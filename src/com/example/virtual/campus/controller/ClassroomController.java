package com.example.virtual.campus.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author:Shen Junjie
 * @Description:ClassroomController构建
 * @Date:2022/07/20
 */
@Api(value = "ClassroomController")
@RestController
@RequestMapping("/classroom")
@CrossOrigin
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    /***
     * Classroom分页条件搜索实现
     * @param classroom
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Classroom条件分页查询",notes = "分页条件查询Classroom方法详情",tags = {"ClassroomController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Classroom对象",value = "传入JSON数据",required = false) Classroom classroom, @PathVariable  int page, @PathVariable  int size) {
        //调用ClassroomService实现分页条件查询Classroom
        PageInfo<Classroom> pageInfo = classroomService.findPage(classroom, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Classroom分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Classroom分页查询",notes = "分页查询Classroom方法详情",tags = {"ClassroomController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size) {
        //调用ClassroomService实现分页查询Classroom
        PageInfo<Classroom> pageInfo = classroomService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索classroom数据
     * @param classroom
     * @return
     */
    @ApiOperation(value = "Classroom条件查询",notes = "条件查询Classroom方法详情",tags = {"ClassroomController"})
    @PostMapping(value = "/search" )
    public Result<List<Classroom>> findList(@RequestBody(required = false) @ApiParam(name = "Classroom对象",value = "传入JSON数据",required = false) Classroom classroom) {
        //调用ClassroomService实现条件查询Classroom
        List<Classroom> list = classroomService.findList(classroom);
        return new Result<List<Classroom>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除classroom数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Classroom根据ID删除",notes = "根据ID删除Classroom方法详情",tags = {"ClassroomController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id) {
        //调用ClassroomService实现根据主键删除
        classroomService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Classroom数据
     * @param classroom
     * @param id
     * @return
     */
    @ApiOperation(value = "Classroom根据ID修改",notes = "根据ID修改Classroom方法详情",tags = {"ClassroomController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Classroom对象",value = "传入JSON数据",required = false) Classroom classroom,@PathVariable Integer id) {
        //设置主键值
        classroom.setId(id);
        //调用ClassroomService实现修改Classroom
        classroomService.update(classroom);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Classroom数据
     * @param classroom
     * @return
     */
    @ApiOperation(value = "Classroom添加",notes = "添加Classroom方法详情",tags = {"ClassroomController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Classroom对象",value = "传入JSON数据",required = true) Classroom classroom) {
        //调用ClassroomService实现添加Classroom
        classroomService.add(classroom);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Classroom数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Classroom根据ID查询",notes = "根据ID查询Classroom方法详情",tags = {"ClassroomController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Classroom> findById(@PathVariable Integer id) {
        //调用ClassroomService实现根据主键查询Classroom
        Classroom classroom = classroomService.findById(id);
        return new Result<Classroom>(true,StatusCode.OK,"查询成功",classroom);
    }

    /***
     * 查询Classroom全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Classroom",notes = "查询所Classroom有方法详情",tags = {"ClassroomController"})
    @GetMapping
    public Result<List<Classroom>> findAll() {
        //调用ClassroomService实现查询所有Classroom
        List<Classroom> list = classroomService.findAll();
        return new Result<List<Classroom>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
