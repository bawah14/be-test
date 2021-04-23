
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Bachtiar
 */
public class RoyalRumble {

    /**
     * @param args the command line arguments
     */
    RoyalRumble(){}
    
    RoyalRumble(String path) throws FileNotFoundException{
        List<String> list = new ArrayList<>();
        try (Scanner s = new Scanner(new File(path))) {
            while (s.hasNextLine()){
                list.add(s.nextLine());
            }
        }
        this.getSortedList(list);
    }
    
    public List<String> getSortedList(List<String> names){
        
//        sorting algoritm
        System.out.println(names);
        List<Royal> res = new ArrayList<>();
        List<String> result = new ArrayList<>();
        names.stream().map((temp) -> new Royal(temp)).forEach((royal) -> {
            res.add(royal);
        });
        res.sort(new sorter());
        for (Royal temp : res) {
            result.add(temp.getFullname());
        }
        System.out.println(result);
        return result;
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        RoyalRumble r= new RoyalRumble("resource/input1.txt");
    }
    
    
//    class to //object to representating royal 
    class Royal{
        String fullname;String name; String num;int number;
        Royal(String fullname){
            this.fullname = fullname;
            String[] temp = this.fullname.split(" ", 2);
            name = temp[0];
            num = temp[1]; 
            Converter c = new Converter();
            number = c.ConvertRoman(num);
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
    
//    implement class to help sorting algoritm
    class sorter implements Comparator<Royal>{

        @Override
        public int compare(Royal o1, Royal o2) {
            String x1 = ((Royal) o1).getName();
            String x2 = ((Royal) o2).getName();
            int sComp = x1.compareTo(x2);
            if (sComp != 0) {
               return sComp;
            } 
            Integer num1 = ((Royal) o1).getNumber();
            Integer num2 = ((Royal) o2).getNumber();
            return num1.compareTo(num2);
        }
        
    }
    
    
//    class to convret roman into int value
    class Converter {
        int value(char r)
        {
            if (r == 'I')
                return 1;
            if (r == 'V')
                return 5;
            if (r == 'X')
                return 10;
            if (r == 'L')
                return 50;
            if (r == 'C')
                return 100;
            if (r == 'D')
                return 500;
            if (r == 'M')
                return 1000;
            return -1;
        }

        // Finds decimal value of a
        // given romal numeral
        int ConvertRoman(String str)
        {
            // Initialize result
            int res = 0;

            for (int i = 0; i < str.length(); i++)
            {
                // Getting value of symbol s[i]
                int s1 = value(str.charAt(i));

                // Getting value of symbol s[i+1]
                if (i + 1 < str.length())
                {
                    int s2 = value(str.charAt(i + 1));

                    // Comparing both values
                    if (s1 >= s2)
                    {
                        // Value of current symbol
                        // is greater or equalto
                        // the next symbol
                        res = res + s1;
                    }
                    else
                    {
                        // Value of current symbol is
                        // less than the next symbol
                        res = res + s2 - s1;
                        i++;
                    }
                }
                else {
                    res = res + s1;
                }
            }

            return res;
        }
    }
}

