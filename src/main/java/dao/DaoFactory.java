package dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class DaoFactory {

    @Bean
    public CarModelDao carModelDao(){
        return new CarModelDao(new JdbcContext(dataSource()));
    }

    @Bean
    public DataSource dataSource(){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://database-2.clvwtbd3pi7c.ap-northeast-2.rds.amazonaws.com/bmwgs");
        dataSource.setUsername("admin");
        dataSource.setPassword("12345678");

        return dataSource;
    }
}
