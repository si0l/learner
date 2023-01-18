package com.sub.learner.jpamultipleds.dbconfig;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:persistence-multiple-db-boot.properties" })
@EnableJpaRepositories(basePackages = "com.sub.learner.jpamultipleds.dao.product", entityManagerFactoryRef = "productEntityManager", transactionManagerRef = "productTransactionManager")
public class PersistenceProductAutoConfiguration {

    @Autowired
    Environment env;

    public PersistenceProductAutoConfiguration() {

        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean productEntityManager() {

        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(productDataSource());
        em.setPackagesToScan("com.sub.learner.jpamultipleds.model.product");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        final HashMap<String, Object> properties = new HashMap<>();
        properties.put(
                "javax.persistence.schema-generation.scripts.action",
                env.getProperty(
                        "spring.datasource-multipleds-products.javax.persistence.schema-generation.scripts.action"));
        properties.put(
                "javax.persistence.schema-generation.scripts.create-target",
                env.getProperty(
                        "spring.datasource-multipleds-products.javax.persistence.schema-generation.scripts.create-target"));
        properties.put(
                "javax.persistence.schema-generation.scripts.drop-target",
                env.getProperty(
                        "spring.datasource-multipleds-products.javax.persistence.schema-generation.scripts.drop-target"));
        properties.put(
                "javax.persistence.schema-generation.scripts.metadata",
                env.getProperty(
                        "spring.datasource-multipleds-products.javax.persistence.schema-generation.scripts.metadata"));
        // properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-multipleds-products")
    public DataSource productDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource-multipleds-products.url"));
        dataSource.setUsername(env.getProperty("spring.datasource-multipleds-products.username"));
        dataSource.setPassword(env.getProperty("spring.datasource-multipleds-products.password"));

        return dataSource;

        // return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager productTransactionManager() {

        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(productEntityManager().getObject());

        return transactionManager;
    }
}
