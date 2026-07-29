package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> users = new ArrayList<>(List.of(
            new User(1, "pepito", "pepito@gmail.com"),
            new User(2, "juan", "juan@gmail.com"),
            new User(3, "maria", "maria@gmail.com")
    ));

    public List<User> getListUsers() {
        return users;
    }

    public User getUserById(long id) {
        for (User u : users) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public User updateUser(long id, User updatedUser) {
        for (User u : users) {
            if (u.getId() == id) {
                u.setName(updatedUser.getName());
                u.setEmail(updatedUser.getEmail());
            }
            return u;
        }
        return null;
    }

    public boolean deleteUser(long id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }

}
