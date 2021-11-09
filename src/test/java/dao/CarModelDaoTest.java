package dao;

import domain.CarModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DaoFactory.class)
class CarModelDaoTest {

    @Autowired
    ApplicationContext context;

    @BeforeAll
    static void init(){
    }

    @Test
    void get() throws SQLException, ClassNotFoundException {
        CarModelDao cmd = context.getBean("carModelDao", CarModelDao.class);
        CarModel cm = cmd.get(1);

        assertEquals(cm.getId(), 1);
    }

    @Test
    void add() throws SQLException {
        CarModelDao cmd = context.getBean("carModelDao", CarModelDao.class);
        CarModel carModel = new CarModel();
        carModel.setId(40);
        carModel.setName("eeee");
        carModel.setLevel(1);
        carModel.setCreatedAt(LocalDateTime.now());

        try {
            cmd.add(carModel);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        cmd.delete(40);

    }
}