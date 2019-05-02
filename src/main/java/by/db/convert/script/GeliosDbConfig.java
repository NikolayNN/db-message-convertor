package by.db.convert.script;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "geliosEntityManagerFactory",
    transactionManagerRef = "geliosTransactionManager", basePackages = {"by.db.convert.script.gelios.repo"})
public class GeliosDbConfig {

  @Bean(name = "geliosDataSource")
  @ConfigurationProperties(prefix = "gelios.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "geliosEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean geliosEntityManagerFactory(
      EntityManagerFactoryBuilder builder, @Qualifier("geliosDataSource") DataSource dataSource) {
    return builder.dataSource(dataSource).packages("by.db.convert.script.gelios.domain").persistenceUnit("gMessage")
        .build();
  }

  @Bean(name = "geliosTransactionManager")
  public PlatformTransactionManager geliosTransactionManager(
      @Qualifier("geliosEntityManagerFactory") EntityManagerFactory geliosEntityManagerFactory) {
    return new JpaTransactionManager(geliosEntityManagerFactory);
  }
}
