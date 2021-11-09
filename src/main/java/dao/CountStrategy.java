package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CountStrategy implements StatementStrategy{
    @Override
    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {

        PreparedStatement ps = null;
        ps = c.prepareStatement(
                "select * from car_model");
        return ps;
    }
}
