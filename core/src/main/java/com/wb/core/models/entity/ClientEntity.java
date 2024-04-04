package com.wb.core.models.entity;

import com.wb.core.models.CustomAbstractEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Entity(name = "cliente")
@AllArgsConstructor
public class ClientEntity extends CustomAbstractEntity {

}
