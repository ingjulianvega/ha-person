package ingjulianvega.ximic.person.services;


import ingjulianvega.ximic.person.web.model.Person;
import ingjulianvega.ximic.person.web.model.PersonDto;
import ingjulianvega.ximic.person.web.model.PersonList;

import java.util.UUID;

public interface PersonService {
    PersonList get();

    PersonDto getById(UUID id);

    void create(Person person);

    void updateById(UUID id, Person person);

    void deleteById(UUID id);
}
