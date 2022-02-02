package pruebaSpring.entities;

import java.io.FileInputStream;
import java.util.Properties;

public class InstrumentoMusicalFactory {

	private static InstrumentoMusicalFactory imf;
	
	private InstrumentoMusicalFactory() {
		
	}
	public static InstrumentoMusicalFactory getIMF() {
		if(imf==null) {
			imf = new InstrumentoMusicalFactory();
		}
		return imf;
	}
	
	public InstrumentoMusical getInstrumento() {
		InstrumentoMusical im = null;
		try {
		Properties p = new Properties();
		p.load(new FileInputStream("conf.properties"));
		return (InstrumentoMusical)Class.forName(p.getProperty("instrumento")).newInstance();
		}
		catch (Exception e) {
			
		}
		return im;	
		
	}
}
