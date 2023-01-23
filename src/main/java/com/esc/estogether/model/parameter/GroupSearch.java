package com.esc.estogether.model.parameter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupSearch {
    private Integer id;
    private Integer readerId;
    private Boolean operation;
}
