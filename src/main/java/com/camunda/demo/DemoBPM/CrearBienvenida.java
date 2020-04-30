package com.camunda.demo.DemoBPM;

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
	    String isBienvenido = null;
	    int edad; 
	   
	    
	    
	    Calendar fechaNac = Calendar.getInstance();
	    Calendar fechaActual = Calendar.getInstance();
	    fechaNac.setTime(fechaNacimiento);
        edad = fechaActual.get(Calendar.YEAR)- fechaNac.get(Calendar.YEAR);
	    

	    
        if (edad >= 18 && esEstudiante)
        {
        	if (sexo.startsWith("F"))
    	    {
        		isBienvenido = "Hola Sra. "+ nombre +" "+ apellido + " has sido admitido";
    	    	
    		}else{
    		    	
    			isBienvenido = "Hola Sr. "+ nombre +" "+ apellido + " has sido admitido";
    		    	
    		}
        	
        }else if (edad < 18 && esEstudiante == false)
        {
        	
        	if (sexo.startsWith("F"))
        	{
        		isBienvenido = "Hola Sra. "+ nombre + " "+ apellido + " por el momento no has sido admitido. Intente luego";
         	    	
         	}else{
         		    	
         		isBienvenido = "Hola Sr. "+ nombre + " "+ apellido + " por el momento no has sido admitido. Intente luego";
         		    	
         	}
      
        }else
        {
        	if (sexo.startsWith("F")){
        		
        		isBienvenido = "Hola Sra. "+ nombre + " "+ apellido + " por el momento no has sido admitido. No cumple con los requerimientos";
         	    	
         	}else {
         		    	
         		isBienvenido = "Hola Sr. "+ nombre + " "+ apellido + " por el momento no has sido admitido. No cumple con los requerimientos";
         		    	
         	}
        }
		    	
	    
		execution.setVariable("isBienvenido", isBienvenido);
		execution.setVariable("edad", edad);

	}

}
