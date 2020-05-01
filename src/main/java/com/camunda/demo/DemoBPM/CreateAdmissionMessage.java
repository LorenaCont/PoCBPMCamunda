package com.camunda.demo.DemoBPM;

import java.util.Calendar;
import java.util.Date;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CreateAdmissionMessage implements JavaDelegate {

	

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		String name = (String) execution.getVariable("Nombre");
		String surname = (String) execution.getVariable("Apellido");
	    Date birthDate = (Date) execution.getVariable("FechaNacimiento");
	    String sex = (String) execution.getVariable("Sexo");
	    sex = sex.toUpperCase();
	    Boolean isStudent= (Boolean) execution.getVariable("Estudia");
	    String isWelcome = null;
	    int age; 
	   
	    
	    
	    Calendar birthD = Calendar.getInstance();
	    Calendar currentDate = Calendar.getInstance();
	    birthD.setTime(birthDate);
	    age = currentDate.get(Calendar.YEAR)- birthD.get(Calendar.YEAR);
	    

	    
        if (age >= 18 && isStudent)
        {
        	if (sex.startsWith("F"))
    	    {
        		isWelcome = "Hola Sra. "+ name +" "+ surname + " has sido admitido";
    	    	
    		}else{
    		    	
    			isWelcome = "Hola Sr. "+ name +" "+ surname + " has sido admitido";
    		    	
    		}
        	
        }else if (age < 18 && isStudent == false)
        {
        	
        	if (sex.startsWith("F"))
        	{
        		isWelcome = "Hola Sra. "+ name + " "+ surname + " por el momento no has sido admitido. Intente luego";
         	    	
         	}else{
         		    	
         		isWelcome = "Hola Sr. "+ name + " "+ surname + " por el momento no has sido admitido. Intente luego";
         		    	
         	}
      
        }else
        {
        	if (sex.startsWith("F")){
        		
        		isWelcome = "Hola Sra. "+ name + " "+ surname + " por el momento no has sido admitido. No cumple con los requerimientos";
         	    	
         	}else {
         		    	
         		isWelcome = "Hola Sr. "+ name + " "+ surname + " por el momento no has sido admitido. No cumple con los requerimientos";
         		    	
         	}
        }
		    	
	    
		execution.setVariable("esBienvenido", isWelcome);
		execution.setVariable("edad", age);

	}

}
