package br.com;


	import java.sql.Connection;
	  import java.sql.DriverManager;
	  import java.sql.PreparedStatement;
	  import java.sql.ResultSet;
	  import java.sql.SQLException;
	  import java.sql.Statement;

import java.util.ArrayList;
	  
	  import java.util.List;
	  import java.util.logging.Level;
	  import java.util.logging.Logger;
	   
	  

	   
	  public class Conectar {
		  
		  Connection con = null;
		  
		  /** Método criar a conexao com o banco de dados na classe
		   * 
		    */
	       public Conectar() throws SQLException {
	   
	            try {
	                  Class.forName("com.mysql.jdbc.Driver");
	                  System.out.println("Instalou driver");
	            } catch (ClassNotFoundException e) {
	                  // TODO Auto-generated catch block
	                  e.printStackTrace();
	            }
	   
	            String url = "jdbc:mysql://localhost:3306/cadastro";
	            String user = "root";
	            String password = "";
	            con = DriverManager.getConnection(url, user, password);
	       }
	   
	       public void closeConnection() throws SQLException {
	   
	            con.close();
	       }
	   
	       
	       /** Método para listar os dados de safras
		 	   * @return tratores
		 	    */
	           
	            public List<Tratores> ListTratores() {
	        
	                 ArrayList<Tratores> lista = new ArrayList<Tratores>();
	        
	                 Statement st = null;
	                 ResultSet rs = null;
	        
	                 try {
	                       st = con.createStatement();
	                       String sql = "select * from cadastro7";
	                      rs = st.executeQuery(sql);
	       
	                      while (rs.next()) {
	       
	                           Tratores tratores = new Tratores();
	                           tratores.setId(rs.getInt(1));
	                           tratores.setModelo(rs.getInt(2));
	                           tratores.setNome(rs.getString(3));
	                           tratores.setAno(rs.getInt(4));
	                           tratores.setMarca(rs.getString(5));
	                           tratores.setCor(rs.getString(6));
	                           lista.add(tratores);
	                      }
	       
	                } catch (SQLException ex) {
	                      Logger lgr = Logger.getLogger(Conectar.class.getName());
	                      lgr.log(Level.SEVERE, ex.getMessage(), ex);
	       
	                } finally {
	                      try {
	                           if (rs != null) {
	                                rs.close();
	                           }
	                           if (st != null) {
	                                st.close();
	                           }
	                           if (con != null) {
	                                con.close();
	                           }
	       
	                      } catch (SQLException ex) {
	                           Logger lgr = Logger.getLogger(Conectar.class.getName());
	                           lgr.log(Level.WARNING, ex.getMessage(), ex);
	                      }
	                }
	                return lista;
	           }
	         
	      }
	   
	                
	       
	       
	  
	     
	  

