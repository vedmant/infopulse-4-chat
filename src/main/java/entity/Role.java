package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(orphanRemoval = true, mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(orphanRemoval = true, mappedBy = "role", cascade = CascadeType.ALL)
    private List<RolePermission> permissions;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Permission> permissions;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<RolePermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<RolePermission> permissions) {
        this.permissions = permissions;
    }

}
