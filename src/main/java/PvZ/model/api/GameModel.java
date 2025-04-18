package PvZ.model.api;

import PvZ.utilities.Position;

public interface GameModel {
    void startGame();
    boolean isGameOver();
    boolean isVictory();
    GameStatus getGameStatus();
    void placePlant(PlantType type, Position position);
    void update(long deltaTime);
}
