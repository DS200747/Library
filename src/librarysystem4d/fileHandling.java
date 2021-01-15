
package librarysystem4d;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class fileHandling {
    
    public static String folderDirectory = System.getProperty("user.dir")+ "\\bookList.txt";
    public static String fileDirectory = System.getProperty("user.dir")+ "\\borrowerList.txt";
    
    
    public static void writeBookFile(ArrayList<book> bookList) {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < bookList.size(); i++) {
                printToFile.println(bookList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
     public static void writeBorrowerFile(ArrayList<borrower> borrowerList) {

        try {
            FileWriter writeToFile = new FileWriter(fileDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < borrowerList.size(); i++) {
                printToFile.println(borrowerList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    

    public static ArrayList<book> readBookFile() {
        ArrayList<book> bookList = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] bookDetails = lineFromFile.split(",");
                
                book newBook = new book(bookDetails[0], bookDetails[1], Double.parseDouble(bookDetails[2]),bookDetails[3], bookDetails[4]);
                bookList.add(newBook);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return bookList;
    }
    
    public static ArrayList<borrower> readBorrowerFile() {
        ArrayList<borrower> borrowerList = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(fileDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] borrowerDetails = lineFromFile.split(",");
                
                borrower newBorrower = new borrower(borrowerDetails[0], borrowerDetails[1]);
                borrowerList.add(newBorrower);
            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return borrowerList;
    }

    
}
