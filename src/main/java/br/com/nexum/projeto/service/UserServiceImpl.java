package br.com.nexum.projeto.service;

import br.com.nexum.projeto.model.Users;
import br.com.nexum.projeto.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository repo;


    @Override
    public  List<Users> getAllUsers() {
        return repo.findAll();
    }
    public Optional<Users> getUsersById(long id){
        return repo.findById(id);
    }
    public void deleteUsersById(long id) {
        repo.deleteById((long) id);
    }
    public void updateUsersById(long id, Users users) {
        Optional<Users> getUsers = getUsersById(id);
        getUsers.get().setName(users.getName());
        getUsers.get().setEmail(users.getEmail());
        repo.save(users);

    }
    public void updateUsers(Users users) {
        repo.save(users);
    }
    public void insertUsers(Users users) {
        repo.save(users);
    }

}
