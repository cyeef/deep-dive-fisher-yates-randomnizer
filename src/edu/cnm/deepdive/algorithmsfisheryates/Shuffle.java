/*
 * Shuffle.java
 */
package edu.cnm.deepdive.algorithmsfisheryates;

import java.util.Arrays;
import java.util.Random;

/**
 * Utilizing Fisher-Yates shuffle of playing cards
 * 
 * @author cyeef
 *
 */
public class Shuffle {
  private static final String NO_INPUT_MESSAGE = "No size specified; using default value (%d).%n";
  private static final String BAD_INPUT_MESSAGE = "Could not parse \"%s\" as an int; using defalut value (%d).%n";
  private static final int DEFAULT_SIZE = 50;


  /**
   * Uses the Fisher-Yates shuffle algorithm <code><data/><code>
   * 
   * @param args command line arguments;
   */
  public static void main(String[] args) {
    int size = DEFAULT_SIZE;
    try {
      size = getSize(args);
    } catch (NumberFormatException ex) {
      System.out.printf(BAD_INPUT_MESSAGE, 
          args[0], DEFAULT_SIZE);
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.printf( NO_INPUT_MESSAGE,DEFAULT_SIZE);
    }
    int[] values = generate(size);
    System.out.println(Arrays.toString(values));
    shuffle(values);
    System.out.println(Arrays.toString(values));


  }

  private static int getSize(String[] args) 
     throws ArrayIndexOutOfBoundsException, NumberFormatException {
      return Integer.parseInt(args[0]);
  }

  private static int[] generate(int size) {
    int[] data = new int[size];
    for (int i = 0; i < data.length; i++) {
      data[i] = i + 1;
    }
    return data;
  }

  public static void shuffle(int[] data) {
    Random rng = new Random();
    for (int i = data.length - 1; i > 0; i--) {
      int source = rng.nextInt(i + 1);
      if (source != i) {
        int temp = data[i];
        data[i] = data[source];
        data[source] = temp;



      }
    }
  }
}
