package ${packageName};

import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author: ${authorName}
 * @Description: ${upperTableName}业务层接口
 * @Date: ${date}
 *****/
public interface ${upperTableName}Service {

    /***
     * ${upperTableName}多条件分页查询
     * @param ${camelTableName}
     * @param page
     * @param size
     * @return
     */
    PageInfo<${upperTableName}> findPage(${upperTableName} ${camelTableName}, int page, int size);

    /***
     * ${upperTableName}分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<${upperTableName}> findPage(int page, int size);

    /***
     * ${upperTableName}多条件搜索方法
     * @param ${camelTableName}
     * @return
     */
    List<${upperTableName}> findList(${upperTableName} ${camelTableName});

    /***
     * 删除${upperTableName}
     * @param id
     */
    Integer delete(${keyType} id);

    /***
     * 修改${upperTableName}数据
     * @param ${camelTableName}
     */
    Integer update(${upperTableName} ${camelTableName});

    /***
     * 新增${upperTableName}
     * @param ${camelTableName}
     */
    Integer insert(${upperTableName} ${camelTableName});

    /**
     * 根据ID查询${upperTableName}
     * @param id
     * @return
     */
    ${upperTableName} findById(${keyType} id);

    /***
     * 查询所有${upperTableName}
     * @return
     */
    List<${upperTableName}> findAll();
}
