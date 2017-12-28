package br.com;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name="CadastrarMB")
@RequestScoped
public class CadastrarMBean {


	       
	       
	       private Tratores trator = new Tratores();
	       
	       
	            
	                  
	                  
	                 
	               
	                  
	                  
	                  
	       
	       
	       public List<Tratores> getTratores() throws SQLException {
	   
	            Conectar con = new Conectar();
	            List<Tratores> listaTratores = con.ListTratores();
	       
	            return listaTratores;
	            
	       }
	       
	       

		public Tratores getTrator() {
			return trator;
		}

		public void setTrator(Tratores trator) {
			this.trator = trator;
		}
	  }