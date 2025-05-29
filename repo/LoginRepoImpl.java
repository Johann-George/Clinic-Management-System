import java.util.Map;
import java.util.HashMap;

public class LoginRepoImpl implements ILoginRepo{

  private Map<String, User> userMap = new HashMap<>();
  userMap.put("admin",new User("admin","pass123","Admin"));

  @Override
  public void addLoginCredentials(User user){
    userMap.put(user.getUsername(),user);
  }

  @Override
  public Map<String,User> validateLogin(){
    return userMap;
  }

}
