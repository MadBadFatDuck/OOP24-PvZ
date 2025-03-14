package PvZ.model.impl;


import PvZ.model.api.Bullet;
import PvZ.utilities.Position;

public class BulletImpl extends AbstractEntity implements Bullet{

    private final int DAMAGE=25;
    private Position pos;
    private boolean alive;

    BulletImpl(final Position pos) {
        this.pos = pos;
        this.alive = true;
    }

    public int getDamage() {
        return this.DAMAGE;
    }

    @Override
    public void update() {
        this.setPosition(this.pos); //THIS.POS + UNA CERTA POS CHE FA MOVE
        final Optional<Zombie> zombie = this.giveZombieHitted(); //DOVREBBE PRENDE COME ARGOMENTO NA LISTA DE ZOMBIE VIVI
        if(zombie.isPresent()) { 
            zombie.decreaseLife(this.DAMAGE);
            this.alive = false;
        }
    }

    
}
