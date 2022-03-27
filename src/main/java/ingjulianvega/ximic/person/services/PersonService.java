package ingjulianvega.ximic.person.services;


import ingjulianvega.ximic.person.web.model.PagedPersonList;
import ingjulianvega.ximic.person.web.model.Person;
import ingjulianvega.ximic.person.web.model.PersonDto;

import java.util.UUID;

public interface PersonService {
    PagedPersonList get(Boolean usingCache, Integer pageNo, Integer pageSize, String sortBy);

    PersonDto getById(UUID id);

    void create(Person person);

    void updateById(UUID id, Person person);

    void deleteById(UUID id);
}
