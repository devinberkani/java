import java.util.*;

class Score implements Comparable<Score> {
    private final String player;
    private final int totalScore;

    public Score(String player, int totalScore) {
        this.player = player;
        this.totalScore = totalScore;
    }

    public String getPlayer() {
        return player;
    }

    public int getTotalScore() {
        return totalScore;
    }

    @Override
    public String toString() {
        return player + '=' + totalScore;
    }

    @Override
    public int compareTo(Score score) {
        int comparison = Integer.compare(this.getTotalScore(), score.getTotalScore());
        if (comparison == 0) {
            int playerOneLength = this.getPlayer().length();
            int playerTwoLength = score.getPlayer().length();
            int shorterPlayerLength = Math.min(playerOneLength, playerTwoLength);
            for (int i = 0; i < shorterPlayerLength; i++) {
                if (this.getPlayer().charAt(i) != score.getPlayer().charAt(i)) {
                    if (this.getPlayer().charAt(i) < score.getPlayer().charAt(i)) {
                        comparison = -1;
                        break;
                    } else {
                        comparison = 1;
                        break;
                    }
                }
            }
        }
        return comparison;
    }
}

// do not change the code below
class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Score> scores = new ArrayList<>();
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            Score score = new Score(input[0], Integer.parseInt(input[1]));
            scores.add(score);
        }

        Collections.sort(scores);
        System.out.println(scores);
    }
}