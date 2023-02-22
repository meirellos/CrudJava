package br.com.nexum.projeto.repository;
import br.com.nexum.projeto.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Long> {}
