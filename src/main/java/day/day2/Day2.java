package day.day2;

import day.AdventHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day2 {
    private static final int WINNING = 6;
    private static final int DRAW = 3;
    private static final int LOSING = 0;
    public static final String PAPER = "PAPER";
    public static final String SCISSORS = "SCISSORS";
    public static final String ROCK = "ROCK";
    public static final String INVALID_SCENARIO = "Invalid scenario";

    public static void main(String[] args) {
        List<String> tournamentMatchUps = AdventHelper.readFile("src/main/resources/tournament.txt");

        // A is Rock, B is Paper, C is Scissors
        Map<String, String> opponent = new HashMap<>();
        opponent.put("A", ROCK);
        opponent.put("B", PAPER);
        opponent.put("C", SCISSORS);

        System.out.println("Part 1: " + part1(tournamentMatchUps, opponent));
        System.out.println("------------------");
        System.out.println("Part 2: " + part2(tournamentMatchUps, opponent));
    }

    private static int part2(List<String> tournamentMatchUps, Map<String, String> opponent) {
        Map<String, String> temp = new HashMap<>();
        temp.put("X", "LOSE");
        temp.put("Y", "DRAW");
        temp.put("Z", "WIN");
        int tournamentTotal = 0;
        for (String matchUp : tournamentMatchUps) {
            int roundTotal = 0;
            String[] splitMatch = matchUp.split(" ");
            String playerAnswer = temp.get(splitMatch[1]);
            RockPaperScissorEnum them = RockPaperScissorEnum.valueOf(opponent.get(splitMatch[0]));
            String opponentMove = them.name();

            String myUltimateMove = findUltimateMove(playerAnswer, opponentMove);
            RockPaperScissorEnum me = RockPaperScissorEnum.valueOf(myUltimateMove);

            tournamentTotal = getTournamentTotal(tournamentTotal, roundTotal, them, me);
        }
        return tournamentTotal;
    }

    private static String findUltimateMove(String playerAnswer, String opponentMove) {
        String myUltimateMove = null;
        switch (playerAnswer) {
            case "WIN" -> myUltimateMove = getMove(opponentMove, PAPER, ROCK, SCISSORS);
            case "DRAW" -> myUltimateMove = getMove(opponentMove, ROCK, SCISSORS, PAPER);
            case "LOSE" -> myUltimateMove = getMove(opponentMove, SCISSORS, PAPER, ROCK);
            default -> {
                System.out.println(INVALID_SCENARIO);
                System.exit(1);
            }
        }
        return myUltimateMove;
    }

    private static String getMove(String opponentMove, String case1, String case2, String case3) {
        String myUltimateMove = "";
        switch (opponentMove) {
            case ROCK -> myUltimateMove = case1;
            case SCISSORS -> myUltimateMove = case2;
            case PAPER -> myUltimateMove = case3;
            default -> {
                System.out.println(INVALID_SCENARIO);
                System.exit(1);
            }
        }
        return myUltimateMove;
    }

    private static int getTournamentTotal(int tournamentTotal, int roundTotal, RockPaperScissorEnum them, RockPaperScissorEnum me) {
        RockPaperScissorEnum.SCORE score = RockPaperScissorEnum.playGame(me, them);

        switch (score.name()) {
            case "WIN" -> roundTotal = RockPaperScissorEnum.valueOf(me.name()).getValue() + WINNING;
            case "LOSE" -> roundTotal = RockPaperScissorEnum.valueOf(me.name()).getValue() + LOSING;
            case "DRAW" -> roundTotal = RockPaperScissorEnum.valueOf(me.name()).getValue() + DRAW;
            default -> {
                System.out.println(INVALID_SCENARIO);
                System.exit(1);
            }
        }
        tournamentTotal += roundTotal;
        return tournamentTotal;
    }

    private static int part1(List<String> tournamentMatchUps, Map<String, String> opponent) {
        Map<String, String> myTeam = new HashMap<>();
        myTeam.put("X", ROCK);
        myTeam.put("Y", PAPER);
        myTeam.put("Z", SCISSORS);

        int tournamentTotal = 0;
        for (String matchUp : tournamentMatchUps) {
            int roundTotal = 0;
            String[] splitMatch = matchUp.split(" ");
            RockPaperScissorEnum them = RockPaperScissorEnum.valueOf(opponent.get(splitMatch[0]));
            RockPaperScissorEnum me = RockPaperScissorEnum.valueOf(myTeam.get(splitMatch[1]));

            tournamentTotal = getTournamentTotal(tournamentTotal, roundTotal, them, me);
        }
        return tournamentTotal;
    }
}
