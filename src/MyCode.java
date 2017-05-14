
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

        Class<?> mainClass = classLoader.loadClass(args[0]);


		Method mainMethod = mainClass.getMethod("main", String[].class);
		String[] params = null;
		mainMethod.invoke(null, (Object) params);


		String fileName = "Sequence.svg";
		System.out.println("Output file located at " + fileName);
		SourceStringReader reader = new SourceStringReader("@startuml\nactor Actor"
				+ Tracer.getSequence()
				+"\n@enduml");
		Tracer.running=false;

		FileOutputStream output = new FileOutputStream(new File(fileName));
		reader.generateImage(output, new FileFormatOption(FileFormat.SVG));
	}

}
