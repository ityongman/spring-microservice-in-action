package com.ityongman.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Business {
	
	@NotNull(message = "business id must exist")
    @Min(value = 1, message = "business id must great then 1")
    private Long id;

    @NotBlank(message = "business name must not blank")
    private String name;

    @Min(value = 1, message = "business age must great then 1")
    private Integer age;
}
