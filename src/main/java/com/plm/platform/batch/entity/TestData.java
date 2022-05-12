package com.plm.platform.batch.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author crystal
 */
@Data
public class TestData {
    private Integer id;
    private String field1;
    private String field2;
    @NotBlank
    private String field3;
}
