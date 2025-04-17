package com.samples.drools.rules.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {

  @NotBlank
  @Size(max = 100)
  private String name;
  @PositiveOrZero
  @Max(150)
  private int age;

}
