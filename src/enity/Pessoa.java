package enity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Pessoa {
	@Id
 @GeneratedValue
	@Column(name = "usuarioid", nullable = false)
	private Long usuarioid;

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(nullable = false)
	@NotNull (message = "nada com nada")
	private String senha;

	@Column(nullable = false)
	@NotNull (message = "nada com nadaa")
	private String nome;
	@Column(nullable = false)
	@NotNull (message = "nada com nadaaa")
	private String endereco;
	@Column(nullable = false)
	@NotNull (message = "nada com nadaaa")
	private String email;

	@Column(name="prod_foto")
    private String foto;

   // implemente o construtor vazio
   // implemente os métodos get e setters

  

   public String getFoto() {
       return foto;
   }

   public void setFoto(String foto) {
       this.foto = foto;
   }
	
	public Long getUsuarioid() {
		return usuarioid;
	}

	public void setUsuarioid(Long usuarioid) {
		this.usuarioid = usuarioid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

}