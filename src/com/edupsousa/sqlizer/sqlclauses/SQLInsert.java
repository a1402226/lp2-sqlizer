package com.edupsousa.sqlizer.sqlclauses;
import java.util.Date;

import com.edupsousa.sqlizer.util.IncompleteQueryException;
import com.edupsousa.sqlizer.util.QuerySetter;
import com.edupsousa.sqlizer.util.QuerySetterFieldValuesSql;


public class SQLInsert {

	private String into;
	private QuerySetter querySet = new QuerySetter();
	
	public SQLInsert into(String table) {
		this.into = table;
		
		return this;
	}

	public SQLInsert set(String field, String value) {
		querySet.set(field, value);
		return this;
	}
	
	public SQLInsert set(String field, int value) {
		querySet.set(field, value);
		return this;
	}
	
	public SQLInsert set(String field, double value) {
		querySet.set(field, value);
		return this;
	}
	
	public SQLInsert set(String field, Date value) {
		querySet.set(field, value);
		return this;
	}
	
	@Override
	public String toString() {
		if (into == null || querySet.size() == 0)
			throw new IncompleteQueryException("A consulta SQLInsert deve especificar a tabela de destino e ao menos 1 campo");
		
		querySet.setSqlMethod(new QuerySetterFieldValuesSql());
		String sql = "INSERT INTO " + into + " " + querySet.getSql(); 
		
		return sql + ";";
	}

}
