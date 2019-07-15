package war.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.*;
import org.springframework.jdbc.core.JdbcTemplate;
import war.model.User;

public class MyDataBaseService implements DataBaseService {

    private JdbcTemplate jdbcTemp;

    @Override
    public void putData(/*User user*/) {
        System.out.println(jdbcTemp.update(
            "insert into people (first, last, middle) values (?, ?, ?)",
            "TEST", "TEST", "TEST") + " VALUER OF PUTDATA METHOD");
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
    }

    @Autowired  
    public MyDataBaseService(DataSource ds) {
        this.jdbcTemp = new JdbcTemplate(ds);
        System.out.println("Created JDBC TEMPLATE");
    }

    @Override
    public void printMessage() {
        System.out.println("!!!DataSorce object was created!!!");
    }
}