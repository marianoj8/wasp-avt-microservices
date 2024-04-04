package com.wb.authservice.security.permission.services;

import com.wb.authservice.model.entity.ApplicationUser;
import com.wb.authservice.repository.ApplicationUserRepository;
import com.wb.authservice.security.permission.models.ApplicationUserPermission;
import com.wb.authservice.security.permission.models.CustomPermission;
import com.wb.authservice.security.permission.models.CustomRole;
import com.wb.authservice.security.permission.repos.ApplicationUserPermissionRepo;
import com.wb.authservice.security.permission.repos.PermissionRepo;
import com.wb.authservice.security.permission.repos.RoleRepo;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoleAndPermissionService {

    private final RoleRepo roleRepo;
    private final PermissionRepo permissionRepo;
    private final ApplicationUserRepository userRepo;
    private final ApplicationUserPermissionRepo userPermissionRepo;

    public CustomRole getRoleById(Long id) {
        return roleRepo.getReferenceById(id);
    }

    public CustomPermission getPermissionById(Long id) {
        return permissionRepo.getReferenceById(id);
    }

    public List<CustomRole> listAllRoles(String roleName) {
        return roleRepo.findAll(roleName);
    }

    public List<CustomPermission> listAllPermission(String permissionName) {
        return permissionRepo.findAll(permissionName);
    }

    public List<CustomPermission> listPermissionNames(String name) {
        return permissionRepo.findAll(name)
                .stream()
                .map(p -> new CustomPermission(p.getId(), p.getNome().split(":")[0]))
                .distinct()
                .toList();
    }

    public List<CustomPermission> listAllPermission(String nome, String username) {
        return userPermissionRepo.findAllByPermissionByUsername(nome, username)
                .stream()
                .map(ApplicationUserPermission::getPermissions)
                .toList();
    }

    public List<CustomPermission> listPermissionWithUser(String permission) {
        return userPermissionRepo.findAllByNameWithUserFormToken(permission)
                .stream()
                .map(ApplicationUserPermission::getPermissions)
                .toList();

        // .map((p) -> {
        // CustomPermission p1 = new CustomPermission();
        // p1.setId(p.getPermissions().getId());
        // p1.setCreatedAt(p.getPermissions().getCreatedAt());
        // p1.setModifiedAt(p.getPermissions().getModifiedAt());
        // p1.setTotalModified(p.getPermissions().getTotalModified());
        // p1.setNome(p.getPermissions().getNome());
        // p1.setEnabled(p.isEnabled());
        // return p1;
        // })
    }

    public CustomRole saveRole(CustomRole role) {
        return roleRepo.save(role);
    }

    public CustomPermission savePermission(CustomPermission permission) {
        return permissionRepo.save(permission);
    }

    @Transactional
    public boolean addRoleToUser(String username, String roleName) {
        ApplicationUser user = userRepo.findByUsername(username);
        CustomRole role = roleRepo.findByName(roleName);

        return user.getRoles().add(role);
    }

    @Transactional
    public boolean removeRoleFromUser(String username, String roleName) {
        ApplicationUser user = userRepo.findByUsername(username);
        CustomRole role = roleRepo.findByName(roleName);

        return user.getRoles().remove(role);
    }

    @Transactional
    public boolean addPermissionToUser(String username, String permissionName) {
        ApplicationUser user = userRepo.findByUsername(username);
        CustomPermission permission = permissionRepo.findByName(permissionName);

        if (user.getPermissions().contains(permission)) {
            log.info("Username {} already have this permission: {}", username, permission);
            throw new BadRequestException(
                    String.format("Username %s already have this permission: %s", username, permission.getNome()));
        }

        return user.getPermissions().add(permission);
    }

    @Transactional
    public boolean removePermissionFromUser(String username, String permissionName) {
        ApplicationUser user = userRepo.findByUsername(username);
        CustomPermission permission = permissionRepo.findByName(permissionName);

        return user.getPermissions().remove(permission);
    }

}
