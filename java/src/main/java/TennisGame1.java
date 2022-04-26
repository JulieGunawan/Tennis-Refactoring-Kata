import java.util.Objects;

public class TennisGame1 implements TennisGame
{
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, "player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if (scoreIsEqual(m_score1, m_score2))
        {
            score = getPlayerScore();
        }
        else if (aPlayerIsAboutToWin())
        {
            score = isItPlayerOneorTwo();
        }
        else
        {
            score = orange(score);
        }
        return score;
    }

    private boolean scoreIsEqual(int m_score1, int m_score2) {
        return m_score1 == m_score2;
    }

    private boolean aPlayerIsAboutToWin() {
        return m_score1>=4 || m_score2>=4;
    }

    private String orange(String score) {
        int tempScore;
        StringBuilder scoreBuilder = new StringBuilder(score);
        for (int i = 1; i<3; i++)
        {
            if (scoreIsEqual(i, 1)) tempScore = m_score1;
            else { scoreBuilder.append("-"); tempScore = m_score2;}
            switch(tempScore)
            {
                case 0:
                    scoreBuilder.append("Love");
                    break;
                case 1:
                    scoreBuilder.append("Fifteen");
                    break;
                case 2:
                    scoreBuilder.append("Thirty");
                    break;
                case 3:
                    scoreBuilder.append("Forty");
                    break;
            }
        }
        score = scoreBuilder.toString();
        return score;
    }

    private String isItPlayerOneorTwo() {
        String score;
        int minusResult = m_score1-m_score2;
        if (scoreIsEqual(minusResult, 1)) score ="Advantage player1";
        else if (scoreIsEqual(minusResult, -1)) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private String getPlayerScore() {
        String score;
        switch (m_score1)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }
}
