package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class RarestWordFinder {
  private String res;

  RarestWordFinder(String res){
    this.res = res;
  }

  String findRarestWord(){
    Map<String, Integer> wordsFrequence = new TreeMap<>();
    ArrayList listOfStrings = splitBySpace(this.res);


    for(Object s : listOfStrings){
      wordsFrequence.put(String.valueOf(s), wordsFrequence.getOrDefault(s, 0)+1);
    }

    String maxFreqWord = "";
    int minCountWord = Integer.MAX_VALUE;
    for(Map.Entry<String, Integer> map : wordsFrequence.entrySet()){
      if(map.getValue() < minCountWord){
        minCountWord = map.getValue();
        maxFreqWord = map.getKey();
      }
    }
    return maxFreqWord;
  }

  private ArrayList<String> splitBySpace(String s){
    String[] resultListOfStrings = s.trim().split(" ");
    return new ArrayList<>(Arrays.asList(resultListOfStrings));
  }
}