package war.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;
import war.model.UserDto;

public class MyDataBaseService implements DataBaseService {

    private JdbcTemplate jdbcTemp = null;
    private UserDto user;

    @Override
    public void putData() {
        jdbcTemp.update(
            "insert into people (first, last, middle) values (?, ?, ?)",
            user.getName(), user.getLast(), user.getMiddle());
        // System.out.println(user.getLast() + " " + user.getName() + " " + user.getMiddle());
    }

    @Autowired
    public void setUser(UserDto user) {
        this.user = user;
    }

    @Autowired  
    public MyDataBaseService(DataSource ds) {
        if (this.jdbcTemp == null)
            this.jdbcTemp = new JdbcTemplate(ds);
        // System.out.println("Created JDBC TEMPLATE");
    }

    @Override
    public void printMessage() {
        // System.out.println("!!!DataSorce object was created!!!");
    }
}