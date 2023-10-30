/**
 * Caeser cipher Encryption/Decryption class of Code Breaker
 *
 * @author George Ive
 * @Version 1.0 23/05/2023
 */

import java.io.*;

public class Caeser extends Cipher {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private StringBuilder caeserBuilder = new StringBuilder();
    private static final String enFileName = "EncryptedText.txt";
    private String encryptedText;

    public Caeser() {

    }

    public String getEncryptedText() {
        return encryptedText;
    }

    public void setEncryptedText(String encryptedText) {
        this.encryptedText = encryptedText;
    }

    public String caeserEncrypt(String cMessage, int cKey) {
        String caeserText = "";
        for (int i = 0; i < cMessage.length(); i++) {
            int charPos = alphabet.indexOf(cMessage.charAt(i));
            int keyPos = (cKey + charPos) % 26;
            char moveChar = alphabet.charAt(keyPos);
            caeserBuilder.append(moveChar);
            caeserText = caeserBuilder.toString();
            encryptedText = caeserText;
            save();
        }
        return caeserText;
    }

    public String caeserDecrypt(String cMessage, int cKey) {
        String decryptText = "";
        for (int i = 0; i < cMessage.length(); i++) {
            int charPos = alphabet.indexOf(cMessage.charAt(i));
            int keyPos = (charPos - cKey) % 26;
            if (keyPos < 0) {
                keyPos = alphabet.length() + keyPos;
            }
            char moveChar = alphabet.charAt(keyPos);
            caeserBuilder.append(moveChar);
            decryptText = caeserBuilder.toString();
        }
        return decryptText;
    }

    public void save() {
        try {
            FileWriter fw = new FileWriter(enFileName);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(encryptedText);
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(String enFileName, Caeser caeser) throws IOException {
        try (FileReader reader = new FileReader(enFileName);
             BufferedReader bReader = new BufferedReader(reader)) {
            String encryptPrint = bReader.readLine();
            System.out.println(encryptPrint);

            caeser.setEncryptedText(encryptPrint);

        } catch (IOException e) {
            System.out.println("No text found.");
        }
    }
}