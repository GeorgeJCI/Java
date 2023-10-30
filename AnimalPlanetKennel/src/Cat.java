import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * To support an individual cat
 *
 * @author Chris Loftus and Faisal Rezwan and George C-I
 * @version 3 (20th February 2023)
 */
public class Cat extends Animal {

    private boolean canShare;
    private String favFood;

    /**
     * Default constructor
     */
    public Cat() {
        this("unknown", false, "unknown", 1);
    }

    /**
     * Constructor for the cat
     *
     * @param name        The cat's name
     * @param food        The kind of food it eats
     * @param mealsPerDay Number of feeds per day
     * @param share       Is true if the cat can share a run with other cats, otherwise false
     */
    public Cat(String name, boolean share, String food, int mealsPerDay) {
        super(name, mealsPerDay);
        canShare = share;
        favFood = food;
    }

    /**
     * Does the cat like to share a walk with other cats?
     *
     * @return true if it does
     */
    public boolean getCanShare() {
        return canShare;
    }

    /**
     * @param canShare sets true if cat can share
     */
    public void setCanShare(boolean canShare) {
        this.canShare = canShare;
    }

    /**
     * The food the cat likes to eat
     *
     * @return The food
     */
    public String getFavouriteFood() {
        return favFood;
    }

    /**
     * What's his favourite food?
     *
     * @param food The food it likes
     */
    public void setFavouriteFood(String food) {
        favFood = food;
    }

    /**
     * Reads in information about the cat from the file
     */
    @Override
    public void load(Scanner infile) {
        super.load(infile);
        canShare = infile.nextBoolean();
        favFood = infile.next();
    }

    @Override
    public void save(PrintWriter pw) {
        super.save(pw);
        pw.println(canShare);
        pw.println(favFood);
    }

    /**
     * A basic implementation to just return all the data in string form
     */
    @Override
    public String toString() {
        return super.toString() + "\n"
                + "Can share pen: " + canShare + "\nFav food: " + favFood + "\n";
    }

}
