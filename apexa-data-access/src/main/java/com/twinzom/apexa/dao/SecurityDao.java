package com.twinzom.apexa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.twinzom.apexa.dao.po.SecurityPo;
import com.twinzom.apexa.dao.rowmapper.SecurityRowmapper;

@Component
public class SecurityDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static final String GET_SEC_BY_SECIDS = "select * from sec_mast where secid in ( :secids )";

	
	public List<SecurityPo> getSecsBySecids (List<Long> secids) {

		NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());

		if (secids == null || secids.size() <= 0) 
			return null;
		
		SqlParameterSource namedParameters = new MapSqlParameterSource("secids", secids);
		
		List<SecurityPo> secs = namedParameterJdbcTemplate.query(GET_SEC_BY_SECIDS,
				namedParameters,
				new SecurityRowmapper());
		
		return secs;
	}
	
	
}
