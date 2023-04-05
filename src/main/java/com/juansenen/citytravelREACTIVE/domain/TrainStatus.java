package com.juansenen.citytravelREACTIVE.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "trains") //Nombre de la coleccion (tabla)
public class TrainStatus {

    @Id //Claves en string
    private String id;
    @Field //Campos (columnas)
    private String code;
    @Field
    private long lineId;
    @Field
    private float velocity;
    @Field
    private float weight;
    @Field
    private float kwH;
}
