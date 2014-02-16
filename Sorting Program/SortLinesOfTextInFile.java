import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLinesOfTextInFile {

	public static void main(String[] args) throws Exception {

		String inputFile = "C:/test/test.dat";
		String outputFile = "C:/test/testOutput.dat";
		String inputLine = "";

		int numberOfLines = 0;
		double sizeOfFile = 0.0;

		LineNumberReader lnr = new LineNumberReader(new FileReader(inputFile));

		while (lnr.readLine() != null){
			numberOfLines++;
		}
		File file = new File(inputFile);
		sizeOfFile = file.length()/(1024*1024);
		System.out.println("Total number of lines : " + numberOfLines+"\nFile Size : "+sizeOfFile+" Mb");

		BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
		List<String> lineList = new ArrayList<String>();
		if(numberOfLines < 1000000 && sizeOfFile < 1024){
			while ((inputLine = bufferedReader.readLine()) != null && runTimeMemory() < 100) {
				lineList.add(inputLine);
				//				System.out.println(runTimeMemory());
			}
		}
		else {
			System.out.println("\n ########## File size exceeded the limit #########");
			System.out.println("Total number of lines : " + numberOfLines+"\nFile Size : "+sizeOfFile+" MB");
		}

		Collections.sort(lineList);

		FileWriter fileWriter = new FileWriter(outputFile);
		PrintWriter out = new PrintWriter(fileWriter);
		for (String outputLine : lineList) {
			out.println(outputLine);
			//			System.out.println("\n"+outputLine);
		}

		out.flush();
		out.close();
		lnr.close();
		fileWriter.close();
	}


	public static long runTimeMemory()
	{
		int mb = 1024*1024;
		Runtime runtime = Runtime.getRuntime();

		System.out.println("Memory Used:"
				+ (runtime.totalMemory() - runtime.freeMemory()) / mb);

		return ((runtime.totalMemory() - runtime.freeMemory()) / mb);
	}
}