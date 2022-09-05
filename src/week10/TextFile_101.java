package week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
/**
 * Output:
 * 0) Text file named: file_.txt
1) This is a multi String file,
2) second line ...
3)  3dr...
4) end of file
 * @author boaz.benmoshe
 *
 */
public class TextFile_101 {
	public static void main(String[] a) throws FileNotFoundException {
		String str = "file_123.txt";
		String data = "This is a multi String file,\n"
				+ "second line ...\n 3dr... \n \n \n EOF";
		save(str, data);
		load(str);
		System.out.println("OK");
		
	}
	public static void save(String file, String data) {
		 try {
		      FileWriter myWriter = new FileWriter(file);
		      myWriter.write("Text file named: "+file+"\n");
		      myWriter.write(data+"\n");
		      myWriter.write("end of file");
		      myWriter.close();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

	public static void load(String file) throws FileNotFoundException {
		//try {
			File myObj = new File(file);
		    Scanner myReader = new Scanner(myObj);
		    int i=0;
		    while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(i+") "+data);
		        i=i+1;
		    }
		    myReader.close();
		//}
	//	catch(Exception e) {
	//		e.printStackTrace();
	//	}
	}
	
}
