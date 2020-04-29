package com.camunda.demo.DemoBPM;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CrearBienvenida implements JavaDelegate {

	

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String nombre = (String) execution.getVariable("Nombre");
		String apellido = (String) execution.getVariable("Apellido");
	    Date fechaNacimiento = (Date) execution.getVariable("FechaNacimiento");
	    String sexo = (String) execution.getVariable("Sexo");
	    sexo = sexo.toUpperCase();
	    Boolean esEstudiante= (Boolean) execution.getVariable("Estudia");
	    String bienvenido = null;
	    int edad; 
	    
	    
	//    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	  //  LocalDate fechaNac = LocalDate.parse("15/08/1993", fmt);
	   // LocalDate ahora = LocalDate.now();
	    
	    Date ahora = new Date(); 
	    
	    //LocalDate birthdate = (LocalDate) fechaNacimiento;
	    		
	   // LocalDate birthdate = new LocalDate (1970, 1, 20);
	 //   LocalDate now = new LocalDate();
	   // Years age = Years.yearsBetween(birthdate, now);
	    

	//    Period periodo = Period.between(FechaNacimiento, ahora);
	 //   edad = periodo.getYears();
	   
	    System.out.println("Edad "+ ahora);
	    
	    
	    Calendar fechaNac = Calendar. getInstance();
	    Calendar fechaActual = Calendar.getInstance();
	    fechaNac.setTime(fechaNacimiento);
        edad = fechaActual.get(Calendar.YEAR)- fechaNac.get(Calendar.YEAR);
	    
        System.out.println("Edad2 "+ edad);
	    
	    		
	    if (sexo.startsWith("F") && esEstudiante)
	    {
	    	bienvenido = "Hola Sra. "+ nombre +" "+ apellido + " has sido admitido";
	    	
		}else if (sexo.startsWith("F") && esEstudiante == false)
		    {
		    	
		    	bienvenido = "Hola Sra. "+ nombre +" "+ apellido + " por el momento no has sido admitido. Intente luego";
		    }else if (sexo.startsWith("M") && esEstudiante){
		    	
		    	bienvenido = "Hola Sr. "+ nombre + " "+ apellido + " has sido admitido";
		    	
		    }else {
		    	
		    	bienvenido = "Hola Sr. "+ nombre + " "+ apellido + " por el momento no has sido admitido. Intente luego";
		    }
		    	
	    
		execution.setVariable("bienvenido", bienvenido);
		System.out.println("Paso por aqui");

	}

}
