package PvZ.model.impl;
import PvZ.model.api.*;
import PvZ.model.api.Entities.EntitiesManager;
import PvZ.model.api.Plants.PlantType;
import PvZ.model.api.Plants.Plant;
import PvZ.model.impl.Entitities.EntitiesManagerImpl;
import PvZ.model.impl.Plants.PlantFactory;
import PvZ.utilities.Position;

import java.util.*;

public class GameModelImpl implements GameModel {
    EntitiesManager entitiesManager;
    PlantFactory plantFactory;

    private static final int ROWS = 5;
    private static final int COLS = 9;

    private final List<List<Cell>> grid;

    private GameStatus status;

    private long lastSunTime;
    private long lastZombieSpawnTime;

    public GameModelImpl() {
        this.entitiesManager = new EntitiesManagerImpl();
        this.plantFactory = new PlantFactory();

        this.grid = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            List<Cell> row = new ArrayList<>();
            for (int j = 0; j < COLS; j++) {
                row.add(new Cell());
            }
            grid.add(row);
        }
        this.status = GameStatus.IN_PROGRESS;
        this.lastSunTime = System.currentTimeMillis();
        this.lastZombieSpawnTime = System.currentTimeMillis();
    }

    @Override
    public void startGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startGame'");
    }

    @Override
    public boolean isGameOver() {
            return status != GameStatus.IN_PROGRESS;
    }

    @Override
    public boolean isVictory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isVictory'");
    }

    @Override
    public GameStatus getGameStatus() {
        return status;
    }


    @Override
    public void update(long deltaTime) {
        this.entitiesManager.getEntities().forEach(e->e.update(deltaTime, entitiesManager));
    }

    @Override
    public void placePlant(PlantType type, Position position) {
        Plant plant = switch (type) {
            case PEASHOOTER -> plantFactory.createPeashooter(position);
            case SUNFLOWER -> plantFactory.createSunflower(position);
            case WALLNUT -> plantFactory.createWallnut(position);
            default -> throw new IllegalArgumentException("Invalid plant type: " + type);
        };

        if(plant!=null){
            entitiesManager.addEntity(plant);
        }

    }
    
    

}