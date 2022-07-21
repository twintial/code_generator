package com.example.virtual.campus.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author:Shen Junjie
 * @Description:UserClassroomController构建
 * @Date:2022/07/20
 */
@Api(value = "UserClassroomController")
@RestController
@RequestMapping("/userClassroom")
@CrossOrigin
public class UserClassroomController {

    @Autowired
    private UserClassroomService userClassroomService;

    /***
     * UserClassroom分页条件搜索实现
     * @param userClassroom
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "UserClassroom条件分页查询",notes = "分页条件查询UserClassroom方法详情",tags = {"UserClassroomController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "UserClassroom对象",value = "传入JSON数据",required = false) UserClassroom userClassroom, @PathVariable  int page, @PathVariable  int size) {
        //调用UserClassroomService实现分页条件查询UserClassroom
        PageInfo<UserClassroom> pageInfo = userClassroomService.findPage(userClassroom, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * UserClassroom分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "UserClassroom分页查询",notes = "分页查询UserClassroom方法详情",tags = {"UserClassroomController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size) {
        //调用UserClassroomService实现分页查询UserClassroom
        PageInfo<UserClassroom> pageInfo = userClassroomService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索userClassroom数据
     * @param userClassroom
     * @return
     */
    @ApiOperation(value = "UserClassroom条件查询",notes = "条件查询UserClassroom方法详情",tags = {"UserClassroomController"})
    @PostMapping(value = "/search" )
    public Result<List<UserClassroom>> findList(@RequestBody(required = false) @ApiParam(name = "UserClassroom对象",value = "传入JSON数据",required = false) UserClassroom userClassroom) {
        //调用UserClassroomService实现条件查询UserClassroom
        List<UserClassroom> list = userClassroomService.findList(userClassroom);
        return new Result<List<UserClassroom>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除userClassroom数据
     * @param id
     * @return
     */
    @ApiOperation(value = "UserClassroom根据ID删除",notes = "根据ID删除UserClassroom方法详情",tags = {"UserClassroomController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id) {
        //调用UserClassroomService实现根据主键删除
        userClassroomService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改UserClassroom数据
     * @param userClassroom
     * @param id
     * @return
     */
    @ApiOperation(value = "UserClassroom根据ID修改",notes = "根据ID修改UserClassroom方法详情",tags = {"UserClassroomController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "UserClassroom对象",value = "传入JSON数据",required = false) UserClassroom userClassroom,@PathVariable Integer id) {
        //设置主键值
        userClassroom.setId(id);
        //调用UserClassroomService实现修改UserClassroom
        userClassroomService.update(userClassroom);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增UserClassroom数据
     * @param userClassroom
     * @return
     */
    @ApiOperation(value = "UserClassroom添加",notes = "添加UserClassroom方法详情",tags = {"UserClassroomController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "UserClassroom对象",value = "传入JSON数据",required = true) UserClassroom userClassroom) {
        //调用UserClassroomService实现添加UserClassroom
        userClassroomService.add(userClassroom);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询UserClassroom数据
     * @param id
     * @return
     */
    @ApiOperation(value = "UserClassroom根据ID查询",notes = "根据ID查询UserClassroom方法详情",tags = {"UserClassroomController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<UserClassroom> findById(@PathVariable Integer id) {
        //调用UserClassroomService实现根据主键查询UserClassroom
        UserClassroom userClassroom = userClassroomService.findById(id);
        return new Result<UserClassroom>(true,StatusCode.OK,"查询成功",userClassroom);
    }

    /***
     * 查询UserClassroom全部数据
     * @return
     */
    @ApiOperation(value = "查询所有UserClassroom",notes = "查询所UserClassroom有方法详情",tags = {"UserClassroomController"})
    @GetMapping
    public Result<List<UserClassroom>> findAll() {
        //调用UserClassroomService实现查询所有UserClassroom
        List<UserClassroom> list = userClassroomService.findAll();
        return new Result<List<UserClassroom>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
