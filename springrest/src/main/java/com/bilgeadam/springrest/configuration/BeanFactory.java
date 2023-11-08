package com.bilgeadam.springrest.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.bilgeadam.springrest.Constants;

@Configuration
//@Component // 'de olailir ama configuration tercih edilir
public class BeanFactory
{
	// xml 'de oluşturmak yerine java tarafında bean oluşturmak için
	// buradan oluşan bean 'ler applicaiton context e gidecek

	@Bean(name = "myds")
	public DataSource getDatasource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource(Constants.URL, Constants.USER, Constants.PASSWORD);
		ds.setDriverClassName("org.postgresql.Driver");
		return ds;
	}

	@Bean(name = "bizimjdbctemplate") // xml 'de <bean> in alternatifi
	@DependsOn(value = "myds")
	public JdbcTemplate createjdbctemplate(@Qualifier(value = "myds") DataSource ds)
	{
		return new JdbcTemplate(ds);
	}

	@Bean
	@DependsOn(value = "myds")
	public NamedParameterJdbcTemplate mynamedparameterjdbctemplate(@Qualifier(value = "myds") DataSource ds)
	{
		return new NamedParameterJdbcTemplate(ds);
	}
}