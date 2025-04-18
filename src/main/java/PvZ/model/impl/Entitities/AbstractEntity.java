package PvZ.model.impl.Entitities;

import PvZ.model.api.Collisions.HitBox;
import PvZ.model.api.Entities.Entity;
import PvZ.model.impl.Collisions.HitBoxFactory;
import PvZ.model.impl.Collisions.HitBoxFactory.HitBoxType;
import PvZ.utilities.Position;

public abstract class AbstractEntity implements Entity {

    private Position position;
    private HitBox hitBox;

    public AbstractEntity(Position position, HitBoxType hitBoxType) {
        this.position = position;
        this.hitBox = HitBoxFactory.createHitBox(position, hitBoxType);
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public HitBox getHitBox() {
        return hitBox;
    }
}
