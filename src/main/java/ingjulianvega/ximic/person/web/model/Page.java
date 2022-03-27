package ingjulianvega.ximic.person.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Page implements Serializable {
    static final long serialVersionUID = -1755948928649155501L;

    private String sort;
    private int totalPages;
    private int currentPage;
    private int size;
}
