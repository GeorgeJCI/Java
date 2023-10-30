/**
 *  input and prepare text class of Code Breaker
 * @author George Ive
 * @Version 1.0 23/05/2023
 */
import java.io.*;
import java.util.Scanner;

public class InputText {
    private String input = null;
    private Scanner keyboard = new Scanner(System.in);
    private String preppedString;
    private InputText inputText;

    private static final String fileName = "prep.txt";

//    public InputText(String ps){
//        //input = in;
//        preppedString = ps;
//    }
    public InputText() {

    }
//      TESTING CLASS
//    public void inputMessage() throws IOException {
//        System.out.println("Please enter the message you wish to encrypt: ");
//        input = keyboard.nextLine();
//        System.out.println("Inputted message: \n"+ input);
//        System.out.println("Prepare text for encoding (Y/N): ");
//        String prep = keyboard.nextLine();
//        switch(prep){
//            case "Y": prepText();
//                break;
//            case "N": load(fileName, inputText);
//                break;
//        }
//    }
    public void prepText(){
        System.out.println("Please enter the text you wish to prepare for encoding: ");
        input = keyboard.nextLine();
        System.out.println("Inputted text: " + input);
            String prepped = input;
            // regex '\\s' removes the spaces, A-Z a-z removes
            // anything not in the 26 letter alphabet
           preppedString = prepped.replaceAll("\\s|[^A-Za-z]+", "").toUpperCase();
            System.out.println(preppedString);
            save();
    }

    public String getPreppedString() {
        return preppedString;
    }

    public void setPreppedString(String preppedString) {
        this.preppedString = preppedString;
    }

    public void save(){
        try {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(preppedString);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void load(String filename, InputText inputText) throws IOException{
        try(FileReader reader = new FileReader(filename);
            BufferedReader bReader = new BufferedReader(reader)){
            String textPrint = bReader.readLine();
            System.out.println(textPrint);

            inputText.setPreppedString(textPrint);

        }catch(IOException e){
            System.out.println("No text found.");
        }
    }

    @Override
    public String toString() {
        return preppedString;
    }
}
