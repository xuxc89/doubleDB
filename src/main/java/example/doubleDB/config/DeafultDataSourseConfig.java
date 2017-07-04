package example.doubleDB.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;

/**
 * 双数据源配置测试
 * @author xxc
 * @since 20170704
 */
@Configuration
@PropertySource(value="classpath:db.properties")
public class DeafultDataSourseConfig {
	
	@Value("${mysql.druid.driverClassName}")
	String driver;
	@Value("${mysql.druid.url01}")
	String url01;
	@Value("${mysql.druid.url02}")
	String url02;
	@Value("${mysql.druid.username}")
	String username;
	@Value("${mysql.druid.password}")
	String password;
	@Value("${mysql.druid.maxActive}")
	int maxActive;
	@Value("${mysql.druid.initialSize}")
	int initialSize;
	
	@Bean
	public ServletRegistrationBean druidServlet() {
		return new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
	}
	
	@Bean
	@Primary
	private DataSource creatDataSource01() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url01);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setMaxActive(maxActive);
		ds.setInitialSize(initialSize);
		try {
			ds.setFilters("stat, wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	@Bean
	private DataSource creatDataSource02() {
		DruidDataSource ds = new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url02);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setMaxActive(maxActive);
		ds.setInitialSize(initialSize);
		try {
			ds.setFilters("stat, wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}
	
	@Bean
	@Primary
	private SqlSessionFactory factory01() throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(creatDataSource01());
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
		bean.setMapperLocations(resolver.getResources("classpath:mybatis/db1/**/*.xml"));
		
		return bean.getObject();
	}
	
	@Bean
	private SqlSessionFactory factory02() throws Exception{
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(creatDataSource02());
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
		bean.setMapperLocations(resolver.getResources("classpath:mybatis/db2/**/*.xml"));
		
		return bean.getObject();
	}
	
	@Bean
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		//双数据源配置
		DataSourceTransactionManager ds = new DataSourceTransactionManager(creatDataSource01());
		DataSourceTransactionManager ds2 = new DataSourceTransactionManager(creatDataSource02());
		ChainedTransactionManager ctm = new ChainedTransactionManager(ds,ds2);
		
		return ctm;
	}
}
