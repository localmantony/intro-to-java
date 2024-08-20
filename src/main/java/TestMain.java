import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestMain {

public static void main(String[] args) {
  List<ArrayList<Enemy>> currentEnemies = initializeEnemies(150);
  int cumulativeDif = 0;
  for (ArrayList<Enemy> list : currentEnemies) {
    for (Enemy enemy : list) {
      System.out.println("Name: " + enemy.getName());
      System.out.println("Difficulty: " + enemy.getDifficulty() + "\n");
      cumulativeDif += enemy.getDifficulty();
    }
  }
  System.out.println("Total Difficulty: " + cumulativeDif);
}
  
  public static List<ArrayList<Enemy>> initializeEnemies(int difficulty) {
    Random random = new Random();
    
    List<ArrayList<Enemy>> enemyList = new ArrayList<>();
    
    for (int i = 0; i < 3; i++) {
        enemyList.add(new ArrayList<>());
    }
    
    int difTotal = difficulty;
    
    while (difTotal > 0) {
      switch (random.nextInt(3)) {
        case 0:
          if (difTotal >= 25) {
            Minion minion = new Minion("Minion " + (enemyList.get(0).size() + 1));
            enemyList.get(0).add(minion);
            difTotal -= minion.getDifficulty();
            break;
          } else {
            difTotal = 0;
            break;
          }

        case 1:
          if (difTotal >= 50) {
            Striker striker = new Striker("Striker " + (enemyList.get(1).size() + 1));
            enemyList.get(1).add(striker);
            difTotal -= striker.getDifficulty();
            break;
          } else {
            break;
          }

        case 2:
          if (difTotal >= 75) {
            Warden warden = new Warden("Warden " + (enemyList.get(2).size() + 1));
            enemyList.get(2).add(warden);
            difTotal -= warden.getDifficulty();
            break;
          } else {
            break;
          }
      }
    }
    return enemyList;
  }
}