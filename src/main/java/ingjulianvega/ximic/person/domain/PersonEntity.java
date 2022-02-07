package ingjulianvega.ximic.person.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Person")
@Entity
public class PersonEntity extends BaseEntity{

    @Column
    private String name;
    @Column
    private String documentNumber;
}
