package excercise1;

public class TennisGame {

    public static final String LOVE_ALL = "Love-All";
    public static final String FIFTEEN_ALL = "Fifteen-All";
    public static final String THIRTY_ALL = "Thirty-All";
    public static final String FORTY_ALL = "Forty-All";
    public static final String DEUCE = "Deuce";
    public static final int ZERO_POINT = 0;
    public static final int FIFTEEN_POINTS = 1;
    public static final int THIRTY_POINTS = 2;
    public static final int FORTY_POINTS = 3;
    public static final int SIXTY_POINTS = 4;
    public static final String ADVANTAGE_PLAYER_1 = "Advantage player1";
    public static final String ADVANTAGE_PLAYER_2 = "Advantage player2";
    public static final String WIN_FOR_PLAYER_1 = "Win for player1";
    public static final String WIN_FOR_PLAYER_2 = "Win for player2";
    public static final String INITIAL_SCORE = "";
    public static final String SCORE_ZERO = "Love";
    public static final String SCORE_FIFTEEN = "Fifteen";
    public static final String SCORE_THIRTY = "Thirty";
    public static final String SCORE_FORTY = "Forty";

    public static String getScore(String player1Name, String player2Name, int player1Score, int player2Score) {
        String score = INITIAL_SCORE;
        boolean isEqualScore = player1Score == player2Score;
        boolean isAdvantaging = player1Score >= SIXTY_POINTS || player2Score >= SIXTY_POINTS;

        if (isEqualScore) {
            score = getEqualScore(player1Score);
        } else if (isAdvantaging) {
            score = getAdvantageScore(player1Score, player2Score);
        } else {
            score = getScore(player1Score, player2Score, score);
        }
        return score;
    }

    private static String getScore(int player1Score, int player2Score, String score) {
        int tempScore;
        for (int i = 1; i < 3; i++) {
            boolean isPlayer1 = i == 1;
            if (isPlayer1) tempScore = player1Score;
            else {
                score += "-";
                tempScore = player2Score;
            }
            switch (tempScore) {
                case ZERO_POINT -> score += SCORE_ZERO;
                case FIFTEEN_POINTS -> score += SCORE_FIFTEEN;
                case THIRTY_POINTS -> score += SCORE_THIRTY;
                case FORTY_POINTS -> score += SCORE_FORTY;
            }
        }
        return score;
    }

    private static String getAdvantageScore(int player1Score, int player2Score) {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult == FIFTEEN_POINTS) score = ADVANTAGE_PLAYER_1;
        else if (minusResult == -FIFTEEN_POINTS) score = ADVANTAGE_PLAYER_2;
        else if (minusResult >= THIRTY_POINTS) score = WIN_FOR_PLAYER_1;
        else score = WIN_FOR_PLAYER_2;
        return score;
    }

    private static String getEqualScore(int twoPlayerScore) {
        return switch (twoPlayerScore) {
            case ZERO_POINT -> LOVE_ALL;
            case FIFTEEN_POINTS -> FIFTEEN_ALL;
            case THIRTY_POINTS -> THIRTY_ALL;
            case FORTY_POINTS -> FORTY_ALL;
            default -> DEUCE;
        };
    }
}