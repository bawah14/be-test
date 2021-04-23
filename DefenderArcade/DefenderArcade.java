import java.util.*;
import java.util.stream.Collectors;

public class DefenderArcade {

  public int countArcades(List<String> times) {
    int maxGames=0;

    List<String[]> splitBySpace=new ArrayList<>();
    for(String time:times) {
      splitBySpace.add(time.split(" "));
    }

    List<List<Integer>> timesList = stringToInteger(splitBySpace);

    timesList.sort(Comparator.comparingInt(o -> o.get(0)));

    PriorityQueue<List<Integer>> playingQueue=new PriorityQueue<>(Comparator.comparingInt(o -> o.get(1)));

    for(List<Integer> timeList:timesList) {
      while (!playingQueue.isEmpty() && playingQueue.peek().get(1)<timeList.get(0)) {
        playingQueue.poll();
      }
      playingQueue.add(timeList);
      maxGames=Math.max(maxGames, playingQueue.size());
    }
    return maxGames;
  }

  private List<List<Integer>> stringToInteger(List<String[]> newTimesList) {
    List<List<Integer>> timesList=new ArrayList<>();
    for(String[] arr:newTimesList){
      List<Integer> collect = Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
      timesList.add(collect);
    }
    return timesList;
  }
}
