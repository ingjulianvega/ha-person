package ingjulianvega.ximic.person.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PagedPersonList implements Serializable {
    static final long serialVersionUID = 6768913752954432328L;

    private long totalItems;
    private Page page;
    private ArrayList<PersonDto> personList;
}
