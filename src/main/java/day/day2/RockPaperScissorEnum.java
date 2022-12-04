package day.day2;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum RockPaperScissorEnum {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int value;

    @Getter
    @AllArgsConstructor
    enum SCORE {
        WIN(6),
        LOSE(0),
        DRAW(3);
        private final int value;
    }

    private static final Map<RockPaperScissorEnum, List<RockPaperScissorEnum>> beats = new HashMap<>();

    static {
        beats.put(ROCK, List.of(SCISSORS));
        beats.put(PAPER, List.of(ROCK));
        beats.put(SCISSORS, List.of(PAPER));
    }
    public static SCORE playGame(RockPaperScissorEnum player, RockPaperScissorEnum opponent) {
        if (player == opponent) {
            return SCORE.DRAW;
        } else if (beats.get(player).contains(opponent)) {
            return SCORE.WIN;
        } else {
            return SCORE.LOSE;
        }
    }
}
