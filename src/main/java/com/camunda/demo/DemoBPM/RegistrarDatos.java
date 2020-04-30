package com.camunda.demo.DemoBPM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class RegistrarDatos implements JavaDelegate {
	private ResultSet rs = null;
	private Connection con = null;
	private Statement stmt = null;
	private String nombre;
	private String apellido;
	private String sexo;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		  
		
		nombre = (String) execution.getVariable("Nombre");
		apellido = (String) execution.getVariable("Apellido");
	    sexo = (String) execution.getVariable("Sexo");
	    sexo = sexo.toUpperCase();
		
	   

	
		 //Conexión BD
			  con = ConnectionManager.getConnection();
			  stmt = con.createStatement();
		      String query = "INSERT INTO public.\"userBPM\"(nombre, apellido, sexo, iid) VALUES (?, ?, ?, ?); ";

		     
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString (1, nombre);
		      preparedStmt.setString (2, apellido);
		      preparedStmt.setString (3, sexo);
		      preparedStmt.setInt    (4, 1);

		      // execute the preparedstatement
		      preparedStmt.execute();   
		      con.close();
		  

	  }

}
