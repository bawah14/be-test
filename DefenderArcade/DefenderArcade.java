import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bachtiar
 */
public class DefenderArcade {

    public DefenderArcade() {
         //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    
    
    
    public DefenderArcade(String path) throws FileNotFoundException {
        List<String> list = new ArrayList<>();
        try (Scanner s = new Scanner(new File(path))) {
            while (s.hasNextLine()){
                list.add(s.nextLine());
            }
        }
        countArcades(list);
    }

    public int countArcades(List<String> times) {
//        define and initiate first arcade machine
        int counter = 0;
        Arcade[] arcade = new Arcade['.'];
        arcade[counter] = new Arcade();
        counter ++;
        
//        start queue algorthm
        for (String object : times) {
            String[] exploded=object.split(" ");
            int start = Integer.parseInt(exploded[0]);
            int end = Integer.parseInt(exploded[1]);
            boolean stored=false;
            for (int i = 0; i < counter; i++) {
                if(arcade[i].checker(start,end)){
                    stored=true;
                    arcade[i].placequeue(start,end);
                }
            }
            if (!stored) {
                arcade[counter] = new Arcade();
                counter++;
            }
        }
        System.out.println(counter);
        return counter;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        DefenderArcade def = new DefenderArcade("resource/input1.txt");
        
    }

//object to representating arcade machine queue
    class Arcade{
        boolean[] time;
        Arcade(){
            time = new boolean[2400];
        }
        void placequeue(int start,int end){
            for (int i = start; i < end; i++) {
                this.time[i]=true;
            }
        }
        boolean checker(int start,int end){
            for (int i = start; i < end; i++) {
                if (this.time[i]) {
                    return false;
                }
            }
            return true;
        }
    }
    
}
