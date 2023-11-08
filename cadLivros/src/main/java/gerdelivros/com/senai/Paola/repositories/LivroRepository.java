package gerdelivros.com.senai.Paola.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gerdelivros.com.senai.Paola.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
