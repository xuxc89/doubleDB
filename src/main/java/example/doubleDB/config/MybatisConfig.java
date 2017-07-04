package example.doubleDB.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(value={DeafultDataSourseConfig.class})
public class MybatisConfig {

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer1() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("factory01");
		mapperScannerConfigurer.setBasePackage("com.bmc.dao.db1.*");
		return mapperScannerConfigurer;
	}

	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer2() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("factory02");
		mapperScannerConfigurer.setBasePackage("com.bmc.dao.db2.*");
		return mapperScannerConfigurer;
	}
}
