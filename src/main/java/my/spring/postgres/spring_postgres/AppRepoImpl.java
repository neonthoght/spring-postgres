package my.spring.postgres.spring_postgres;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import my.spring.postgres.spring_postgres.AppRepo;
import  my.spring.postgres.spring_postgres.AppUser;

public class AppRepoImpl implements AppRepo {
    private JdbcTemplate jt;

    @Override
    public int createUser(AppUser usr) { 

        return jt.update("INSERT INTO test_spring.users (title, description, published) VALUES(?,?,?)",
        new Object[] { usr.getUserName(), usr.getUserPassword(), usr.getUserRoleId() });
    }

    public int deleteUser(int userId) {
        return jt.update("DELETE FROM test_spring.users where id = ?", userId);
    }

    public List<AppUser> showAllUsers() {}

    public List<AppUser> findUser(String userName)

    }
}
