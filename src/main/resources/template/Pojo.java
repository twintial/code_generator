package ${packageName};
<#if swagger==true>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
import javax.persistence.*;
import java.io.Serializable;
<#list qualifiedTypeSet as set>
import ${set};
</#list>
/**
 * @Author:${authorName}
 * @Description:${upperTableName}构建
 * @Date:${date}
 */

<#if swagger==true>
@ApiModel(description = "${upperTableName}",value = "${upperTableName}")
</#if>
@Table(name="${originTableName}")
public class ${upperTableName} implements Serializable{

<#list fieldList as field>
	<#if swagger==true>
	@ApiModelProperty(value = "${field.remarks!""}",required = false)
	</#if>
	<#if field.primaryKey==true>
	@Id
	<#if field.autoIncrement=='YES'>
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	</#if>
	</#if>
    @Column(name = "${field.originColumnName}")
	private ${field.simpleType} ${field.camelColumnName};

</#list>


<#list fieldList as field>
	//get方法
	public ${field.simpleType} get${field.upperColumnName}() {
		return ${field.camelColumnName};
	}

	//set方法
	public void set${field.upperColumnName}(${field.simpleType} ${field.camelColumnName}) {
		this.${field.camelColumnName} = ${field.camelColumnName};
	}
</#list>


}
