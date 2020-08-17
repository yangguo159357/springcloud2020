package com.xiaolun.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor //主实体
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
