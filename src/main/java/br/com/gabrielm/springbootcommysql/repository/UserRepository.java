package br.com.gabrielm.springbootcommysql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.gabrielm.springbootcommysql.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  @Query(value = "select usuario from usuario usuario where usuario.name like %?1%")
  List<User> findByName(String name);

  
}
