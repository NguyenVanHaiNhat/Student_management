package model;

public interface ConsiderPassingScores {
    default boolean checkScore() {
        return false;
    }
}
