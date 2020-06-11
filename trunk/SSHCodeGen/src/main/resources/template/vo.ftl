package ${package};

import java.util.Date;

import java.io.Serializable;

public class ${className}Vo {
	<#list fields as field>
	private ${field.dataType} ${field.fieldName};
	</#list>
	
	<#list fields as field>
	public ${field.dataType} ${field.getMethodName}(){
		return this.${field.fieldName};
	}
	
	public void ${field.setMethodName}(${field.dataType} ${field.fieldName}){
		this.${field.fieldName} = ${field.fieldName};
	}
	
	</#list>
}