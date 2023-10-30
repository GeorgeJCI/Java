/**
 *  main Application of Code Breaker
 * @author George Ive
 * @Version 1.0 23/05/2023
 */

import java.io.IOException;
import java.util.Scanner;

public class Application {
   private Scanner keyboard = new Scanner(System.in);
   private static final String filename = "prep.txt";
   private static final String enFileName = "EncryptedText.txt";
   private InputText inputText = new InputText();
   private Caeser encryptText = new Caeser();

    /**
     * Main method for Code Breaker
     * calls a menu
     */
    public static void main(String[] args) throws IOException {
        InputText text = new InputText();
        //text.inputMessage();
        Application app = new Application();
        System.out.println("Welcome to Code Breaker!");
        app.breakerMenu();

    }

    /**
     * The main menu allows user to call the different methods from one place
     */
    public void breakerMenu() throws IOException {
        String menuOption;
        do {
            System.out.println("Chose function:" +
                    "\n 1. Prepare text for encryption" +
                    "\n 2. Load a saved text file" +
                    "\n 3. Run a Caeser encryption" +
                    "\n 4. Run a Caeser decryption" +
                    "\n Q. Quit the program");
            menuOption = keyboard.next().toUpperCase();
            InputText newText = new InputText();

            switch (menuOption) {
                case "1":
                    newText.prepText();
                    break;
                case "2":
                    loadFileSelection();
                    break;
                case "3":
                    callCaeEnc();
                    break;
                case "4": callCaeDec();
                    break;
                case "Q": break;
            }
        } while(!(menuOption.equals("Q")));
    }

    /**
     * callCaeEnc - calls the method in the Caeser class to encrypt the text this method contains
     * Using given key
     * @throws IOException
     */
    public void callCaeEnc() throws IOException {
        Key cKey = new Key();
        String mainText = inputText.getPreppedString();
        int mainKey = cKey.getCaeserKey();
       if(mainText != null) {
           Caeser caeser = new Caeser();
           String encText = caeser.caeserEncrypt(mainText, mainKey);
           System.out.println(encText);
       } else{
           System.out.println("Please save or load the text you wish to encrypt.");
       }
    }
    /**
     * callCaeEnc - calls the method in the Caeser class to decrypt the text this method contains
     * Using given key
     * @throws IOException
     */
    public void callCaeDec() throws IOException {
        Key cKey = new Key();
        String enText = encryptText.getEncryptedText();
        int mainKey = cKey.getCaeserKey();
        if(enText != null){
            Caeser caeser = new Caeser();
            String decText = caeser.caeserDecrypt(enText, mainKey);
            System.out.println(decText);
        } else{
            System.out.println("Please load the encrypted file.");
        }

    }

    /**
     * Select which file the user wants to load.
     * @throws IOException
     */
    public void loadFileSelection() throws IOException {
        System.out.println("What file do you wish to load?");
        System.out.println("1. Prepared text\n" +
                           "2. Encrypted text\n" +
                           "3. Decrypted text");
        String fileChoice = keyboard.next();
        switch(fileChoice){
            case"1": InputText newText = new InputText();
                     newText.load(filename,inputText);
                     break;
            case"2": Caeser fileCaeser = new Caeser();
                     fileCaeser.load(enFileName,encryptText);
                     break;

        }
    }
}
