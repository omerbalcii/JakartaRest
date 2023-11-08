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

import com.bilgeadam.springrest.model.Ders;

@Repository
public class DersRepository
{
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setJdbcTemplate(@Qualifier(value = "bizimjdbctemplate") JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public List<Ders> getAll()
	{
		// Incorrect column count: expected 1, actual 3
		// return jdbcTemplate.queryForList("select * from BILGE.Ders",
		// Ders.class);
		// -------------------------

//		RowMapper<Ders> rowMapper = new RowMapper<Ders>()
//		{
//			@Override
//			public Ders mapRow(ResultSet result, int rowNum) throws SQLException
//			{
//				return new Ders(result.getInt("ID"), result.getString("NAME"), result.getBoolean("IS_GICIK"));
//			}
//		};
//		return jdbcTemplate.query("select * from DERS", rowMapper);

		// -------------------------
		// return jdbcTemplate.query("select * from Ders", (ResultSet result,
		// int rowNum) -> new DERS(result.getInt("ID"), result.getInt("OGRETMEN_ID"),result.getInt("KONU_ID)));
		// -------------------------
		return jdbcTemplate.query("select * from \"public\".\"DERS\" order by \"ID\" asc", BeanPropertyRowMapper.newInstance(Ders.class));
	}

	public boolean deleteByID(long id)
	{
		String sql = "delete from \"public\".\"DERS\" where \"ID\" = :ID";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ID", id);
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

	public Ders getByID(long id)
	{
		Ders ders = null;
		String sql = "select * from \"public\".\"DERS\" where \"ID\" = :ABUZIDDIN";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ABUZIDDIN", id);
		ders = namedParameterJdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Ders.class));
		// ---------------------------------
		/*
		 * ResultSetExtractor<Ders> ders = new ResultSetExtractor<Ders>() {
		 * 
		 * @Override public Ders extractData(ResultSet result) throws SQLException,
		 * DataAccessException { return new Ders(result.getInt("ID"),
		 * result.getString("NAME"), result.getBoolean("IS_GICIK")); } };
		 * namedParameterJdbcTemplate.query(sql, paramMap, rse);
		 */
		// ---------------------------------
		// Incorrect column count: expected 1, actual 3
		// namedParameterJdbcTemplate.queryForObject(sql, paramMap, Ders.class);
		return ders;
	}

	public boolean save(Ders ders)
	{
		String sql = "insert into \"public\".\"DERS\" (\"OGRETMEN_ID\", \"KONU_ID\") values (:OGRETMENID, :KONUID)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("OGRETMENID", ders.getOGRETMEN_ID());
		paramMap.put("KONUID",ders.getKONU_ID());
		return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
	}

//	public List<Ders> getAllLike(String name)
//	{
//		String sql = "select * from \"public\".\"DERS\" where \"NAME\" LIKE :NAME";
//		Map<String, Object> paramMap = new HashMap<>();
//		paramMap.put("NAME", "%" + name + "%"); // % işareti parameter içersinde olacak
//		return namedParameterJdbcTemplate.query(sql, paramMap, BeanPropertyRowMapper.newInstance(Ders.class));
//	}

//	public boolean update(long id, Ders ders) throws SQLException
//	{
//	}
}