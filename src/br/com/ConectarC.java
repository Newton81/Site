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
	   
	  

	  
	  public class ConectarC {
		  
		  Connection con = null;
		  
		  /** Método criar a conexao com o banco de dados na classe
		   * 
		    */
		  
	       public ConectarC() throws SQLException {
	   
	            try {
	                  Class.forName("com.mysql.jdbc.Driver");
	                  System.out.println("Iniciou driver");
	            } catch (ClassNotFoundException e) {
	                  
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
	 	   * @return lista
	 	    */
	           
	            public List<Safras> listSafras() {
	        
	                 ArrayList<Safras> lista = new ArrayList<Safras>();
	        
	                 Statement st = null;
	                 ResultSet rs = null;
	        
	                 try {
	                       st = con.createStatement();
	                       String sql = "select * from cadastro11";
	                      rs = st.executeQuery(sql);
	       
	                      while (rs.next()) {
	       
	                           Safras safra = new Safras();
	                           safra.setId(rs.getInt(1));
	                           safra.setNome(rs.getString(2));
	                           safra.setAno(rs.getInt(3));
	                           safra.setProducao(rs.getFloat(4));
	                           safra.setProdutividade(rs.getFloat(5));
	                           safra.setValorSaca(rs.getFloat(6));
	                           lista.add(safra);
	                      }
	       
	                } catch (SQLException ex) {
	                      Logger lgr = Logger.getLogger(ConectarC.class.getName());
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
	                           Logger lgr = Logger.getLogger(ConectarC.class.getName());
	                           lgr.log(Level.WARNING, ex.getMessage(), ex);
	                      }
	                }
	                return lista;
	           }
	         
	      }
