package infrastructure.data;

import java.io.*;
import java.util.ArrayList;

public class FileDataMapper implements DataMapper{
    ArrayList<User> users = new ArrayList<>();

    public  FileDataMapper() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("users.txt")))) {
            String rb = null;
            while ((rb = reader.readLine())!= null){
              String[] splitedUser = rb.split(";");
                users.add(new User(splitedUser [0], splitedUser [1], splitedUser [2], splitedUser [3] ));

            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }



    }

    @Override
    public User findUserByEmail(String email) {
        for (User user: users) {
            if (user != null && user.getEMail().equals(email)){
                return user;
            }
        }
        throw new UserNotFoundException(String.format("can`t find user with this %s", email));
    }

    @Override
    public User findUserByUserName(String name) {
        for(User user: users){
            if (user != null && user.getUserName().equals(name)){
                return user;
            }
        }
        throw new UserNotFoundException(String.format("can`t find user with this %s", name));
    }

    public ArrayList<User> getAll(){
        return users;
    }
}
