package com.wb.authservice.security.permission;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.util.Set;

@Getter
public enum UserRole {
        USER(Sets.newHashSet(UserPermission.PROFILE)),

        ADMIN(Sets.newHashSet(
                        UserPermission.ADMIN_READ,
                        UserPermission.ADMIN_CREATE,
                        UserPermission.ADMIN_UPDATE,
                        UserPermission.ADMIN_DELETE,

                        UserPermission.FUNCIONARIO_READ,
                        UserPermission.FUNCIONARIO_CREATE,
                        UserPermission.FUNCIONARIO_UPDATE,
                        UserPermission.FUNCIONARIO_DELETE,

                        UserPermission.PESSOA_CONTATO_READ,
                        UserPermission.PESSOA_CONTATO_CREATE,
                        UserPermission.PESSOA_CONTATO_UPDATE,
                        UserPermission.PESSOA_CONTATO_DELETE,

                        UserPermission.CLIENTE_READ,
                        UserPermission.CLIENTE_CREATE,
                        UserPermission.CLIENTE_UPDATE,
                        UserPermission.CLIENTE_DELETE,

                        UserPermission.CONSIGNATARIO_READ,
                        UserPermission.CONSIGNATARIO_CREATE,
                        UserPermission.CONSIGNATARIO_UPDATE,
                        UserPermission.CONSIGNATARIO_DELETE,

                        UserPermission.TELEFONE_READ,
                        UserPermission.TELEFONE_CREATE,
                        UserPermission.TELEFONE_UPDATE,
                        UserPermission.TELEFONE_DELETE,

                        UserPermission.EMAIL_READ,
                        UserPermission.EMAIL_CREATE,
                        UserPermission.EMAIL_UPDATE,
                        UserPermission.EMAIL_DELETE,

                        UserPermission.INFO_READ,
                        UserPermission.INFO_UPDATE,

                        UserPermission.USER_READ,
                        UserPermission.USER_CREATE,
                        UserPermission.USER_UPDATE,
                        UserPermission.USER_DELETE,
                        UserPermission.USER_READ_VIEW,
                        UserPermission.USER_SWITCH_VIEW,

                        UserPermission.AREA_TRABALHO_READ,
                        UserPermission.AREA_TRABALHO_CREATE,
                        UserPermission.AREA_TRABALHO_UPDATE,
                        UserPermission.AREA_TRABALHO_DELETE,

                        UserPermission.CLIENTE_CONFIG_READ,
                        UserPermission.CLIENTE_CONFIG_CREATE,
                        UserPermission.CLIENTE_CONFIG_UPDATE,
                        UserPermission.CLIENTE_CONFIG_DELETE,

                        UserPermission.GLOBAL_HONORARIO_READ,
                        UserPermission.GLOBAL_HONORARIO_CREATE,
                        UserPermission.GLOBAL_HONORARIO_UPDATE,
                        UserPermission.GLOBAL_HONORARIO_DELETE,

                        UserPermission.GLOBAL_CONFIG_READ,
                        UserPermission.GLOBAL_CONFIG_CREATE,
                        UserPermission.GLOBAL_CONFIG_UPDATE,
                        UserPermission.GLOBAL_CONFIG_DELETE,

                        UserPermission.BANCO_READ,
                        UserPermission.BANCO_CREATE,
                        UserPermission.BANCO_UPDATE,
                        UserPermission.BANCO_DELETE,

                        UserPermission.CATEGORIA_READ,
                        UserPermission.CATEGORIA_CREATE,
                        UserPermission.CATEGORIA_UPDATE,
                        UserPermission.CATEGORIA_DELETE,

                        UserPermission.DIREITOS_ADUANEIROS_READ,
                        UserPermission.DIREITOS_ADUANEIROS_CREATE,
                        UserPermission.DIREITOS_ADUANEIROS_UPDATE,
                        UserPermission.DIREITOS_ADUANEIROS_DELETE,

                        UserPermission.DPDA_READ,
                        UserPermission.DPDA_CREATE,
                        UserPermission.DPDA_UPDATE,
                        UserPermission.DPDA_DELETE,

                        UserPermission.DPFA_READ,
                        UserPermission.DPFA_CREATE,
                        UserPermission.DPFA_UPDATE,
                        UserPermission.DPFA_DELETE,

                        UserPermission.DPI_READ,
                        UserPermission.DPI_CREATE,
                        UserPermission.DPI_UPDATE,
                        UserPermission.DPI_DELETE,

                        UserPermission.DPM_READ,
                        UserPermission.DPM_CREATE,
                        UserPermission.DPM_UPDATE,
                        UserPermission.DPM_DELETE,

                        UserPermission.EXTENSAO_READ,
                        UserPermission.EXTENSAO_CREATE,
                        UserPermission.EXTENSAO_UPDATE,
                        UserPermission.EXTENSAO_DELETE,

                        UserPermission.FUNDOS_ADUANEIROS_READ,
                        UserPermission.FUNDOS_ADUANEIROS_CREATE,
                        UserPermission.FUNDOS_ADUANEIROS_UPDATE,
                        UserPermission.FUNDOS_ADUANEIROS_DELETE,

                        UserPermission.IMPOSICAO_READ,
                        UserPermission.IMPOSICAO_CREATE,
                        UserPermission.IMPOSICAO_UPDATE,
                        UserPermission.IMPOSICAO_DELETE,

                        UserPermission.INSTANCIA_ADUANEIRA_READ,
                        UserPermission.INSTANCIA_ADUANEIRA_CREATE,
                        UserPermission.INSTANCIA_ADUANEIRA_UPDATE,
                        UserPermission.INSTANCIA_ADUANEIRA_DELETE,

                        UserPermission.MERCADORIA_READ,
                        UserPermission.MERCADORIA_CREATE,
                        UserPermission.MERCADORIA_UPDATE,
                        UserPermission.MERCADORIA_DELETE,

                        UserPermission.MUNICIPIO_READ,
                        UserPermission.MUNICIPIO_CREATE,
                        UserPermission.MUNICIPIO_UPDATE,
                        UserPermission.MUNICIPIO_DELETE,

                        UserPermission.ORIGEM_PROCEDENCIA_READ,
                        UserPermission.ORIGEM_PROCEDENCIA_CREATE,
                        UserPermission.ORIGEM_PROCEDENCIA_UPDATE,
                        UserPermission.ORIGEM_PROCEDENCIA_DELETE,

                        UserPermission.PROCESSO_READ,
                        UserPermission.PROCESSO_CREATE,
                        UserPermission.PROCESSO_UPDATE,
                        UserPermission.PROCESSO_DELETE,

                        UserPermission.PROCESSO_DETALHE_READ,
                        UserPermission.PROCESSO_DETALHE_CREATE,
                        UserPermission.PROCESSO_DETALHE_UPDATE,
                        UserPermission.PROCESSO_DETALHE_DELETE,

                        UserPermission.PROVINCIA_READ,
                        UserPermission.PROVINCIA_CREATE,
                        UserPermission.PROVINCIA_UPDATE,
                        UserPermission.PROVINCIA_DELETE,

                        UserPermission.SERIAL_READ,
                        UserPermission.SERIAL_CREATE,
                        UserPermission.SERIAL_UPDATE,
                        UserPermission.SERIAL_DELETE,

                        UserPermission.TERMINAL_READ,
                        UserPermission.TERMINAL_CREATE,
                        UserPermission.TERMINAL_UPDATE,
                        UserPermission.TERMINAL_DELETE)),

        FUNCIONARIO(Sets.newHashSet(

                        UserPermission.PESSOA_CONTATO_READ,
                        UserPermission.PESSOA_CONTATO_UPDATE,

                        UserPermission.CLIENTE_READ,
                        UserPermission.CLIENTE_CREATE,
                        UserPermission.CLIENTE_UPDATE,

                        UserPermission.CONSIGNATARIO_READ,
                        UserPermission.CONSIGNATARIO_CREATE,
                        UserPermission.CONSIGNATARIO_UPDATE,
                        UserPermission.USER_READ,

                        UserPermission.CLIENTE_CONFIG_READ,

                        UserPermission.BANCO_READ,
                        UserPermission.USER_READ_VIEW,
                        UserPermission.CATEGORIA_READ,

                        UserPermission.DIREITOS_ADUANEIROS_READ,
                        UserPermission.DIREITOS_ADUANEIROS_UPDATE,

                        UserPermission.DPDA_READ,
                        UserPermission.DPDA_UPDATE,

                        UserPermission.DPI_READ,
                        UserPermission.DPI_UPDATE,

                        UserPermission.DPM_READ,
                        UserPermission.DPM_UPDATE,

                        UserPermission.IMPOSICAO_READ,
                        UserPermission.IMPOSICAO_UPDATE,

                        UserPermission.INSTANCIA_ADUANEIRA_READ,
                        UserPermission.INSTANCIA_ADUANEIRA_UPDATE,

                        UserPermission.MERCADORIA_READ,
                        UserPermission.MERCADORIA_UPDATE,

                        UserPermission.MUNICIPIO_READ,
                        UserPermission.MUNICIPIO_UPDATE,

                        UserPermission.ORIGEM_PROCEDENCIA_READ,
                        UserPermission.ORIGEM_PROCEDENCIA_UPDATE,

                        UserPermission.PROCESSO_READ,
                        UserPermission.PROCESSO_UPDATE,

                        UserPermission.PROCESSO_DETALHE_READ,
                        UserPermission.PROCESSO_DETALHE_UPDATE,

                        UserPermission.PROVINCIA_READ,

                        UserPermission.TERMINAL_READ,
                        UserPermission.TERMINAL_UPDATE)),

        CLIENTE(Sets.newHashSet(

                        UserPermission.FUNCIONARIO_READ,

                        UserPermission.PESSOA_CONTATO_READ,
                        UserPermission.PESSOA_CONTATO_UPDATE,

                        UserPermission.CLIENTE_READ,
                        UserPermission.CLIENTE_UPDATE,

                        UserPermission.CONSIGNATARIO_READ,
                        UserPermission.CONSIGNATARIO_UPDATE,

                        UserPermission.TELEFONE_READ,
                        UserPermission.TELEFONE_UPDATE,

                        UserPermission.EMAIL_READ,
                        UserPermission.EMAIL_UPDATE,

                        UserPermission.INFO_READ,
                        UserPermission.INFO_UPDATE,

                        UserPermission.USER_READ,
                        UserPermission.USER_UPDATE,

                        UserPermission.AREA_TRABALHO_READ,
                        UserPermission.AREA_TRABALHO_UPDATE,

                        UserPermission.CLIENTE_CONFIG_READ,
                        UserPermission.CLIENTE_CONFIG_UPDATE,

                        UserPermission.BANCO_READ,
                        UserPermission.BANCO_UPDATE,

                        UserPermission.CATEGORIA_READ,
                        UserPermission.CATEGORIA_UPDATE,

                        UserPermission.DIREITOS_ADUANEIROS_READ,
                        UserPermission.DIREITOS_ADUANEIROS_UPDATE,

                        UserPermission.DPDA_READ,
                        UserPermission.DPDA_UPDATE,

                        UserPermission.DPFA_READ,
                        UserPermission.DPFA_UPDATE,

                        UserPermission.DPI_READ,
                        UserPermission.DPI_UPDATE,

                        UserPermission.DPM_READ,
                        UserPermission.DPM_UPDATE,

                        UserPermission.EXTENSAO_READ,
                        UserPermission.EXTENSAO_UPDATE,

                        UserPermission.FUNDOS_ADUANEIROS_READ,
                        UserPermission.FUNDOS_ADUANEIROS_UPDATE,

                        UserPermission.IMPOSICAO_READ,
                        UserPermission.IMPOSICAO_UPDATE,

                        UserPermission.INSTANCIA_ADUANEIRA_READ,
                        UserPermission.INSTANCIA_ADUANEIRA_UPDATE,

                        UserPermission.MERCADORIA_READ,
                        UserPermission.MERCADORIA_UPDATE,

                        UserPermission.MUNICIPIO_READ,
                        UserPermission.MUNICIPIO_UPDATE,

                        UserPermission.ORIGEM_PROCEDENCIA_READ,
                        UserPermission.ORIGEM_PROCEDENCIA_UPDATE,

                        UserPermission.PROCESSO_READ,
                        UserPermission.PROCESSO_UPDATE,

                        UserPermission.PROCESSO_DETALHE_READ,
                        UserPermission.PROCESSO_DETALHE_UPDATE,

                        UserPermission.PROVINCIA_READ,
                        UserPermission.PROVINCIA_UPDATE,

                        UserPermission.SERIAL_READ,
                        UserPermission.SERIAL_UPDATE,

                        UserPermission.TERMINAL_READ,
                        UserPermission.TERMINAL_CREATE,
                        UserPermission.TERMINAL_UPDATE,
                        UserPermission.TERMINAL_DELETE)),

        ALL_PERMISSIONS(Sets.newHashSet(

                        UserPermission.PROFILE,

                        UserPermission.ROLE_GRANT,
                        UserPermission.ROLE_REVOKE,

                        UserPermission.PERMISSION_READ,
                        UserPermission.PERMISSION_GRANT,
                        UserPermission.PERMISSION_REVOKE,

                        UserPermission.ADMIN_READ,
                        UserPermission.ADMIN_CREATE,
                        UserPermission.ADMIN_UPDATE,
                        UserPermission.ADMIN_DELETE,

                        UserPermission.FUNCIONARIO_READ,
                        UserPermission.FUNCIONARIO_CREATE,
                        UserPermission.FUNCIONARIO_UPDATE,
                        UserPermission.FUNCIONARIO_DELETE,

                        UserPermission.PESSOA_CONTATO_READ,
                        UserPermission.PESSOA_CONTATO_CREATE,
                        UserPermission.PESSOA_CONTATO_UPDATE,
                        UserPermission.PESSOA_CONTATO_DELETE,

                        UserPermission.CLIENTE_READ,
                        UserPermission.CLIENTE_CREATE,
                        UserPermission.CLIENTE_UPDATE,
                        UserPermission.CLIENTE_DELETE,

                        UserPermission.CONSIGNATARIO_READ,
                        UserPermission.CONSIGNATARIO_CREATE,
                        UserPermission.CONSIGNATARIO_UPDATE,
                        UserPermission.CONSIGNATARIO_DELETE,

                        UserPermission.TELEFONE_READ,
                        UserPermission.TELEFONE_CREATE,
                        UserPermission.TELEFONE_UPDATE,
                        UserPermission.TELEFONE_DELETE,

                        UserPermission.EMAIL_READ,
                        UserPermission.EMAIL_CREATE,
                        UserPermission.EMAIL_UPDATE,
                        UserPermission.EMAIL_DELETE,

                        UserPermission.INFO_READ,
                        UserPermission.INFO_UPDATE,

                        UserPermission.USER_READ,
                        UserPermission.USER_CREATE,
                        UserPermission.USER_UPDATE,
                        UserPermission.USER_DELETE,
                        UserPermission.USER_READ_VIEW,
                        UserPermission.USER_SWITCH_VIEW,

                        UserPermission.AREA_TRABALHO_READ,
                        UserPermission.AREA_TRABALHO_CREATE,
                        UserPermission.AREA_TRABALHO_UPDATE,
                        UserPermission.AREA_TRABALHO_DELETE,

                        UserPermission.CLIENTE_CONFIG_READ,
                        UserPermission.CLIENTE_CONFIG_CREATE,
                        UserPermission.CLIENTE_CONFIG_UPDATE,
                        UserPermission.CLIENTE_CONFIG_DELETE,

                        UserPermission.GLOBAL_CONFIG_READ,
                        UserPermission.GLOBAL_CONFIG_CREATE,
                        UserPermission.GLOBAL_CONFIG_UPDATE,
                        UserPermission.GLOBAL_CONFIG_DELETE,

                        UserPermission.GLOBAL_HONORARIO_READ,
                        UserPermission.GLOBAL_HONORARIO_CREATE,
                        UserPermission.GLOBAL_HONORARIO_UPDATE,
                        UserPermission.GLOBAL_HONORARIO_DELETE,

                        UserPermission.BANCO_READ,
                        UserPermission.BANCO_CREATE,
                        UserPermission.BANCO_UPDATE,
                        UserPermission.BANCO_DELETE,

                        UserPermission.CATEGORIA_READ,
                        UserPermission.CATEGORIA_CREATE,
                        UserPermission.CATEGORIA_UPDATE,
                        UserPermission.CATEGORIA_DELETE,

                        UserPermission.DIREITOS_ADUANEIROS_READ,
                        UserPermission.DIREITOS_ADUANEIROS_CREATE,
                        UserPermission.DIREITOS_ADUANEIROS_UPDATE,
                        UserPermission.DIREITOS_ADUANEIROS_DELETE,

                        UserPermission.DPDA_READ,
                        UserPermission.DPDA_CREATE,
                        UserPermission.DPDA_UPDATE,
                        UserPermission.DPDA_DELETE,

                        UserPermission.DPFA_READ,
                        UserPermission.DPFA_CREATE,
                        UserPermission.DPFA_UPDATE,
                        UserPermission.DPFA_DELETE,

                        UserPermission.DPI_READ,
                        UserPermission.DPI_CREATE,
                        UserPermission.DPI_UPDATE,
                        UserPermission.DPI_DELETE,

                        UserPermission.DPM_READ,
                        UserPermission.DPM_CREATE,
                        UserPermission.DPM_UPDATE,
                        UserPermission.DPM_DELETE,

                        UserPermission.EXTENSAO_READ,
                        UserPermission.EXTENSAO_CREATE,
                        UserPermission.EXTENSAO_UPDATE,
                        UserPermission.EXTENSAO_DELETE,

                        UserPermission.FUNDOS_ADUANEIROS_READ,
                        UserPermission.FUNDOS_ADUANEIROS_CREATE,
                        UserPermission.FUNDOS_ADUANEIROS_UPDATE,
                        UserPermission.FUNDOS_ADUANEIROS_DELETE,

                        UserPermission.IMPOSICAO_READ,
                        UserPermission.IMPOSICAO_CREATE,
                        UserPermission.IMPOSICAO_UPDATE,
                        UserPermission.IMPOSICAO_DELETE,

                        UserPermission.INSTANCIA_ADUANEIRA_READ,
                        UserPermission.INSTANCIA_ADUANEIRA_CREATE,
                        UserPermission.INSTANCIA_ADUANEIRA_UPDATE,
                        UserPermission.INSTANCIA_ADUANEIRA_DELETE,

                        UserPermission.MERCADORIA_READ,
                        UserPermission.MERCADORIA_CREATE,
                        UserPermission.MERCADORIA_UPDATE,
                        UserPermission.MERCADORIA_DELETE,

                        UserPermission.MUNICIPIO_READ,
                        UserPermission.MUNICIPIO_CREATE,
                        UserPermission.MUNICIPIO_UPDATE,
                        UserPermission.MUNICIPIO_DELETE,

                        UserPermission.ORIGEM_PROCEDENCIA_READ,
                        UserPermission.ORIGEM_PROCEDENCIA_CREATE,
                        UserPermission.ORIGEM_PROCEDENCIA_UPDATE,
                        UserPermission.ORIGEM_PROCEDENCIA_DELETE,

                        UserPermission.PROCESSO_READ,
                        UserPermission.PROCESSO_CREATE,
                        UserPermission.PROCESSO_UPDATE,
                        UserPermission.PROCESSO_DELETE,

                        UserPermission.PROCESSO_DETALHE_READ,
                        UserPermission.PROCESSO_DETALHE_CREATE,
                        UserPermission.PROCESSO_DETALHE_UPDATE,
                        UserPermission.PROCESSO_DETALHE_DELETE,

                        UserPermission.PROVINCIA_READ,
                        UserPermission.PROVINCIA_CREATE,
                        UserPermission.PROVINCIA_UPDATE,
                        UserPermission.PROVINCIA_DELETE,

                        UserPermission.SERIAL_READ,
                        UserPermission.SERIAL_CREATE,
                        UserPermission.SERIAL_UPDATE,
                        UserPermission.SERIAL_DELETE,

                        UserPermission.TERMINAL_READ,
                        UserPermission.TERMINAL_CREATE,
                        UserPermission.TERMINAL_UPDATE,
                        UserPermission.TERMINAL_DELETE,

                        UserPermission.PEDIDO_READ,
                        UserPermission.PEDIDO_CREATE,
                        UserPermission.PEDIDO_UPDATE,
                        UserPermission.PEDIDO_DELETE

        ));

        private final Set<UserPermission> permissions;

        UserRole(Set<UserPermission> permissions) {
                this.permissions = permissions;
        }

}
