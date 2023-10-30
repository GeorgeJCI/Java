import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * To model a Kennel - a collection of cats
 *
 * @author Chris Loftus and Faisal Rezwan and George Carlyle-Ive
 * @version 2 (20th February 2019)
 */
public class Kennel {
    private String kenName;
    private ArrayList<Animal> animals;
    private int nextFreeLocation;
    private int capacity;

    /**
     * Creates a kennel with a default size 20
     */
    public Kennel() {
        this(20);
    }

    /**
     * Create a kennel
     *
     * @param maxNoAnimals The capacity of the kennel
     */
    public Kennel(int maxNoAnimals) {
        nextFreeLocation = 0; // no Animals in collection at start
        capacity = maxNoAnimals;
        animals = new ArrayList<Animal>(capacity); // set up default. This can
        // actually be exceeded
        // when using ArrayList but we
        // won't allow that
        // to happen.
    }

    /**
     * This method sets the value for the name attribute. The purpose of the
     * attribute is: The name of the kennel e.g. "CatsRUs"
     *
     * @param theName
     */
    public void setName(String theName) {
        kenName = theName;
    }

    /**
     * Set the size of the kennel
     *
     * @param capacity The max animals we can house
     */
    public void setCapacity(int capacity) {
        // This should really check to see if we already have animals
        // in the kennel and reducing the capacity would lead to evictions!
        this.capacity = capacity;
    }

    /**
     * Maximum capacity of the kennels
     *
     * @return The max size of the kennel
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * This method gets the value for the name attribute. The purpose of the
     * attribute is: The name of the Kennel e.g. "CatsRUS"
     *
     * @return String The name of the kennel
     */
    public String getName() {
        return kenName;
    }

    /**
     * This method returns the number of cats in a kennel
     *
     * @return int Current number of cats in the kennel
     */
    public int getNumOfAnimals() {
        return nextFreeLocation;
    }

    /**
     * Enables a user to add a Cat to the Kennel
     *
     * @param theAnimal A new cat to home
     */
    public void addAnimal(Animal theAnimal) {
        if (nextFreeLocation >= capacity) {
            System.out.println("Sorry kennel is full - cannot add team");
            return;
        }
        // we add in the position indexed by nextFreeLocation
        // This starts at zero
        animals.add(theAnimal);

        // now increment index ready for next one
        nextFreeLocation = nextFreeLocation + 1;
    }

    /**
     * Enables a user to delete a cat from the Kennel.
     *
     * @param who The cat to remove
     */
    public void removeAnimal(String who) {
        Animal which = null;
        // Search for the animal by name
        for (Animal a : animals) {
            if (who.equals(a.getAniName())) {
                which = a;
            }
        }
        if (which != null) {
            animals.remove(which); // Requires that Cat has an equals method
            System.out.println("removed " + who);
            nextFreeLocation = nextFreeLocation - 1;
        } else {
            System.err.println("cannot remove - not in kennel");
        }
    }

    /**
     * @return String showing all the information in the kennel
     */
    public String toString() {
        String results = "Data in Kennel " + kenName + " is: \n";
        for (Animal a : animals) {
            results = results + a.toString() + "\n";
        }
        return results;
    }

    /**
     * Returns an array of the inmates in the kennels
     *
     * @return An array of the correct size
     */
    public Animal[] obtainAllAnimals() {

        // ENTER CODE HERE
        // (POSSIBLY CHANGE SOME, YOU MAY CHANGE THE SIGNATURE TO DEAL
        // WITH ALL KINDS OF ANIMALS: CATS AND DOGS)
        // SEE Cat.getOriginalOwners METHOD FOR SIMILAR CODE

        Animal[] result = new Animal[animals.size()];
        result = animals.toArray(result);
        return result;
    }


    /**
     * Searches for and returns the inmate, if found
     *
     * @param name The name of the inmate
     * @return The inmate or else null if not found
     */
    public Animal search(String name) {

        // ENTER CODE HERE (POSSIBLY CHANGE SOME, YOU MAY CHANGE THE SIGNATURE TO DEAL
        // WITH ALL KINDS OF ANIMALS: CATS AND DOGS)
        Scanner input = new Scanner(System.in);
        System.out.println("Enter animal name: ");
        name = input.nextLine();

        for (Animal a : animals) {
            if (name.equals(a.getAniName())) {
                System.out.println(a.toString());
                return a;
            }
        }
        return null;
    }

    /**
     * Reads in Kennel information from the file
     *
     * @param infileName The file to read from
     * @throws FileNotFoundException    if file doesn't exist
     * @throws IOException              if some other IO error occurs
     * @throws IllegalArgumentException if infileName is null or empty
     */
    public void load(String infileName) throws IOException {
        // Using try-with-resource. We will cover this in Lecture 8, but
        // what it does is to automatically close the file after the try / catch ends.
        // This means we don't have to worry about closing the file.
        // But if you don't understand it now, don't worry about it.
        try (FileReader fr = new FileReader(infileName);
             BufferedReader br = new BufferedReader(fr);
             Scanner infile = new Scanner(br)) {

            // Use the delimiter pattern so that we don't have to clear end of line
            // characters after doing a nextInt or nextBoolean
            animals.clear();
            infile.useDelimiter("\r?\n|\r");

            kenName = infile.next();
            capacity = infile.nextInt();

            while (infile.hasNext()) {
                Animal a = null;
                String animalType = infile.next();
                switch (animalType.toLowerCase()) {
                    case "cat":
                        a = new Cat();
                        break;
                    case "dog":
                        a = new Dog();
                        break;
                }
                if (a != null) {
                    a.load(infile);
                    animals.add(a);
                }
            }
            infile.close();
        }
    }

    /**
     * Saves the kennel information
     *
     * @param filename The file to save to
     * @throws IOException If some IO error occurs
     */
    public void save(String filename) throws IOException {
        // Using try-with-resource. We will cover this in Lecture 8, but
        // what it does is to automatically close the file after the try / catch ends.
        // This means we don't have to worry about closing the file.
        // But if you don't understand it now, don't worry about it.
        try (FileWriter fw = new FileWriter(filename);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter outfile = new PrintWriter(bw);) {

            outfile.println(kenName);
            outfile.println(capacity);
            for (Animal a : animals) {
                a.save(outfile);
            }
        }
    }
}
