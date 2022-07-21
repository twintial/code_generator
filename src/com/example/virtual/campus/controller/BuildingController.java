package com.example.virtual.campus.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author:Shen Junjie
 * @Description:BuildingController构建
 * @Date:2022/07/20
 */
@Api(value = "BuildingController")
@RestController
@RequestMapping("/building")
@CrossOrigin
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    /***
     * Building分页条件搜索实现
     * @param building
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "Building条件分页查询",notes = "分页条件查询Building方法详情",tags = {"BuildingController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "Building对象",value = "传入JSON数据",required = false) Building building, @PathVariable  int page, @PathVariable  int size) {
        //调用BuildingService实现分页条件查询Building
        PageInfo<Building> pageInfo = buildingService.findPage(building, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * Building分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "Building分页查询",notes = "分页查询Building方法详情",tags = {"BuildingController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size) {
        //调用BuildingService实现分页查询Building
        PageInfo<Building> pageInfo = buildingService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索building数据
     * @param building
     * @return
     */
    @ApiOperation(value = "Building条件查询",notes = "条件查询Building方法详情",tags = {"BuildingController"})
    @PostMapping(value = "/search" )
    public Result<List<Building>> findList(@RequestBody(required = false) @ApiParam(name = "Building对象",value = "传入JSON数据",required = false) Building building) {
        //调用BuildingService实现条件查询Building
        List<Building> list = buildingService.findList(building);
        return new Result<List<Building>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除building数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Building根据ID删除",notes = "根据ID删除Building方法详情",tags = {"BuildingController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id) {
        //调用BuildingService实现根据主键删除
        buildingService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改Building数据
     * @param building
     * @param id
     * @return
     */
    @ApiOperation(value = "Building根据ID修改",notes = "根据ID修改Building方法详情",tags = {"BuildingController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "Building对象",value = "传入JSON数据",required = false) Building building,@PathVariable Integer id) {
        //设置主键值
        building.setId(id);
        //调用BuildingService实现修改Building
        buildingService.update(building);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Building数据
     * @param building
     * @return
     */
    @ApiOperation(value = "Building添加",notes = "添加Building方法详情",tags = {"BuildingController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "Building对象",value = "传入JSON数据",required = true) Building building) {
        //调用BuildingService实现添加Building
        buildingService.add(building);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Building数据
     * @param id
     * @return
     */
    @ApiOperation(value = "Building根据ID查询",notes = "根据ID查询Building方法详情",tags = {"BuildingController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Integer")
    @GetMapping("/{id}")
    public Result<Building> findById(@PathVariable Integer id) {
        //调用BuildingService实现根据主键查询Building
        Building building = buildingService.findById(id);
        return new Result<Building>(true,StatusCode.OK,"查询成功",building);
    }

    /***
     * 查询Building全部数据
     * @return
     */
    @ApiOperation(value = "查询所有Building",notes = "查询所Building有方法详情",tags = {"BuildingController"})
    @GetMapping
    public Result<List<Building>> findAll() {
        //调用BuildingService实现查询所有Building
        List<Building> list = buildingService.findAll();
        return new Result<List<Building>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
