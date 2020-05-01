package com.camunda.demo.DemoBPM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class LoggerData implements JavaDelegate {
//	private ResultSet rs = null;
	private Connection con = null;
	private Statement stmt = null;
	private String name;
	private String surname;
	private String sex;
	private int n;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		  
		
		name = (String) execution.getVariable("Nombre");
		surname = (String) execution.getVariable("Apellido");
	    sex = (String) execution.getVariable("Sexo");
	    sex = sex.toUpperCase().substring(0,1);

	    
	    
	    Random rand= new Random();
	    n = rand.nextInt(500);
	    n += 1;
	
		 //Conexión BD
			  con = ConnectionManager.getConnection();
			  stmt = con.createStatement();
		      String query = "INSERT INTO public.\"userBPM\"(nombre, apellido, sexo, iid) VALUES (?, ?, ?, ?); ";

		     
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString (1, name);
		      preparedStmt.setString (2, surname);
		      preparedStmt.setString (3, sex);
		      preparedStmt.setInt    (4, n);

		      // execute the preparedstatement
		      preparedStmt.execute();   
		      con.close();
		  
	  }

}
