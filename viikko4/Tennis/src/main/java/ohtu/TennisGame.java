package ohtu;

public class TennisGame {
    private final static String[] scoreStrings = {"Love", "Fifteen", "Thirty", "Forty"};
    private final Player player1;
    private final Player player2;

    public TennisGame(String player1Name, String player2Name) {
        player1 = new Player(player1Name);
        player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName()))
            player1.incrementScore();
        else if (playerName.equals(player2.getName()))
            player2.incrementScore();
    }
    
    public String getTieScore(int score) {
        if (score < scoreStrings.length)
            return scoreStrings[score] + "-All";
        return "Deuce";
    }
    
    public String getAdvantage() {
        String leadingPlayer = player1.getScore() > player2.getScore()
            ? player1.getName()
            : player2.getName();
        
        int scoreDifference = Math.abs(player1.getScore() - player2.getScore());
        
        return scoreDifference == 1 ? "Advantage " + leadingPlayer : "Win for " + leadingPlayer;
    }
    

    public String getScore() {
        if (player1.getScore() == player2.getScore())
            return getTieScore(player1.getScore());
        
        if (player1.getScore() >= 4 || player2.getScore() >= 4)
            return getAdvantage();
        
        return scoreStrings[player1.getScore()] + "-" + scoreStrings[player2.getScore()];
    }
}