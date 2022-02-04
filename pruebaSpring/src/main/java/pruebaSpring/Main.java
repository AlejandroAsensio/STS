package pruebaSpring;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pruebaSpring.entities.Musico;
import pruebaSpring.entities.MusicoCutre;


public class Main {

	public static void main(String[] args) throws FileNotFoundException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		System.out.println("Comienza");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		Musico m = (Musico)context.getBean("musico");
		
		m.tocar();
		
//		MusicoCutre mc = new MusicoCutre();
//		mc.tocar();
		
//		Musico musico = new Musico();
//		musico.tocar();
		
	}

}
