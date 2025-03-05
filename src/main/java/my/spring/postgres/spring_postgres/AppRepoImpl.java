package my.spring.postgres.spring_postgres;
import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import my.spring.postgres.spring_postgres.AppRepo;
import  my.spring.postgres.spring_postgres.AppUser;

@Repository
public class AppRepoImpl implements AppRepo {

    DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "123");
    private JdbcTemplate jt = new JdbcTemplate(dataSource);


    @Override
    public int createUser(AppUser usr) {

        return jt.update("INSERT INTO test_spring.users (user_name, user_password, user_role_id) VALUES(?,?,?)",
        new Object[] { usr.getUserName(), usr.getUserPassword(), usr.getUserRoleId() });
    }
    
    @Override
    public int deleteUser(int userId) {
        return jt.update("DELETE FROM test_spring.users where id = ?", userId);
    }

    public List<AppUser> showAllUsers() {

        return jt.query("SELECT * from test_spring.users;", BeanPropertyRowMapper.newInstance(AppUser.class));
    }

    public List<AppUser> findUser(String userName) {
        try {
            List<AppUser> users = new ArrayList<AppUser>();

            AppUser usr = jt.queryForObject("SELECT * FROM test_spring.users WHERE user_name=?",
            BeanPropertyRowMapper.newInstance(AppUser.class), userName);
            
            users.add(usr);
            return users;
            } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

}

