package PvZ.model.api.GameBoard;

import PvZ.model.api.Entity;

public interface GameBoardModel {
    int getRows();
    int getCols();
    Entity getEntityAt(int row, int col);
    void setEntityAt(int row, int col, Entity entity);
    void removeEntityAt(int row, int col);
}
