package gerdelivros.com.senai.Paola.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import gerdelivros.com.senai.Paola.entities.Livro;
import gerdelivros.com.senai.Paola.repositories.LivroRepository;

@Service
public class LivroService {
	private final LivroRepository livroRepository;

	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}

	public Livro getlivrosById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}

	public List<Livro> getAlllivros() {
		return livroRepository.findAll();
	}

	public void deleteLivro(Long id) {
		livroRepository.deleteById(id);
	}
	
	public Livro updateLivro(Long id,Livro novoJogo) {
        Optional<Livro> jogoOptional = livroRepository.findById(id);
        if (jogoOptional.isPresent()) {
        	Livro jogoExistente = jogoOptional.get();
           	jogoExistente.setDescricao(novoJogo.getDescricao());
        	jogoExistente.setIsbn(novoJogo.getIsbn());          
            return 	livroRepository.save(jogoExistente); 
        } else {
            return null; 
        }
	}



}

