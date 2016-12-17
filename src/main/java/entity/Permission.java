package entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by vedmant on 12/17/16.
 */
@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(orphanRemoval = true, mappedBy = "permission", cascade = CascadeType.ALL)
    private List<RolePermission> roles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RolePermission> getRoles() {
        return roles;
    }

    public void setRoles(List<RolePermission> roles) {
        this.roles = roles;
    }
}
