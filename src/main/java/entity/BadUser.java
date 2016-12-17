package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity inheritance example
 */
@Entity
@DiscriminatorValue(value = "bad_user")
public class BadUser extends User {

    private String debt;

    public String getDebt() {
        return debt;
    }

    public void setDebt(String debt) {
        this.debt = debt;
    }
}
