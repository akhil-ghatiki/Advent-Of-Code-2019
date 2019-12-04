package day4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Password {

  public static void main(String[] args) {
    int count = 0;
    final int starter = 147981;
    final int ender = 691423;
    for (int i = starter; i <= ender; i++) {
      if (hasTwoAdjacentDigits(i) && hasIncreasingDigits(i) && hasTwoAdjacentDigitsWithSmalerGroup(
          i)) {
        count++;
      }
    }
    System.out.println(count);
  }

  private static boolean hasTwoAdjacentDigits(int number) {
    String numberString = Integer.toString(number);
    for (int i = 0; i <= numberString.length() - 2; i++) {
      if (numberString.charAt(i) == numberString.charAt(i + 1)) {
        return true;
      }
    }
    return false;
  }

  private static boolean hasTwoAdjacentDigitsWithSmalerGroup(int number) {
    List<Integer> repeatCount = new ArrayList<>();
    Set<Character> repeatSet = new HashSet<>();
    String numberString = Integer.toString(number);
    for (int i = 0; i <= numberString.length() - 2; i++) {
      if (numberString.charAt(i) == numberString.charAt(i + 1)) {
        repeatSet.add(numberString.charAt(i));
      }
    }
    for (char e : repeatSet) {
      int counter = getCount(e, numberString);
      repeatCount.add(counter);
    }
    if (repeatCount.contains(2)) {
      return true;
    }
    return false;
  }

  private static int getCount(char e, String target) {
    int count = 0;
    for (int i = 0; i < target.length(); i++) {
      if (e == target.charAt(i)) {
        count++;
      }
    }
    return count;
  }

  private static boolean hasIncreasingDigits(int number) {
    String numberString = Integer.toString(number);
    for (int i = 0; i < numberString.length() - 1; i++) {
      if ((int) numberString.charAt(i) > (int) numberString.charAt(i + 1)) {
        return false;
      }
    }
    return true;
  }
}
