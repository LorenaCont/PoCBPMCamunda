package com.camunda.demo.DemoBPM;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CrearBienvenida implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		execution.setVariable("bienvenido", "Hola");
		System.out.println("Paso por aqui");

	}

}
