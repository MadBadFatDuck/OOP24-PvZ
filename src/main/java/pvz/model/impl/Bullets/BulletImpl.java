package pvz.model.impl.Bullets;

import java.math.BigDecimal;
import java.util.Optional;

import pvz.utilities.Position;
import pvz.model.api.Zombie;
import pvz.model.api.Bullets.Bullet;
import pvz.model.api.Collisions.CollisionManager;
import pvz.model.api.entities.EntitiesManager;
import pvz.model.impl.Collisions.CollisionManagerImpl;
import pvz.model.impl.Collisions.HitBoxFactory.HitBoxType;
import pvz.model.impl.entities.AbstractEntity;

/**
 * Implementation of the {@link Bullet} interface representing a bullet entity in the game.
 */
public final class BulletImpl extends AbstractEntity implements Bullet {

    private final CollisionManager collisionManager;
    private static final double SPEED = 0.003;
    private static final int DAMAGE = 25;

    /**
     * Constructs a new BulletImpl at the given position.
     *
     * @param pos the initial position of the bullet
     */
    public BulletImpl(final Position pos) {
        super(pos, HitBoxType.BULLET);
        this.collisionManager = new CollisionManagerImpl();
    }

    /**
     * Updates the bullet's position and checks for collisions with zombies.
     * If a collision is detected, the bullet attacks the zombie and removes itself from the entities manager.
     *
     * @param deltaTime the time elapsed since the last update
     * @param entitiesManager the manager containing all entities in the game
     */
    @Override
    public void update(final long deltaTime, final EntitiesManager entitiesManager) {
        this.setPosition(this.move(deltaTime));
        this.getHitBox().update(this.getPosition());
        Optional<Zombie> zombie = this.collisionManager.handleCollision(this, entitiesManager).map(entity -> (Zombie) entity);
        if (zombie.isPresent()) {
            this.attackZombie(zombie.get(), entitiesManager);
            entitiesManager.removeEntity(this);
        }
    }

    /**
     * Attacks the given zombie, dealing damage and removing it if it dies.
     *
     * @param zombie the zombie to attack
     * @param entitiesManager the manager containing all entities in the game
     */
    private void attackZombie(final Zombie zombie, final EntitiesManager entitiesManager) {
        zombie.takeDamage(this.getDamage());
        if (!zombie.isAlive()) {
            entitiesManager.removeEntity(zombie);
            entitiesManager.addKill();
        }
    }

    /**
     * Moves the bullet based on its speed and the elapsed time.
     *
     * @param time the elapsed time
     * @return the new position of the bullet
     */
    private Position move(final long time) {
        final BigDecimal move = BigDecimal.valueOf(SPEED).multiply(BigDecimal.valueOf(time));
        final BigDecimal newX = move.add(BigDecimal.valueOf(this.getPosition().x()));
        return new Position(newX.doubleValue(), this.getPosition().y());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDamage() {
        return DAMAGE;
    }
}
