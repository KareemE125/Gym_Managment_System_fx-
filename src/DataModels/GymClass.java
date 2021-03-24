package DataModels;
import java.io.Serializable;
import java.util.ArrayList;

public class GymClass implements Serializable {

    public String name;
    protected int trainerId=0;
    public int startHour, endHour;
    public  String day;
    public String classDescription;
    public int maxNumOfMembers;
    public ArrayList<Integer> newMembers = new ArrayList<Integer>();


    public GymClass(String name, String class_descrp, String day, int maxNumOfMembers, int startHour, int endHour){

        this.name=name;
        this.classDescription=class_descrp;
        this.startHour=startHour;
        this.endHour=endHour;
        this.maxNumOfMembers = maxNumOfMembers;
        this.day=day;

    }
    public static boolean checkClassIsPresent(String className){
        for (GymClass gc: getClasses()){
            if (gc.name.toLowerCase().equals(className.toLowerCase())){
                return true;
            }
        }
        return false;
    }
    public static ArrayList<GymClass> getClasses(){
        ArrayList<Object> objects = WriterReaderSingleton.getInstance().readAllMembersFromFile("src\\classes.txt");
        ArrayList<GymClass> classes = new ArrayList<GymClass>();

        for (Object object: objects){
            classes.add(((GymClass)object));
        }

        return classes;
    }
    public static ArrayList<GymClass> getOtherClasses(){
        ArrayList<GymClass> classes = getClasses();
        ArrayList<GymClass> otherClasses = new ArrayList<GymClass>();
        for (GymClass cl : classes){
            if (cl.name.toLowerCase().equals("gym") ||
                cl.name.toLowerCase().equals("zumba") ||
                cl.name.toLowerCase().equals("boxing")) continue;

            otherClasses.add(cl);
        }

        return otherClasses;
    }

    public static ArrayList<Object> getClassesAsObjects(ArrayList<GymClass> classes){
        ArrayList<Object> objects = new ArrayList<Object>();

        for (GymClass a: classes){
            objects.add((Object)a);
        }
        return objects;
    }

    public boolean checkAvailability(GymClass gymClass)
    {
        if(gymClass.newMembers.size() < gymClass.maxNumOfMembers)
            return true;
        else
            return false;
    }

}
