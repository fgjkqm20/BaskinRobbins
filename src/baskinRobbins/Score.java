package baskinRobbins;

public class Score {
    private int win = 0;
    private int lose = 0;

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public void addWin() {
        win++;
    }

    public void addLose() {
        lose++;
    }
}
