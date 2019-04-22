package ${package.Entity};
<#list table.importPackages as pkg>
import ${pkg};
</#list>
import com.alibaba.fastjson.annotation.JSONField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;
<#if entityLombokModel>
import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
</#if>

/**<#if table.comment??>${"\n"} * <p>
 * ${table.comment}
 * </p>
 * </#if>
 * @author ${author}
 * @since ${date}
 */
@ToString
@Setter
@Getter
@Accessors(chain = true)
<#if table.convert>
@TableName("${table.name}")
</#if>
@ApiModel("<#if table.comment??>${table.comment}</#if>")
<#if superEntityClass??>
public class ${entity} extends ${superEntityClass}<#if activeRecord><${entity}></#if> {
<#elseif activeRecord>
public class ${entity} extends Model<${entity}> {
<#else>
public class ${entity} implements Serializable {
</#if>
<#-- ----------  BEGIN 字段循环遍历  ---------->
<#list table.fields as field>
    <#if field.keyFlag>
        <#assign keyPropertyName="${field.propertyName}"/>
    </#if>

    <#if field.keyFlag>
    <#-- 主键 -->
        <#if field.keyIdentityFlag>
    @TableId(value = "${field.name}", type = IdType.AUTO)
        <#elseif idType??>
    @TableId(value = "${field.name}", type = IdType.${idType})
        <#elseif field.convert>
    @TableId("${field.name}")
        </#if>
    <#-- 普通字段 -->
    <#elseif field.fill??>
    <#-- -----   存在字段填充设置   ----->
        <#if field.convert>
    @TableField(value = "${field.name}", fill = FieldFill.${field.fill})
        <#else>
    @TableField(fill = FieldFill.${field.fill})
        </#if>
    <#elseif field.convert>
    @TableField("${field.name}")
    </#if>
<#-- 乐观锁注解 -->
    <#if versionFieldName?? && versionFieldName == field.name>
    @Version
    </#if>
<#-- 逻辑删除注解 -->
    <#if logicDeleteFieldName?? && logicDeleteFieldName == field.name >
    @TableLogic
    @JSONField(serialize = false)
    </#if>
    @ApiModelProperty(<#if logicDeleteFieldName?? && logicDeleteFieldName == field.name >value = "<#if field.comment??>${field.comment}</#if>", hidden = true<#else >"<#if field.comment??>${field.comment}</#if>"</#if>)
    private ${field.propertyType} ${field.propertyName};
</#list>
<#------------  END 字段循环遍历  ---------->
<#if !entityLombokModel>
    <#list table.fields as field>
        <#if field.propertyType == "boolean">
            <#assign getprefix="is"/>
        <#else>
            <#assign getprefix="get"/>
        </#if>

    public ${field.propertyType} ${getprefix}${field.capitalName}() {
        return ${field.propertyName};
    }

        <#if entityBuilderModel>
    public ${entity} set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
        <#else>
    public void set${field.capitalName}(${field.propertyType} ${field.propertyName}) {
        </#if>
        this.${field.propertyName} = ${field.propertyName};
        <#if entityBuilderModel>
        return this;
        </#if>
    }
    </#list>
</#if>

<#if entityColumnConstant>
    <#list table.fields as field>
    public static final String ${field.name?upper_case} = "${field.name}";

    </#list>
</#if>
<#if activeRecord>
    @Override
    protected Serializable pkVal() {
    <#if keyPropertyName??>
        return this.${keyPropertyName};
    <#else>
        return this.id;
    </#if>
    }

</#if>
}
