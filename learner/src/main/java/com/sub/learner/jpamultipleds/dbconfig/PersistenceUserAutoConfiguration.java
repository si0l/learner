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
@PropertySource({ "classpath:/persistence-multiple-db-boot.properties" })
@EnableJpaRepositories(basePackages = "com.sub.learner.jpamultipleds.dao.user", entityManagerFactoryRef = "userEntityManager", transactionManagerRef = "userTransactionManager")
public class PersistenceUserAutoConfiguration {

    @Autowired
    Environment env;

    public PersistenceUserAutoConfiguration() {

        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean userEntityManager() {

        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(userDataSource());
        em.setPackagesToScan("com.sub.learner.jpamultipleds.model.user");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        final HashMap<String, Object> properties = new HashMap<>();
        // properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put(
                "javax.persistence.schema-generation.scripts.action",
                env.getProperty(
                        "spring.datasource-multipleds-users.javax.persistence.schema-generation.scripts.action"));
        properties.put(
                "javax.persistence.schema-generation.scripts.create-target",
                env.getProperty(
                        "spring.datasource-multipleds-users.javax.persistence.schema-generation.scripts.create-target"));
        properties.put(
                "javax.persistence.schema-generation.scripts.drop-target",
                env.getProperty(
                        "spring.datasource-multipleds-users.javax.persistence.schema-generation.scripts.drop-target"));
        properties.put(
                "javax.persistence.schema-generation.scripts.metadata",
                env.getProperty(
                        "spring.datasource-multipleds-users.javax.persistence.schema-generation.scripts.metadata"));

        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource-multipleds-users")
    public DataSource userDataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(env.getProperty("spring.datasource-multipleds-users.url"));
        dataSource.setUsername(env.getProperty("spring.datasource-multipleds-users.username"));
        dataSource.setPassword(env.getProperty("spring.datasource-multipleds-users.password"));

        return dataSource;

        // return DataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager userTransactionManager() {

        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(userEntityManager().getObject());

        return transactionManager;
    }

}
