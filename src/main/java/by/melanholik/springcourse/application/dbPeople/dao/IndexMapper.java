package by.melanholik.springcourse.application.dbPeople.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IndexMapper implements RowMapper<Integer> {
    @Override
    public Integer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        int index;
        index = resultSet.getInt("id");
        return index;
    }
}
