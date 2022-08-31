package br.com.gabrielm.springbootcommysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrielm.springbootcommysql.model.User;
import br.com.gabrielm.springbootcommysql.repository.UserRepository;

// Anotação para vincular as operações REST
// aos protocolos HTTP (get, post, put -alteração- e delete)
@RestController
public class UserController {
  // delegando a tarefa criar o objeto para o Spring
  // cria o objeto e o injeta em repository
  @Autowired
  private UserRepository repository;

  // Listar todos os usuários - GET
  @GetMapping(path = "/user")
  public List<User> consultAll() {
    return repository.findAll();
  }
  

  // Listar um usuário ou grupo específico - GET
  // de acordo com nome/ caractere informado
  @GetMapping(path = "/search/name")
  public List<User> consultName(String name) {
    return repository.findByName(name);
  }

  // Salvar usuário - POST
  @PostMapping
  public void saveUser(@RequestBody User user) {
    repository.save(user);
  }

  // Alterar usuário - PUT
  // @RequestBody atua na conversão de objeto json
  // para java, mediando a comunicação entre os lados
  @PutMapping
  public void change(@RequestBody User user) {
    if (user.getId() > 0) {
      repository.save(user);
    }
  }

  // Deletar usuário - POST
  @DeleteMapping
  public void delete(@RequestBody User user) {
    repository.delete(user);
  }
}
