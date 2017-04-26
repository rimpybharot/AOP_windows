
import java.io.File;

import java.io.FileOutputStream;
import java.lang.reflect.Method;
import net.sourceforge.plantuml.FileFormat;
import net.sourceforge.plantuml.FileFormatOption;
import net.sourceforge.plantuml.SourceStringReader;

public class MyCode {

	public static void main(String[] args) throws Exception {
  
		Tracer.running=true;
		
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        Class<?> loadedMyClass = classLoader.loadClass(args[0]);

        System.out.println("Loaded class name: " + loadedMyClass.getName());


		Method meth = loadedMyClass.getMethod("main", String[].class);
		String[] params = null;
		meth.invoke(null, (Object) params);


		String fileName = "Sequence.png";
		System.out.println("Output file located at " + fileName);
		SourceStringReader reader = new SourceStringReader("@startuml\nactor InitialActor"
				+ Tracer.getSequence()
				+"\n@enduml");
		Tracer.running=false;

		FileOutputStream output = new FileOutputStream(new File(fileName));
		reader.generateImage(output, new FileFormatOption(FileFormat.PNG));
	}

}




