package bag;

import java.util.HashSet;
import java.util.Set;

public class FilesystemUser {
    private String username;

    private Set<Permission> permissions = new HashSet<>();

    public FilesystemUser(String username) {
        setUsername(username);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void addPermission(Permission permission) {
        if (!permissions.contains(permission)) {
            permissions.add(permission);
        }
    }

    public void removePermission(Permission permission) {
        if (permissions.contains(permission)) {
            permissions.remove(permission);
        }
    }
}
