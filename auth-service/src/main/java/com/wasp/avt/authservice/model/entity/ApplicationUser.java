package com.wasp.avt.authservice.model.entity;

import com.wasp.avt.authservice.security.permission.models.CustomPermission;
import com.wasp.avt.authservice.security.permission.models.CustomRole;
import com.wasp.avt.authservice.util.Themes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime createdAt;
    @Column(columnDefinition = "timestamp")
    private LocalDateTime lastModifiedAt;
    private int totalModified = 0;
    @NotEmpty(message = "The field 'username' cannot be empty")
    @Column(nullable = false, unique = true)
    private String username;
    @ToString.Exclude
    private String password;
    @Column(columnDefinition = "Text")
    private String accessToken;
    @Column(columnDefinition = "Text")
    private String refreshToken;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<CustomRole> roles = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<CustomPermission> permissions = new ArrayList<>();
    private Themes theme;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;

//    @ManyToOne(targetEntity = AdminEntity.class)
//    private AdminEntity adminEntity;
//    @ManyToOne(targetEntity = Funcionario.class)
//    private Funcionario funcionario;
//    @ManyToOne(targetEntity = PessoaContato.class)
//    private PessoaContato pessoaContato;
//
//    @ManyToOne(targetEntity = AreaTrabalho.class)
//    private AreaTrabalho areaTrabalho;
}
