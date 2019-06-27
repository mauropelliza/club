package club.clubproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@EnableJpaRepositories(basePackages = {
"club.clubproject.repository" }, entityManagerFactoryRef = "clubEntityManager", transactionManagerRef = "clubTransactionManager")
@ComponentScan("club.clubproject.model")
@EnableTransactionManagement
public class DataSourceConfiguration {

	
}