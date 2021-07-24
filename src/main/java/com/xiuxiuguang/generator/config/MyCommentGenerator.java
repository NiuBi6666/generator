package com.xiuxiuguang.generator.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/*******************************************************************************
 *   @Author lixiuguang
 * - File Name: MyCommentGenerator
 * - Description:
 * - History:
 * Date         Author          Modification
 * 2021/7/22     lixiuguang    Create the current class
 *******************************************************************************/
public class MyCommentGenerator extends DefaultCommentGenerator {

    private Properties properties;
    private Properties systemPro;
    private boolean suppressDate;
    private boolean suppressAllComments;
    private String currentDateStr;
    private TopLevelClass topLevelClass;

    public MyCommentGenerator() {
        super();
        properties = new Properties();
        systemPro = System.getProperties();
        suppressDate = false;
        suppressAllComments = false;
        currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append(" * ");
        sb.append(introspectedColumn.getRemarks());
        sb.append("\n");
        sb.append("     * ");
        sb.append("列名:" + introspectedColumn.getActualColumnName());
        //+ " 类型:" + introspectedColumn.getJdbcTypeName()
        //+ "(" + introspectedColumn.getLength() + ")" + " 允许空:" + introspectedColumn.isNullable() + " 缺省值:"
        //+ introspectedColumn.getDefaultValue());
        field.addJavaDocLine(sb.toString());
        field.addJavaDocLine(" */");
        //field.addAnnotation("@Size(min = 0, max = " + introspectedColumn.getLength() + " , message = 长度必须在{min}和{max}之间\")");
        //String message = (null == introspectedColumn.getRemarks() || "".equals(introspectedColumn.getRemarks())) ? introspectedColumn.getActualColumnName() : introspectedColumn.getRemarks();
        //if (!introspectedColumn.isNullable()) {
        //    if (message.equals("id") || message.equals("ID")) {
        //        return;
        //    }
        //    if (introspectedColumn.getJdbcTypeName().contains("VARCHAR") || introspectedColumn.getJdbcTypeName().contains("CHAR")) {
        //        field.addAnnotation("@NotBlank(message = " + message + "不能为空)");
        //        this.topLevelClass.addImportedType("javax.validation.constraints.NotBlank;");
        //    } else {
        //        field.addAnnotation("@NotNull(message = " + message + "不能为空)");
        //        this.topLevelClass.addImportedType("javax.validation.constraints.NotNull");
        //    }
        //}
        //List<IntrospectedColumn> primaryKeyColumns = introspectedTable.getPrimaryKeyColumns();
        //for (IntrospectedColumn col : primaryKeyColumns) {
        //    if (col.getActualColumnName().equals(introspectedColumn.getActualColumnName())) {
        //        field.addAnnotation("@Id");
        //    }
        //}
        //field.addAnnotation("@Column(name = \"" + introspectedColumn.getActualColumnName() + "\")");
    }

    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {

    }

    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/**");
        sb.append("\n");
        sb.append("	* ");
        sb.append("\n");
        sb.append("	* @author " + systemPro.getProperty("user.name") + "\n");
        //if (!suppressDate) {
        //
        //    sb.append("	* @date " + currentDateStr + "\n");
        //
        //}
        List<Parameter> parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            sb.append("	* @param " + parameter.getName() + "\n");
        }
        sb.append("	* @return " + method.getReturnType());
        sb.append("\n" + "	*/");
        method.addJavaDocLine(sb.toString());
    }

    public void addGetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

    }

    public void addSetterComment(Method method, IntrospectedTable introspectedTable,
                                 IntrospectedColumn introspectedColumn) {

    }

    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean markAsDoNotDelete) {

        super.addClassComment(innerClass, introspectedTable, markAsDoNotDelete);
    }

    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {

    }

    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        this.topLevelClass = topLevelClass;
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/**");
        sb.append("\n");
        sb.append("* ");
        sb.append("\n");
        sb.append("* @author " + systemPro.getProperty("user.name") + "\n");
        //if (!suppressDate) {
        //
        //    sb.append("* @date " + currentDateStr + "\n");
        //
        //}
        sb.append("* 数据表：" + introspectedTable.getFullyQualifiedTableNameAtRuntime());
        sb.append("\n" + "*/");
        topLevelClass.addJavaDocLine(sb.toString());
        //topLevelClass.addImportedType("javax.validation.constraints.Size");
        //topLevelClass.addImportedType("javax.validation.constraints.NotBlank;");
        //topLevelClass.addImportedType("javax.validation.constraints.NotNull");
    }

}