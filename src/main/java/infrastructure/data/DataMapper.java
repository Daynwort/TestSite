package infrastructure.data;

public interface DataMapper {
    User findUserByEmail(String email);
    User findUserByUserName(String name);
}
