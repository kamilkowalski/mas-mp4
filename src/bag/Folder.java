package bag;

import java.util.HashSet;
import java.util.Set;

public class Folder {
    private String path;

    private Set<Permission> permissions = new HashSet<>();

    public Folder(String path) {
        setPath(path);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
