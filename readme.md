#model结构
- fieldList->每一列的字段信息
- qualifiedTypeSet->生成的.java文件中需要import的类型的全限定类名
- swagger->是否加入swagger信息，在配置文件中可以修改
- originTableName->与数据库中的表名相同
- upperTableName->除去了tb_，然后首字母大写的表名
- camelTableName->除去了tb_，驼峰表名
- packageName->.java文件所在的包名
- date->生成日期
- authorName->作者名，在配置文件中可以修改
- keyType->主键的简单类型，如Integer
- keyNum->主键数量