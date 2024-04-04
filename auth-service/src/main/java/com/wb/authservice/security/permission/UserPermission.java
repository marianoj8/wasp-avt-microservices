package com.wb.authservice.security.permission;

public enum UserPermission {

    PROFILE("profile:read"),

    ROLE_GRANT("role:grant"),
    ROLE_REVOKE("role:revoke"),

    PERMISSION_READ("permission:read"),
    PERMISSION_GRANT("permission:grant"),
    PERMISSION_REVOKE("permission:revoke"),

    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:create"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),

    FUNCIONARIO_READ("funcionario:read"),
    FUNCIONARIO_CREATE("funcionario:create"),
    FUNCIONARIO_UPDATE("funcionario:update"),
    FUNCIONARIO_DELETE("funcionario:delete"),

    PESSOA_CONTATO_READ("pessoa_contato:read"),
    PESSOA_CONTATO_CREATE("pessoa_contato:create"),
    PESSOA_CONTATO_UPDATE("pessoa_contato:update"),
    PESSOA_CONTATO_DELETE("pessoa_contato:delete"),

    CLIENTE_READ("cliente:read"),
    CLIENTE_CREATE("cliente:create"),
    CLIENTE_UPDATE("cliente:update"),
    CLIENTE_DELETE("cliente:delete"),

    CONSIGNATARIO_READ("consignatario:read"),
    CONSIGNATARIO_CREATE("consignatario:create"),
    CONSIGNATARIO_UPDATE("consignatario:update"),
    CONSIGNATARIO_DELETE("consignatario:delete"),

    TELEFONE_READ("telefone:read"),
    TELEFONE_CREATE("telefone:create"),
    TELEFONE_UPDATE("telefone:update"),
    TELEFONE_DELETE("telefone:delete"),

    EMAIL_READ("email:read"),
    EMAIL_CREATE("email:create"),
    EMAIL_UPDATE("email:update"),
    EMAIL_DELETE("email:delete"),

    INFO_READ("info:read"),
    INFO_UPDATE("info:update"),

    USER_READ("user:read"),
    USER_CREATE("user:create"),
    USER_UPDATE("user:update"),
    USER_DELETE("user:delete"),
    USER_READ_VIEW("user:read-view"),
    USER_SWITCH_VIEW("user:switch-view"),

    AREA_TRABALHO_READ("area_trabalho:read"),
    AREA_TRABALHO_CREATE("area_trabalho:create"),
    AREA_TRABALHO_UPDATE("area_trabalho:update"),
    AREA_TRABALHO_DELETE("area_trabalho:delete"),

    CLIENTE_CONFIG_READ("cliente_config:read"),
    CLIENTE_CONFIG_CREATE("cliente_config:create"),
    CLIENTE_CONFIG_UPDATE("cliente_config:update"),
    CLIENTE_CONFIG_DELETE("cliente_config:delete"),

    GLOBAL_HONORARIO_READ("global_honorario:read"),
    GLOBAL_HONORARIO_CREATE("global_honorario:create"),
    GLOBAL_HONORARIO_UPDATE("global_honorario:update"),
    GLOBAL_HONORARIO_DELETE("global_honorario:delete"),
    
    GLOBAL_CONFIG_READ("global_config:read"),
    GLOBAL_CONFIG_CREATE("global_config:create"),
    GLOBAL_CONFIG_UPDATE("global_config:update"),
    GLOBAL_CONFIG_DELETE("global_config:delete"),

    BANCO_READ("banco:read"),
    BANCO_CREATE("banco:create"),
    BANCO_UPDATE("banco:update"),
    BANCO_DELETE("banco:delete"),

    CAMBIO_READ("cambio:read"),
    CAMBIO_CREATE("cambio:create"),
    CAMBIO_UPDATE("cambio:update"),
    CAMBIO_DELETE("cambio:delete"),

    CATEGORIA_READ("categoria:read"),
    CATEGORIA_CREATE("categoria:create"),
    CATEGORIA_UPDATE("categoria:update"),
    CATEGORIA_DELETE("categoria:delete"),

    DIREITOS_ADUANEIROS_READ("direitos_aduaneiros:read"),
    DIREITOS_ADUANEIROS_CREATE("direitos_aduaneiros:create"),
    DIREITOS_ADUANEIROS_UPDATE("direitos_aduaneiros:update"),
    DIREITOS_ADUANEIROS_DELETE("direitos_aduaneiros:delete"),

    DPDA_READ("dpda:read"),
    DPDA_CREATE("dpda:create"),
    DPDA_UPDATE("dpda:update"),
    DPDA_DELETE("dpda:delete"),

    DPFA_READ("dpfa:read"),
    DPFA_CREATE("dpfa:create"),
    DPFA_UPDATE("dpfa:update"),
    DPFA_DELETE("dpfa:delete"),

    DPI_READ("dpi:read"),
    DPI_CREATE("dpi:create"),
    DPI_UPDATE("dpi:update"),
    DPI_DELETE("dpi:delete"),

    DPM_READ("dpm:read"),
    DPM_CREATE("dpm:create"),
    DPM_UPDATE("dpm:update"),
    DPM_DELETE("dpm:delete"),

    EXTENSAO_READ("extensao:read"),
    EXTENSAO_CREATE("extensao:create"),
    EXTENSAO_UPDATE("extensao:update"),
    EXTENSAO_DELETE("extensao:delete"),

    FUNDOS_ADUANEIROS_READ("fundos_aduaneiros:read"),
    FUNDOS_ADUANEIROS_CREATE("fundos_aduaneiros:create"),
    FUNDOS_ADUANEIROS_UPDATE("fundos_aduaneiros:update"),
    FUNDOS_ADUANEIROS_DELETE("fundos_aduaneiros:delete"),

    IMPOSICAO_READ("imposicao:read"),
    IMPOSICAO_CREATE("imposicao:create"),
    IMPOSICAO_UPDATE("imposicao:update"),
    IMPOSICAO_DELETE("imposicao:delete"),

    INSTANCIA_ADUANEIRA_READ("instancia_aduaneira:read"),
    INSTANCIA_ADUANEIRA_CREATE("instancia_aduaneira:create"),
    INSTANCIA_ADUANEIRA_UPDATE("instancia_aduaneira:update"),
    INSTANCIA_ADUANEIRA_DELETE("instancia_aduaneira:delete"),

    MERCADORIA_READ("mercadoria:read"),
    MERCADORIA_CREATE("mercadoria:create"),
    MERCADORIA_UPDATE("mercadoria:update"),
    MERCADORIA_DELETE("mercadoria:delete"),

    MUNICIPIO_READ("municipio:read"),
    MUNICIPIO_CREATE("municipio:create"),
    MUNICIPIO_UPDATE("municipio:update"),
    MUNICIPIO_DELETE("municipio:delete"),

    ORIGEM_PROCEDENCIA_READ("origem_procedencia:read"),
    ORIGEM_PROCEDENCIA_CREATE("origem_procedencia:create"),
    ORIGEM_PROCEDENCIA_UPDATE("origem_procedencia:update"),
    ORIGEM_PROCEDENCIA_DELETE("origem_procedencia:delete"),

    PROCESSO_READ("processo:read"),
    PROCESSO_CREATE("processo:create"),
    PROCESSO_UPDATE("processo:update"),
    PROCESSO_DELETE("processo:delete"),

    PROCESSO_DETALHE_READ("processo_detalhe:read"),
    PROCESSO_DETALHE_CREATE("processo_detalhe:create"),
    PROCESSO_DETALHE_UPDATE("processo_detalhe:update"),
    PROCESSO_DETALHE_DELETE("processo_detalhe:delete"),

    PROVINCIA_READ("provincia:read"),
    PROVINCIA_CREATE("provincia:create"),
    PROVINCIA_UPDATE("provincia:update"),
    PROVINCIA_DELETE("provincia:delete"),

    SERIAL_READ("serial:read"),
    SERIAL_CREATE("serial:create"),
    SERIAL_UPDATE("serial:update"),
    SERIAL_DELETE("serial:delete"),

    TERMINAL_READ("terminal:read"),
    TERMINAL_CREATE("terminal:create"),
    TERMINAL_UPDATE("terminal:update"),
    TERMINAL_DELETE("terminal:delete"),

    PEDIDO_READ("pedido:read"),
    PEDIDO_CREATE("pedido:create"),
    PEDIDO_UPDATE("pedido:update"),
    PEDIDO_DELETE("pedido:delete");



    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
