package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(orphanRemoval = true, mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

    @OneToMany(orphanRemoval = true, mappedBy = "role", cascade = CascadeType.ALL)
    private List<RolePermission> rolePermissions;

//    @ManyToMany(cascade = CascadeType.ALL)
//    private List<Permission> rolePermissions;


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

    public List<RolePermission> getRolePermissions() {
        return rolePermissions;
    }

    public void setRolePermissions(List<RolePermission> rolePermissions) {
        this.rolePermissions = rolePermissions;
    }

    public void setPermissions(List<Permission> permissions) {
        List<RolePermission> rolePermissions = new ArrayList<RolePermission>();
        for (Permission permission: permissions) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRole(this);
            rolePermission.setPermission(permission);
            rolePermissions.add(rolePermission);
        }

        this.rolePermissions = rolePermissions;
    }
}
