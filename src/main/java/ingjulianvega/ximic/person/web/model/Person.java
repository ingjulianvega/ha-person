package ingjulianvega.ximic.person.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

  @NotBlank
  private String name = null;
  @NotBlank
  private String documentNumber = null;

}

