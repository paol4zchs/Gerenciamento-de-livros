package gerdelivros.com.senai.Paola.entities;




import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;




	@Entity
	@Table(name = "tb_livro")
	public class Livro{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@NotNull
		@Column(name ="descrição")
		private String descricao;

		@NotNull
		@Column(name ="isbn")
		private String isbn;

		public Livro() {

		}	

		public Livro(Long id, String descricao, String isbn) {
			super();
			this.id = id;
			this.descricao= descricao;
			this.isbn = isbn;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		

	}

