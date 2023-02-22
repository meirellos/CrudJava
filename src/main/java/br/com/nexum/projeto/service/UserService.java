package br.com.nexum.projeto.service;

import br.com.nexum.projeto.model.Users;

import java.util.List;
import java.util.Optional;


public interface UserService {
    Optional<Users> getUsersById(long id);
    List<Users> getAllUsers();
    void deleteUsersById(long id);
    void updateUsersById(long id, Users users);
    void updateUsers(Users users);
    void insertUsers(Users users);
}
