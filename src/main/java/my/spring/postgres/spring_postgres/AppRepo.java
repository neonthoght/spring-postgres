package my.spring.postgres.spring_postgres;
import java.util.List; 

public interface AppRepo {
    int createUser(AppUser usr);
    int deleteUser(int userId);
    //String updateUser(AppUser usr, List<String> userAttributes); // сущность обновленного пользователя и список атрибутов, которые надо обновить 
    List<AppUser> showAllUsers();
    List<AppUser> findUser(String userName);
}
