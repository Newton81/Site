package enity;


import br.com.UploadArquivo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;

import br.com.CriptografiaUtils;
import enity.EntityManagerUtil;
import enity.Pessoa;
import br.com.UsuarioUtil;
 
public class PessoaBean {
 
  private static final Logger log = Logger.getLogger(PessoaBean.class);
 
  private EntityManager entityManager;
 
  private Pessoa pessoa = new Pessoa();
 
  String senha = "";
  
  private UploadArquivo arquivo = new UploadArquivo();
  
  private Long id;
 
  private List<Pessoa> list;
  
  /** Método para cadastro de pessoa no banco de dados, criptografando a senha
   * @return sucesso
   * @return falhou
    */
  public String persist() {
    log.info("Cadastrando pessoa: " + pessoa.getNome());
    try {
    	senha = UsuarioUtil.md5(pessoa.getSenha());
      EntityTransaction transacao = getEntityManager().getTransaction();
     
      
      
      this.arquivo = new UploadArquivo();
      transacao.begin();
      pessoa.setSenha(senha);
      getEntityManager().persist(pessoa);
      transacao.commit();
 
      newInstance();
      list = null;
 
      return "sucesso";
    } catch (Exception e) {
      e.printStackTrace();
      return "falhou";
    }
  }
  
  /** Método para alterar os dados de pessoa no banco de dados
   * @return sucesso
   * @return falhou
    */
  
  public String update() {
    log.info("Alterando pessoa: " + pessoa.getNome());
    try {
    	senha = UsuarioUtil.md5(pessoa.getSenha());
      EntityTransaction transacao = getEntityManager().getTransaction();
 
      transacao.begin();
      pessoa.setSenha(senha);
      getEntityManager().merge(pessoa);
      transacao.commit();
 
      newInstance();
 
      return "sucesso";
    } catch (Exception e) {
      e.printStackTrace();
      return "falhou";
    }
  }
  
  /** Método para remover os dados de pessoa no banco de dados
   * @return sucesso
   * @return falhou
    */
  
  public String remove() {
    log.info("Removendo pessoa: " + pessoa.getNome());
    try {
      EntityTransaction transacao = getEntityManager().getTransaction();
 
      transacao.begin();
      getEntityManager().remove(pessoa);
      transacao.commit();
 
      newInstance();
      list = null;
 
      return "sucesso";
    } catch (Exception e) {
      e.printStackTrace();
      return "falhou";
    }
  }
  
  /** Método para remover os dados de pessoa no banco de dados
   * @return sucesso
   * @return falhou
    */
  
  @SuppressWarnings("unchecked")
  public List getList() {
    if (list == null) {
      log.info("Buscando lista de pessoas");
      list = getEntityManager().createQuery("FROM Pessoa")
        .getResultList();
    }
 
    return list;
  }
  
  /** Método para importar o EntityManger
   * @return entityManager
    */
  
  public EntityManager getEntityManager() {
    if (entityManager == null) {
      entityManager = EntityManagerUtil.getInstance().createEntityManager();
    }
 
    return entityManager;
  }
 
  public void uploadAction (FileUploadEvent event){
      this.arquivo.fileUpload(event, ".jpg", "/image/");
      this.pessoa.setFoto(this.arquivo.getNome());
  }
  
  public void setPessoa(Pessoa pessoa) {
    this.pessoa = pessoa;
  }
 
  public Pessoa getPessoa() {
    return pessoa;
  }
 
  public void setId(Long id) {
    this.id = id;
    if (id != null) {
      pessoa = getEntityManager().find(Pessoa.class, id);
    }
  }
 
  public Long getId() {
    return id;
  }
 
  public void newInstance() {
    pessoa = new Pessoa();
  }
  
  
}