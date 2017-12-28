package br.com;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import java.sql.SQLException;
import java.util.List;

@ManagedBean(name="ContatoMB")
@RequestScoped
public class ContatoMBean {


	       
	       
	       private Safras safra = new Safras();
	       
	       
	       
	       public List<Safras> getSafras() throws SQLException {
	   
	            ConectarC con = new ConectarC();
	            List<Safras> listaSafras = con.listSafras();
	       
	            return listaSafras;
	       }

		

		public Safras getSafra() {
			return safra;
		}

		public void setSafra(Safras safra) {
			this.safra = safra;
		}
	       
	      
	  }
