package gerdelivros.com.senai.Paola.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gerdelivros.com.senai.Paola.entities.Livro;
import gerdelivros.com.senai.Paola.services.LivroService;


@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private final LivroService livroService;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

	@Autowired
	public LivroController(LivroService livroService) {
		this.livroService = livroService;
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livro> getLivro(@PathVariable Long id){
		Livro livro = livroService.getlivrosById(id);
		if (livro != null)  {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Livro createLivro(@RequestBody Livro livro) {
		return livroService.saveLivro(livro);
	}
	
	@GetMapping
	public ResponseEntity<List<Livro>> getAllJogos(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Livro> jogos = livroService.getAlllivros();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType).body(jogos);
	}
	
	@PutMapping("/{id}")
	public Livro updateLivro(@PathVariable Long id, @RequestBody Livro biblioteca) {
	    return livroService.updateLivro(id, biblioteca);
	}


	@DeleteMapping("/{id}")
	public void deleteLivro(@PathVariable Long id) {
		livroService.deleteLivro(id);
	}

}
