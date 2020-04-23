package ${packageName};

import com.github.pagehelper.PageInfo;
<#if swagger==true>import io.swagger.annotations.*;</#if>
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @Author:${authorName}
 * @Description:${upperTableName}Controller构建
 * @Date:${date}
 */
<#if swagger==true>@Api(value = "${upperTableName}Controller")</#if>
@RestController
@RequestMapping("/${camelTableName}")
@CrossOrigin
public class ${upperTableName}Controller {

    @Autowired
    private ${upperTableName}Service ${camelTableName}Service;

    /***
     * ${upperTableName}分页条件搜索实现
     * @param ${camelTableName}
     * @param page
     * @param size
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${upperTableName}条件分页查询",notes = "分页条件查询${upperTableName}方法详情",tags = {"${upperTableName}Controller"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    </#if>
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) <#if swagger==true>@ApiParam(name = "${upperTableName}对象",value = "传入JSON数据",required = false)</#if> ${upperTableName} ${camelTableName}, @PathVariable  int page, @PathVariable  int size) {
        //调用${upperTableName}Service实现分页条件查询${upperTableName}
        PageInfo<${upperTableName}> pageInfo = ${camelTableName}Service.findPage(${camelTableName}, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * ${upperTableName}分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${upperTableName}分页查询",notes = "分页查询${upperTableName}方法详情",tags = {"${upperTableName}Controller"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    </#if>
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size) {
        //调用${upperTableName}Service实现分页查询${upperTableName}
        PageInfo<${upperTableName}> pageInfo = ${camelTableName}Service.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索${camelTableName}数据
     * @param ${camelTableName}
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${upperTableName}条件查询",notes = "条件查询${upperTableName}方法详情",tags = {"${upperTableName}Controller"})
    </#if>
    @PostMapping(value = "/search" )
    public Result<List<${upperTableName}>> findList(@RequestBody(required = false) <#if swagger==true>@ApiParam(name = "${upperTableName}对象",value = "传入JSON数据",required = false)</#if> ${upperTableName} ${camelTableName}) {
        //调用${upperTableName}Service实现条件查询${upperTableName}
        List<${upperTableName}> list = ${camelTableName}Service.findList(${camelTableName});
        return new Result<List<${upperTableName}>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除${camelTableName}数据
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${upperTableName}根据ID删除",notes = "根据ID删除${upperTableName}方法详情",tags = {"${upperTableName}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable ${keyType} id) {
        //调用${upperTableName}Service实现根据主键删除
        ${camelTableName}Service.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改${upperTableName}数据
     * @param ${camelTableName}
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${upperTableName}根据ID修改",notes = "根据ID修改${upperTableName}方法详情",tags = {"${upperTableName}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @PutMapping(value="/{id}")
    public Result update(@RequestBody <#if swagger==true>@ApiParam(name = "${upperTableName}对象",value = "传入JSON数据",required = false)</#if> ${upperTableName} ${camelTableName},@PathVariable ${keyType} id) {
        //设置主键值
        ${camelTableName}.${keySetMethod}(id);
        //调用${upperTableName}Service实现修改${upperTableName}
        ${camelTableName}Service.update(${camelTableName});
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增${upperTableName}数据
     * @param ${camelTableName}
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${upperTableName}添加",notes = "添加${upperTableName}方法详情",tags = {"${upperTableName}Controller"})
    </#if>
    @PostMapping
    public Result add(@RequestBody  <#if swagger==true>@ApiParam(name = "${upperTableName}对象",value = "传入JSON数据",required = true)</#if> ${upperTableName} ${camelTableName}) {
        //调用${upperTableName}Service实现添加${upperTableName}
        ${camelTableName}Service.add(${camelTableName});
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询${upperTableName}数据
     * @param id
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "${upperTableName}根据ID查询",notes = "根据ID查询${upperTableName}方法详情",tags = {"${upperTableName}Controller"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "${keyType}")
    </#if>
    @GetMapping("/{id}")
    public Result<${upperTableName}> findById(@PathVariable ${keyType} id) {
        //调用${upperTableName}Service实现根据主键查询${upperTableName}
        ${upperTableName} ${camelTableName} = ${camelTableName}Service.findById(id);
        return new Result<${upperTableName}>(true,StatusCode.OK,"查询成功",${camelTableName});
    }

    /***
     * 查询${upperTableName}全部数据
     * @return
     */
    <#if swagger==true>
    @ApiOperation(value = "查询所有${upperTableName}",notes = "查询所${upperTableName}有方法详情",tags = {"${upperTableName}Controller"})
    </#if>
    @GetMapping
    public Result<List<${upperTableName}>> findAll() {
        //调用${upperTableName}Service实现查询所有${upperTableName}
        List<${upperTableName}> list = ${camelTableName}Service.findAll();
        return new Result<List<${upperTableName}>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
