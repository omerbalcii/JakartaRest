package com.bilgeadam.springrest.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bilgeadam.springrest.model.DersOgrenci;

@Repository
public class DersOgrenciRepository
{
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setJdbcTemplate(@Qualifier(value = "bizimjdbctemplate") JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<DersOgrenci> getAll()
	{
		// Incorrect column count: expected 1, actual 3
		// return jdbcTemplate.queryForList("select * from BILGE.DersOgrenci",
		// DersOgrenci.class);
		// -------------------------

//		RowMapper<DersOgrenci> rowMapper = new RowMapper<DersOgrenci>()
//		{
//			@Override
//			public DersOgrenci mapRow(ResultSet result, int rowNum) throws SQLException
//			{
//				return new DersOgrenci(result.getInt("ID"), result.getString("NAME"), result.getBoolean("IS_GICIK"));
//			}
//		};
//		return jdbcTemplate.query("select * from BILGE.DersOgrenci", rowMapper);

		// -------------------------
		// return jdbcTemplate.query("select * from DersOgrenci", (ResultSet result,
		// int rowNum) -> new DersOgrenci(result.getInt("ID"), result.getInt("DERS_ID"),result.getInt("OGRENCI_ID"),result.getLong("DEVAMSIZLIK"),result.getLong("YEAR")));
		// -------------------------
		return jdbcTemplate.query("select * from \"public\".\"DERS_OGRENCI\" order by \"ID\" asc", BeanPropertyRowMapper.newInstance(DersOgrenci.class));
	}

	public boolean deleteByID(long id)
	{
		String sql = "delete from \"public\".\"DERS_OGRENCI\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	public DersOgrenci getByID(long id)
	{
		DersOgrenci dersOgrenci = null;
		String sql = "select * from \"public\".\"DERS_OGRENCI\" where \"ID\" = :ABUZIDDIN";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ABUZIDDIN", id);
		dersOgrenci = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(DersOgrenci.class));
		// ---------------------------------
		/*
		 * ResultSetExtractor<DersOgrenci> rse = new ResultSetExtractor<DersOgrenci>() {
		 * 
		 * @Override public DersOgrenci extractData(ResultSet result) throws SQLException,
		 * DataAccessException { return new DersOgrenci(result.getInt("ID"),
		 * result.getString("NAME"), result.getBoolean("IS_GICIK")); } };
		 * namedParameterJdbcTemplate.query(sql, paramMap, rse);
		 */
		// ---------------------------------
		// Incorrect column count: expected 1, actual 3
		// namedParameterJdbcTemplate.queryForObject(sql, paramMap, DersOgrenci.class);
		return dersOgrenci;
	}

	public boolean save(DersOgrenci Dogr)
	{
		String sql = "INSERT INTO \"public\".\"DERS_OGRENCI\"(\"DERS_ID\", \"OGRENCI_ID\", \"DEVAMSIZLIK\", \"NOTE\")VALUES  (:DERS_ID, :OGRENCI_ID, :DEVAMSIZLIK, :NOTE)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("DERS_ID", Dogr.getDERS_ID());
		paramMap.put("OGRENCI_ID", Dogr.getOGRENCI_ID());
		paramMap.put("DEVAMSIZLIK", Dogr.getDEVAMSIZLIK());
		paramMap.put("NOTE", Dogr.getNOTE());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	

//	public boolean update(long id, DersOgrenci dogr) throws SQLException
//	{
//	}
}