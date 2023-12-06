package com.wasp.avt.authservice.security.permission;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.util.Set;

import static com.wasp.avt.authservice.security.permission.UserPermission.*;

@Getter
public enum UserRole {
        USER(Sets.newHashSet(PROFILE)),

        ADMIN(Sets.newHashSet(
                        ADMIN_READ,
                        ADMIN_CREATE,
                        ADMIN_UPDATE,
                        ADMIN_DELETE,

                        FUNCIONARIO_READ,
                        FUNCIONARIO_CREATE,
                        FUNCIONARIO_UPDATE,
                        FUNCIONARIO_DELETE,

                        PESSOA_CONTATO_READ,
                        PESSOA_CONTATO_CREATE,
                        PESSOA_CONTATO_UPDATE,
                        PESSOA_CONTATO_DELETE,

                        CLIENTE_READ,
                        CLIENTE_CREATE,
                        CLIENTE_UPDATE,
                        CLIENTE_DELETE,

                        CONSIGNATARIO_READ,
                        CONSIGNATARIO_CREATE,
                        CONSIGNATARIO_UPDATE,
                        CONSIGNATARIO_DELETE,

                        TELEFONE_READ,
                        TELEFONE_CREATE,
                        TELEFONE_UPDATE,
                        TELEFONE_DELETE,

                        EMAIL_READ,
                        EMAIL_CREATE,
                        EMAIL_UPDATE,
                        EMAIL_DELETE,

                        INFO_READ,
                        INFO_UPDATE,

                        USER_READ,
                        USER_CREATE,
                        USER_UPDATE,
                        USER_DELETE,
                        USER_READ_VIEW,
                        USER_SWITCH_VIEW,

                        AREA_TRABALHO_READ,
                        AREA_TRABALHO_CREATE,
                        AREA_TRABALHO_UPDATE,
                        AREA_TRABALHO_DELETE,

                        CLIENTE_CONFIG_READ,
                        CLIENTE_CONFIG_CREATE,
                        CLIENTE_CONFIG_UPDATE,
                        CLIENTE_CONFIG_DELETE,

                        GLOBAL_HONORARIO_READ,
                        GLOBAL_HONORARIO_CREATE,
                        GLOBAL_HONORARIO_UPDATE,
                        GLOBAL_HONORARIO_DELETE,

                        GLOBAL_CONFIG_READ,
                        GLOBAL_CONFIG_CREATE,
                        GLOBAL_CONFIG_UPDATE,
                        GLOBAL_CONFIG_DELETE,

                        BANCO_READ,
                        BANCO_CREATE,
                        BANCO_UPDATE,
                        BANCO_DELETE,

                        CATEGORIA_READ,
                        CATEGORIA_CREATE,
                        CATEGORIA_UPDATE,
                        CATEGORIA_DELETE,

                        DIREITOS_ADUANEIROS_READ,
                        DIREITOS_ADUANEIROS_CREATE,
                        DIREITOS_ADUANEIROS_UPDATE,
                        DIREITOS_ADUANEIROS_DELETE,

                        DPDA_READ,
                        DPDA_CREATE,
                        DPDA_UPDATE,
                        DPDA_DELETE,

                        DPFA_READ,
                        DPFA_CREATE,
                        DPFA_UPDATE,
                        DPFA_DELETE,

                        DPI_READ,
                        DPI_CREATE,
                        DPI_UPDATE,
                        DPI_DELETE,

                        DPM_READ,
                        DPM_CREATE,
                        DPM_UPDATE,
                        DPM_DELETE,

                        EXTENSAO_READ,
                        EXTENSAO_CREATE,
                        EXTENSAO_UPDATE,
                        EXTENSAO_DELETE,

                        FUNDOS_ADUANEIROS_READ,
                        FUNDOS_ADUANEIROS_CREATE,
                        FUNDOS_ADUANEIROS_UPDATE,
                        FUNDOS_ADUANEIROS_DELETE,

                        IMPOSICAO_READ,
                        IMPOSICAO_CREATE,
                        IMPOSICAO_UPDATE,
                        IMPOSICAO_DELETE,

                        INSTANCIA_ADUANEIRA_READ,
                        INSTANCIA_ADUANEIRA_CREATE,
                        INSTANCIA_ADUANEIRA_UPDATE,
                        INSTANCIA_ADUANEIRA_DELETE,

                        MERCADORIA_READ,
                        MERCADORIA_CREATE,
                        MERCADORIA_UPDATE,
                        MERCADORIA_DELETE,

                        MUNICIPIO_READ,
                        MUNICIPIO_CREATE,
                        MUNICIPIO_UPDATE,
                        MUNICIPIO_DELETE,

                        ORIGEM_PROCEDENCIA_READ,
                        ORIGEM_PROCEDENCIA_CREATE,
                        ORIGEM_PROCEDENCIA_UPDATE,
                        ORIGEM_PROCEDENCIA_DELETE,

                        PROCESSO_READ,
                        PROCESSO_CREATE,
                        PROCESSO_UPDATE,
                        PROCESSO_DELETE,

                        PROCESSO_DETALHE_READ,
                        PROCESSO_DETALHE_CREATE,
                        PROCESSO_DETALHE_UPDATE,
                        PROCESSO_DETALHE_DELETE,

                        PROVINCIA_READ,
                        PROVINCIA_CREATE,
                        PROVINCIA_UPDATE,
                        PROVINCIA_DELETE,

                        SERIAL_READ,
                        SERIAL_CREATE,
                        SERIAL_UPDATE,
                        SERIAL_DELETE,

                        TERMINAL_READ,
                        TERMINAL_CREATE,
                        TERMINAL_UPDATE,
                        TERMINAL_DELETE)),

        FUNCIONARIO(Sets.newHashSet(

                        PESSOA_CONTATO_READ,
                        PESSOA_CONTATO_UPDATE,

                        CLIENTE_READ,
                        CLIENTE_CREATE,
                        CLIENTE_UPDATE,

                        CONSIGNATARIO_READ,
                        CONSIGNATARIO_CREATE,
                        CONSIGNATARIO_UPDATE,
                        USER_READ,

                        CLIENTE_CONFIG_READ,

                        BANCO_READ,
                        USER_READ_VIEW,
                        CATEGORIA_READ,

                        DIREITOS_ADUANEIROS_READ,
                        DIREITOS_ADUANEIROS_UPDATE,

                        DPDA_READ,
                        DPDA_UPDATE,

                        DPI_READ,
                        DPI_UPDATE,

                        DPM_READ,
                        DPM_UPDATE,

                        IMPOSICAO_READ,
                        IMPOSICAO_UPDATE,

                        INSTANCIA_ADUANEIRA_READ,
                        INSTANCIA_ADUANEIRA_UPDATE,

                        MERCADORIA_READ,
                        MERCADORIA_UPDATE,

                        MUNICIPIO_READ,
                        MUNICIPIO_UPDATE,

                        ORIGEM_PROCEDENCIA_READ,
                        ORIGEM_PROCEDENCIA_UPDATE,

                        PROCESSO_READ,
                        PROCESSO_UPDATE,

                        PROCESSO_DETALHE_READ,
                        PROCESSO_DETALHE_UPDATE,

                        PROVINCIA_READ,

                        TERMINAL_READ,
                        TERMINAL_UPDATE)),

        CLIENTE(Sets.newHashSet(

                        FUNCIONARIO_READ,

                        PESSOA_CONTATO_READ,
                        PESSOA_CONTATO_UPDATE,

                        CLIENTE_READ,
                        CLIENTE_UPDATE,

                        CONSIGNATARIO_READ,
                        CONSIGNATARIO_UPDATE,

                        TELEFONE_READ,
                        TELEFONE_UPDATE,

                        EMAIL_READ,
                        EMAIL_UPDATE,

                        INFO_READ,
                        INFO_UPDATE,

                        USER_READ,
                        USER_UPDATE,

                        AREA_TRABALHO_READ,
                        AREA_TRABALHO_UPDATE,

                        CLIENTE_CONFIG_READ,
                        CLIENTE_CONFIG_UPDATE,

                        BANCO_READ,
                        BANCO_UPDATE,

                        CATEGORIA_READ,
                        CATEGORIA_UPDATE,

                        DIREITOS_ADUANEIROS_READ,
                        DIREITOS_ADUANEIROS_UPDATE,

                        DPDA_READ,
                        DPDA_UPDATE,

                        DPFA_READ,
                        DPFA_UPDATE,

                        DPI_READ,
                        DPI_UPDATE,

                        DPM_READ,
                        DPM_UPDATE,

                        EXTENSAO_READ,
                        EXTENSAO_UPDATE,

                        FUNDOS_ADUANEIROS_READ,
                        FUNDOS_ADUANEIROS_UPDATE,

                        IMPOSICAO_READ,
                        IMPOSICAO_UPDATE,

                        INSTANCIA_ADUANEIRA_READ,
                        INSTANCIA_ADUANEIRA_UPDATE,

                        MERCADORIA_READ,
                        MERCADORIA_UPDATE,

                        MUNICIPIO_READ,
                        MUNICIPIO_UPDATE,

                        ORIGEM_PROCEDENCIA_READ,
                        ORIGEM_PROCEDENCIA_UPDATE,

                        PROCESSO_READ,
                        PROCESSO_UPDATE,

                        PROCESSO_DETALHE_READ,
                        PROCESSO_DETALHE_UPDATE,

                        PROVINCIA_READ,
                        PROVINCIA_UPDATE,

                        SERIAL_READ,
                        SERIAL_UPDATE,

                        TERMINAL_READ,
                        TERMINAL_CREATE,
                        TERMINAL_UPDATE,
                        TERMINAL_DELETE)),

        ALL_PERMISSIONS(Sets.newHashSet(

                        PROFILE,

                        ROLE_GRANT,
                        ROLE_REVOKE,

                        PERMISSION_READ,
                        PERMISSION_GRANT,
                        PERMISSION_REVOKE,

                        ADMIN_READ,
                        ADMIN_CREATE,
                        ADMIN_UPDATE,
                        ADMIN_DELETE,

                        FUNCIONARIO_READ,
                        FUNCIONARIO_CREATE,
                        FUNCIONARIO_UPDATE,
                        FUNCIONARIO_DELETE,

                        PESSOA_CONTATO_READ,
                        PESSOA_CONTATO_CREATE,
                        PESSOA_CONTATO_UPDATE,
                        PESSOA_CONTATO_DELETE,

                        CLIENTE_READ,
                        CLIENTE_CREATE,
                        CLIENTE_UPDATE,
                        CLIENTE_DELETE,

                        CONSIGNATARIO_READ,
                        CONSIGNATARIO_CREATE,
                        CONSIGNATARIO_UPDATE,
                        CONSIGNATARIO_DELETE,

                        TELEFONE_READ,
                        TELEFONE_CREATE,
                        TELEFONE_UPDATE,
                        TELEFONE_DELETE,

                        EMAIL_READ,
                        EMAIL_CREATE,
                        EMAIL_UPDATE,
                        EMAIL_DELETE,

                        INFO_READ,
                        INFO_UPDATE,

                        USER_READ,
                        USER_CREATE,
                        USER_UPDATE,
                        USER_DELETE,
                        USER_READ_VIEW,
                        USER_SWITCH_VIEW,

                        AREA_TRABALHO_READ,
                        AREA_TRABALHO_CREATE,
                        AREA_TRABALHO_UPDATE,
                        AREA_TRABALHO_DELETE,

                        CLIENTE_CONFIG_READ,
                        CLIENTE_CONFIG_CREATE,
                        CLIENTE_CONFIG_UPDATE,
                        CLIENTE_CONFIG_DELETE,

                        GLOBAL_CONFIG_READ,
                        GLOBAL_CONFIG_CREATE,
                        GLOBAL_CONFIG_UPDATE,
                        GLOBAL_CONFIG_DELETE,

                        GLOBAL_HONORARIO_READ,
                        GLOBAL_HONORARIO_CREATE,
                        GLOBAL_HONORARIO_UPDATE,
                        GLOBAL_HONORARIO_DELETE,

                        BANCO_READ,
                        BANCO_CREATE,
                        BANCO_UPDATE,
                        BANCO_DELETE,

                        CATEGORIA_READ,
                        CATEGORIA_CREATE,
                        CATEGORIA_UPDATE,
                        CATEGORIA_DELETE,

                        DIREITOS_ADUANEIROS_READ,
                        DIREITOS_ADUANEIROS_CREATE,
                        DIREITOS_ADUANEIROS_UPDATE,
                        DIREITOS_ADUANEIROS_DELETE,

                        DPDA_READ,
                        DPDA_CREATE,
                        DPDA_UPDATE,
                        DPDA_DELETE,

                        DPFA_READ,
                        DPFA_CREATE,
                        DPFA_UPDATE,
                        DPFA_DELETE,

                        DPI_READ,
                        DPI_CREATE,
                        DPI_UPDATE,
                        DPI_DELETE,

                        DPM_READ,
                        DPM_CREATE,
                        DPM_UPDATE,
                        DPM_DELETE,

                        EXTENSAO_READ,
                        EXTENSAO_CREATE,
                        EXTENSAO_UPDATE,
                        EXTENSAO_DELETE,

                        FUNDOS_ADUANEIROS_READ,
                        FUNDOS_ADUANEIROS_CREATE,
                        FUNDOS_ADUANEIROS_UPDATE,
                        FUNDOS_ADUANEIROS_DELETE,

                        IMPOSICAO_READ,
                        IMPOSICAO_CREATE,
                        IMPOSICAO_UPDATE,
                        IMPOSICAO_DELETE,

                        INSTANCIA_ADUANEIRA_READ,
                        INSTANCIA_ADUANEIRA_CREATE,
                        INSTANCIA_ADUANEIRA_UPDATE,
                        INSTANCIA_ADUANEIRA_DELETE,

                        MERCADORIA_READ,
                        MERCADORIA_CREATE,
                        MERCADORIA_UPDATE,
                        MERCADORIA_DELETE,

                        MUNICIPIO_READ,
                        MUNICIPIO_CREATE,
                        MUNICIPIO_UPDATE,
                        MUNICIPIO_DELETE,

                        ORIGEM_PROCEDENCIA_READ,
                        ORIGEM_PROCEDENCIA_CREATE,
                        ORIGEM_PROCEDENCIA_UPDATE,
                        ORIGEM_PROCEDENCIA_DELETE,

                        PROCESSO_READ,
                        PROCESSO_CREATE,
                        PROCESSO_UPDATE,
                        PROCESSO_DELETE,

                        PROCESSO_DETALHE_READ,
                        PROCESSO_DETALHE_CREATE,
                        PROCESSO_DETALHE_UPDATE,
                        PROCESSO_DETALHE_DELETE,

                        PROVINCIA_READ,
                        PROVINCIA_CREATE,
                        PROVINCIA_UPDATE,
                        PROVINCIA_DELETE,

                        SERIAL_READ,
                        SERIAL_CREATE,
                        SERIAL_UPDATE,
                        SERIAL_DELETE,

                        TERMINAL_READ,
                        TERMINAL_CREATE,
                        TERMINAL_UPDATE,
                        TERMINAL_DELETE,

                        PEDIDO_READ,
                        PEDIDO_CREATE,
                        PEDIDO_UPDATE,
                        PEDIDO_DELETE

        ));

        private final Set<UserPermission> permissions;

        UserRole(Set<UserPermission> permissions) {
                this.permissions = permissions;
        }

}
