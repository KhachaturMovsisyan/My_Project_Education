package education.storage;


import education.data.DataClass;
import education.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserStorage {
    private Map<String, User> userMaps = new HashMap<>();

    public void add(User user) {
        userMaps.put(user.getEmail(), user);
        serial();
    }


    public User getUserByEmail(String email) {

        User user = userMaps.get(email);
        return user;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        for (User user : userMaps.values()) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public void serial() {
        DataClass.serializeUsers(userMaps);
    }

    public void initData() {
        Map<String, User> userMap = DataClass.deSerializeUsers();
        if (userMap!= null) {
            userMaps = userMap;
        }
    }
}
