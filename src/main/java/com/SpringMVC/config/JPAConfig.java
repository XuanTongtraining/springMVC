package com.SpringMVC.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"com.SpringMVC.repository"})
@EnableTransactionManagement  //bật tính năng tự động đóng mở connection, commit, rollback
public class JPAConfig {
	//thay thê AbtrasDAO trong JDBC, tự động đóng mở kết nối, commit, rollback, connecttion..
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPersistenceUnitName("persistence-data");
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(additionalProperties());//chứa caus hình jpa
		return em;
	}
	//tự động quản lý transasaction: insert, update...- giống như kiểu quản lý đa luồng, tất cả các luông đều đúng mời thay đổi database
	
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public DataSource dataSource() {// thay thê hàm  getConnection() trong abtrasdao jdbc
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/springmvc");
		dataSource.setUsername("root");
		dataSource.setPassword("12345678");
		return dataSource;
	}
	
	Properties additionalProperties() {//tạo cơ sở dữ liệu từ java
		Properties properties = new Properties();
		// file chứa các cấu hình tính năng của JPA
		// cấu hình thao tác dữ liệu, giống file aplication.properties trong spring
		properties.setProperty("hibernate.hbm2ddl.auto", "create");// chạy thì chỉ thêm những phần mới
		//properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");//chạy lạy thì sẽ thay mới tất cả các bảng	
		//properties.setProperty("hibernate.hbm2ddl.auto", "none");
		return properties;
	}
}