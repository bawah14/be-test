import java.util.*;

public class RoyalRumble {

  public List<String> getSortedList(List<String> names) {

    List<List<String>> nameSplitBySpace=new ArrayList<>();
    for(String name:names){
      nameSplitBySpace.add(Arrays.asList(name.split(" ")));
    }

    // Sort the list
    nameSplitBySpace.sort((o1, o2) -> {
      if(o1.get(0).equals(o2.get(0))){
        return toRoman(o1.get(1))-toRoman(o2.get(1));
      }else{
        return o1.get(0).compareTo(o2.get(0));
      }
    });

    return joinSortedList(nameSplitBySpace);
  }

  private int toRoman(String n) {
    if(n==null||n.length()==0){
      return -1;
    }
    HashMap<Character,Integer> map=new HashMap<>();
    map.put('I',1);
    map.put('V',5);
    map.put('X',10);
    map.put('L',50);
    int len=n.length(),result=map.get(n.charAt(len-1));
    for(int i=len-2;i>=0;i--){
      if(map.get(n.charAt(i))>=map.get(n.charAt(i+1)))
        result+=map.get(n.charAt(i));
      else
        result-=map.get(n.charAt(i));
    }

    return result;
  }

  private List<String> joinSortedList(List<List<String>> sortedList) {
    List<String> joinList=new ArrayList<>();
    for(List<String> newName:sortedList){
      joinList.add(String.join(" ", newName));
    }
    return joinList;
  }
}
