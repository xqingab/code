package ${package};

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.forten.utils.system.CurrentTimeKeyBuilder;

import java.io.Serializable;

@Entity
@Table(name = "${tableName}")
public class ${className} implements Serializable {
	@Id
	<#list fields as field>
	@Column(name = "${field.columnName}")
	private ${field.dataType} ${field.fieldName};
	</#list>
	
	public ${className}() {
		super();
		this.id = CurrentTimeKeyBuilder.getInstance().nextPK();
	}
	
	<#list fields as field>
	public ${field.dataType} ${field.getMethodName}(){
		return this.${field.fieldName};
	}
	
	public void ${field.setMethodName}(${field.dataType} ${field.fieldName}){
		this.${field.fieldName} = ${field.fieldName};
	}
	
	</#list>
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		${className} other = (${className}) obj;
		if (id != other.id)
			return false;
		return true;
	}
}