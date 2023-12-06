package com.wasp.avt.authservice.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor()
@AllArgsConstructor()
@Builder
public class AuthenticatedUser {
    private String accessType;
    private List<String> roles;
    private List<String> permissions;
    private Long userId;
    private Long accountId;
    private String username;
    private Themes theme;
    private String nome;
    private String sobrenome;
    private String sexo;
    private String dataNascimento;
    private String email;
    private String fone;
    private String accessToken;
    private String refreshToken;
//    private AdminEntity admin;
//    private Funcionario funcionario;
//    private PessoaContato pessoaContato;

    public AuthenticatedUser(String nome, String sobrenome, String sexo, String email, String fone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.email = email;
        this.fone = fone;
    }

    public AuthenticatedUser(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
