## 토비의 스프링3 3장 Template Callback

1. jdbcContext만들기
2. Template Callback 계산기


## DataSource

DataSource를 이용합니다.

```java
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
```
