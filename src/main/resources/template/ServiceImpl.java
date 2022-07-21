package ${packageName};

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:${authorName}
 * @Description:${upperTableName}业务层接口实现类
 * @Date:${date}
 *****/
@Service
public class ${upperTableName}ServiceImpl implements ${upperTableName}Service {

    @Autowired
    private ${upperTableName}Mapper ${camelTableName}Mapper;


    /**
     * ${upperTableName}条件+分页查询
     * @param ${camelTableName} 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<${upperTableName}> findPage(${upperTableName} ${camelTableName}, int page, int size) {
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(${camelTableName});
        //执行搜索
        return new PageInfo<${upperTableName}>(${camelTableName}Mapper.selectByExample(example));
    }

    /**
     * ${upperTableName}分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<${upperTableName}> findPage(int page, int size) {
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<${upperTableName}>(${camelTableName}Mapper.selectAll());
    }

    /**
     * ${upperTableName}条件查询
     * @param ${camelTableName}
     * @return
     */
    @Override
    public List<${upperTableName}> findList(${upperTableName} ${camelTableName}) {
        //构建查询条件
        Example example = createExample(${camelTableName});
        //根据构建的条件查询数据
        return ${camelTableName}Mapper.selectByExample(example);
    }


    /**
     * ${upperTableName}构建查询对象
     * @param ${camelTableName}
     * @return
     */
    public Example createExample(${upperTableName} ${camelTableName}) {
        Example example = new Example(${upperTableName}.class);
        Example.Criteria criteria = example.createCriteria();
        if(${camelTableName} != null) {
            // write it yourself
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public Integer delete(${keyType} id) {
        return ${camelTableName}Mapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改${upperTableName}
     * @param ${camelTableName}
     */
    @Override
    public Integer update(${upperTableName} ${camelTableName}) {
        return ${camelTableName}Mapper.updateByPrimaryKey(${camelTableName});
    }

    /**
     * 增加${upperTableName}
     * @param ${camelTableName}
     */
    @Override
    public Integer insert(${upperTableName} ${camelTableName}) {
        return ${camelTableName}Mapper.insert(${camelTableName});
    }

    /**
     * 根据ID查询${upperTableName}
     * @param id
     * @return
     */
    @Override
    public ${upperTableName} findById(${keyType} id) {
        return  ${camelTableName}Mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询${upperTableName}全部数据
     * @return
     */
    @Override
    public List<${upperTableName}> findAll() {
        return ${camelTableName}Mapper.selectAll();
    }
}
