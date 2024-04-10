package main.lab7;

public class Main {
  public static void main(String[] args) {
    String[] filePaths = {
        "files/input1.txt",
        "files/input2.txt"
    };

    Thread[] threads = new Thread[filePaths.length];
    for (int i = 0; i < filePaths.length; i++) {
      String filePath = filePaths[i];
      threads[i] = new Thread(() -> RarestWordFinder.processFile(filePath));
      threads[i].start();
    }

    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        System.err.println("Thread interrupted: " + e.getMessage());
      }
    }

    String rarestWord = RarestWordFinder.findRarestWord();
    System.out.println("Rarest word: " + rarestWord);
  }
}
