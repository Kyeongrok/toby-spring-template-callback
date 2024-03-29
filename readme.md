## 토비의 스프링3 3장 Template Callback

1. jdbcContext만들기
2. Template Callback 계산기


### StatementStrategy

Connection을 받고 PreparedStatement를 리턴하는 Interface

```java
public interface StatementStrategy {
    PreparedStatement makePreparedStatement(Connection c) throws SQLException;
}
```

### query를 받아서 실행

StatementStrategy를 만들어서 executeUpdate를 태웁니다.

```java
public void executeSql(String query) throws SQLException {
        this.workWithStatementStrategy(new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement(query);
                return ps;
            }
        });
    }
```


### Dependency

SpringBoot가 들어있지 않습니다.

```.gradle
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.7.0'
    // https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api
    compileOnly 'javax.servlet:javax.servlet-api:4.0.1'
    compile 'mysql:mysql-connector-java:8.0.25'

    compile 'org.springframework:spring-context:5.3.12'
    compile 'org.springframework:spring-jdbc:5.3.12'
    compile 'org.springframework:spring-test:5.3.12'
}
```


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
