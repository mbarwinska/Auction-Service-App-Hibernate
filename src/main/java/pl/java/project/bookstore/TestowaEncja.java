package pl.java.project.bookstore;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TestowaEncja {

    protected TestowaEncja() {
    }

    ;

    @Id
    private int intigar;

    private byte aByte;
    private boolean aBoolean;
    private short aShort;
    private long aLong;
    private double aDouble;
    private float aFloat;
    private String aString;
    private DeliveryType deliveryType;
}
