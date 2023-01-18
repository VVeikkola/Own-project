import java.io.*;
import java.util.*;
 
public class MainW {

    public static void main (String[] args){
        
    Scanner scanner = new Scanner(System.in);
    Scanner fileIn; //input file connection
    PrintWriter fileOut; //HTML file connection
    String fileNameIn;
    String fileNameOut;
    int dotIndex;
    String line = null;

    // ask user filename

    System.out.println("Enter file name or path");
    fileNameIn = scanner.nextLine();

    // check if file exists

    try{
        //rename .txt as html
        fileIn = new Scanner(new FileReader(fileNameIn));
        dotIndex = fileNameIn.lastIndexOf(".");
        if(dotIndex == -1){
            fileNameOut = fileNameIn + ".html";
        }else {
            fileNameOut = fileNameIn.substring(0, dotIndex) + ".html";
        }
        fileOut = new PrintWriter(fileNameOut);

        // determine if file is empty

        try{
            line = fileIn.nextLine();
        }
        catch(NoSuchElementException e){
            System.out.println("Error: " + e.getMessage());
        }
        if(line == null){
            System.out.println("This file is empty ");
        }else {
            fileOut.println("<html>");
            fileOut.println("<head>");
            fileOut.println("</head>");
            fileOut.println("<body>");
            fileOut.println(line);


            while(fileIn.hasNextLine()){

                fileOut.println("<br>");
                line = fileIn.nextLine();

                if(line.isEmpty()){
                    fileOut.println("<br>");
                }
                else{
                    fileOut.println(line);
                }
            }
            fileOut.println("</body>");
            fileOut.println("</html>");

            System.out.println("HTML file is processed");
        }
        fileIn.close();
        fileOut.close();
        scanner.close();
    }
    catch(FileNotFoundException e){
        System.out.println("File not found");
    }
   }

   

 }