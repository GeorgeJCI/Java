import java.io.PrintWriter;
import java.util.Scanner;

/**
 * child class of animal - class for the dogs
 * @author George C-I
 * @version 1 (17/03/2023)
 */
public class Dog extends Animal {
    private String foodKind;
    private boolean bones;
    private boolean needWalk;

    /**
     * Default constructor for Dog class
     */
    public Dog() {
        this("Unknown", 1, "Unknown", true, true);
    }

    /**
     * Constructor for Dog class
     *
     * @param aniName - name of the dog
     * @param meals   - how many meals a day
     * @param kind    - type of food required
     * @param bone    - likes bones or not
     * @param walk    - needs to be walked or not
     */
    public Dog(String aniName, int meals, String kind, boolean bone,
               boolean walk) {
        super(aniName, meals);
        foodKind = kind;
        bones = bone;
        needWalk = walk;
    }

    /**
     * the type of food the dog eats
     *
     * @return - the food
     */
    public String getFoodKind() {
        return foodKind;
    }

    /**
     * what kind of food does the dog eat?
     *
     * @param foodKind - enter food type
     */
    public void setFoodKind(String foodKind) {
        this.foodKind = foodKind;
    }

    /**
     * the dog likes bones or not
     *
     * @return - opinion on bones
     */
    public boolean isBones() {
        return bones;
    }

    /**
     * does the dog like bones?
     *
     * @param bones - dog like bones, true/false
     */
    public void setBones(boolean bones) {
        this.bones = bones;
    }

    /**
     * the dog needs a walk outside or not
     *
     * @return - exercise needs
     */
    public boolean isNeedWalk() {
        return needWalk;
    }

    /**
     * wheather or not the dog needs a walk?
     *
     * @param needWalk - dog needs exercise true/false?
     */
    public void setNeedWalk(boolean needWalk) {
        this.needWalk = needWalk;
    }

    /**
     * reads info from the file
     *
     * @param infile
     */
    @Override
    public void load(Scanner infile) {
        super.load(infile);
        foodKind = infile.nextLine();
        bones = infile.nextBoolean();
        needWalk = infile.nextBoolean();
    }

    /**
     * saves info onto the file
     *
     * @param pw
     */
    @Override
    public void save(PrintWriter pw) {
        super.save(pw);
        pw.println(foodKind);
        pw.println(bones);
        pw.println(needWalk);
    }

    @Override
    public String toString() {
        return super.toString() + "\nFood type: " + foodKind +
                "\nLikes bones: " + bones + "\nNeeds walking: " + needWalk + "\n";
    }

}
