package dao;

import domain.CarModel;

import javax.sql.DataSource;
import java.sql.*;

public class CarModelDao {
    private JdbcContext jdbcContext;

    public CarModelDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public int getCount() throws SQLException {
        StatementStrategy st = new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("select count(*) from car_model");
                return ps;
            }
        };
        this.jdbcContext.workWithStatementStrategy(st);
        return 0;
    }


    public void delete(int id) throws SQLException {
        this.jdbcContext.executeSql("delete from car_model where id="+id);
    }

    public void add(CarModel carModel) throws SQLException {
        this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
            @Override
            public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                PreparedStatement ps = c.prepareStatement("insert into car_model(id, name, level, created_at, updated_at) values(?, ?, ?, ?, ?)");
                ps.setInt(1, carModel.getId());
                ps.setString(2, carModel.getName());
                ps.setInt(3, carModel.getLevel());
                ps.setTimestamp(4, Timestamp.valueOf(carModel.getCreatedAt()));
                ps.setTimestamp(5, Timestamp.valueOf(carModel.getCreatedAt())); // created at과 같음
                return ps;
            }
        });

    }

    public CarModel get(int id) throws SQLException, ClassNotFoundException {

//        PreparedStatement ps = c.prepareStatement(
//                "select * from car_model where id = ?");
//        ps.setInt(1, id);
//
//        ResultSet rs = ps.executeQuery();
//        rs.next();

        CarModel carModel = new CarModel();
//        carModel.setId(rs.getInt("id"));
//        carModel.setName(rs.getString("name"));
//
//        rs.close();
//        ps.close();
//        c.close();

        return carModel;
    }



    public static void main(String[] args) throws SQLException, ClassNotFoundException {



    }
}
