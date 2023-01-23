package com.esc.estogether.model.vo;

import com.esc.estogether.model.type.SubTypeEnum;
import com.esc.estogether.model.type.TypeEnum;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
public class Position {
    private TypeEnum type;
    private SubTypeEnum subType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String memo;

}
