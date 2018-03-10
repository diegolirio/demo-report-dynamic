package com.example.demoreportdynamic.service;

import static org.mockito.Matchers.contains;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@PropertySource("classpath:/db.sql.properties")
public class JdbcRepository {

	@Autowired
    private JdbcTemplate jdbcTemplate;		

	@Value("${sql.find-all}")
	private String sqlFindAll;
	
	public Iterable<Customer> findByAll() {
		log.debug(sqlFindAll);
		return jdbcTemplate.query(sqlFindAll, 
								  new Object[]{}, 
								  new CustomerToRowMapper()); 
	}

	public List<Map<String, Object>> findObjectAll() {
	    List profilelist=new ArrayList<>();
	    return this.jdbcTemplate.queryForList(sqlFindAll);
	}
	
	private void test(List<Map<String, Object>> results) {
		for (int i = 0; i < results.size(); i++) {
			Map m = (Map) results.get(i);
			Set s = m.keySet();
		    Iterator it=s.iterator();
		    while(it.hasNext()){
		    	
		    }
		    while(it.hasNext()){
		        String its=(String)it.next();
		        Object ob=(Object)m.get(its);
		        log.info(its+": "+ob);
		    }
		}
	}

	private List<String> headers() {
		List<String> headers = new ArrayList<>();
		List<Map<String, Object>> results = this.findObjectAll();
		for (int i = 0; i < results.size(); i++) {
			Map m = (Map) results.get(i);
			Set s = m.keySet();
		    Iterator it=s.iterator();
		    while(it.hasNext()){
		    	String h = (String)it.next();
		    	headers.add(h);
		    }
		    break;
		}
		return headers;
	}

	private List<Object> contents() {
		List<Object> contents = new ArrayList<>();
		List<Map<String, Object>> results = this.findObjectAll();
		for (int i = 0; i < results.size(); i++) {
			Map m = (Map) results.get(i);
			System.out.println(m);
			Set s = m.keySet();
		    Iterator it=s.iterator();
		    while(it.hasNext()){
		    	String h = (String)it.next();
		    	Object ob=(Object)m.get(h);
		    	contents.add(ob);
		    }
		}
		return contents;
	}
	
	public void getAll() {
		List<String> headers = this.headers();
		List<Object> contents = this.contents();
		System.out.println(headers);
		System.out.println(contents);
	}
	
}
