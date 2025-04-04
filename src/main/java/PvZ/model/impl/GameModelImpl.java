package PvZ.model.impl;

import java.util.List;
import java.util.stream.Stream;

import PvZ.model.api.Entity;
import PvZ.model.api.GameModel;
import PvZ.model.api.Zombie;
public class GameModelImpl implements GameModel {
    private List<Entity> entities;
    private SunCounter sunCounter;
    
    @Override
    public void startGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startGame'");
    }

    @Override
    public void updateGame() {
        this.entities.forEach(Entity::update);
    }

    @Override
    public boolean isGameOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGameOver'");
    }

    @Override
    public boolean isVictory() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isVictory'");
    }

    @Override
    public void update(long deltaTime) {
        
    }

    public List<Entity> getEntityList() {
        return this.entities;
    }

    public SunCounter getSunCounter() {
        return this.sunCounter;
    }

    

}