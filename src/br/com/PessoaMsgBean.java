package br.com;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import org.apache.log4j.Logger;

import enity.EntityManagerUtil;
import br.com.PessoaMsg;
 
public class PessoaMsgBean {
 
  private static final Logger log = Logger.getLogger(PessoaMsgBean.class);
 
  private EntityManager entityManager;
 
  private PessoaMsg PessoaMsg = new PessoaMsg();
 
  private Long id;
 
  private List<PessoaMsg> list;
  /** Método para cadastro de pessoaMsg no banco de dados
   * @return sucesso
   * @return falhou
    */
  public String persist() {
    log.info("Cadastrando PessoaMsg: " + PessoaMsg.getNome());
    try {
      EntityTransaction transacao = getEntityManager().getTransaction();
 
      transacao.begin();
      getEntityManager().persist(PessoaMsg);
      transacao.commit();
 
      newInstance();
      list = null;
 
      return "sucesso";
    } catch (Exception e) {
      e.printStackTrace();
      return "falhou";
    }
  }
  /** Método para alterar os dados de pessoaMsg no banco de dados
   * @return sucesso
   * @return falhou
    */
  public String update() {
    log.info("Alterando PessoaMsg: " + PessoaMsg.getNome());
    try {
      EntityTransaction transacao = getEntityManager().getTransaction();
 
      transacao.begin();
      getEntityManager().merge(PessoaMsg);
      transacao.commit();
 
      newInstance();
 
      return "sucesso";
    } catch (Exception e) {
      e.printStackTrace();
      return "falhou";
    }
  }
  /** Método para remover os dados de pessoaMsg no banco de dados
   * @return sucesso
   * @return falhou
    */
  public String remove() {
    log.info("Removendo pessoa: " + PessoaMsg.getNome());
    try {
      EntityTransaction transacao = getEntityManager().getTransaction();
 
      transacao.begin();
      getEntityManager().remove(PessoaMsg);
      transacao.commit();
 
      newInstance();
      list = null;
 
      return "sucesso";
    } catch (Exception e) {
      e.printStackTrace();
      return "falhou";
    }
  }
  /** Método para listar os dados de pessoaMsg no banco de dados
   * @return sucesso
   * @return falhou
    */
  @SuppressWarnings("unchecked")
  public List getList() {
    if (list == null) {
      log.info("Buscando lista de pessoas");
      list = getEntityManager().createQuery("FROM PessoaMsg")
        .getResultList();
    }
 
    return list;
  }
  /** Método importar os dados de EntityManger
   * @return entityManager
    */
  public EntityManager getEntityManager() {
    if (entityManager == null) {
      entityManager = EntityManagerUtil.getInstance().createEntityManager();
    }
 
    return entityManager;
  }
 
  public void setPessoaMsg(PessoaMsg PessoaMsg) {
    this.PessoaMsg = PessoaMsg;
  }
 
  public PessoaMsg getPessoaMsg() {
    return PessoaMsg;
  }
 
  public void setId(Long id) {
    this.id = id;
    if (id != null) {
    	PessoaMsg = getEntityManager().find(PessoaMsg.class, id);
    }
  }
 
  public Long getId() {
    return id;
  }
 
  public void newInstance() {
	  PessoaMsg = new PessoaMsg();
  }
}
