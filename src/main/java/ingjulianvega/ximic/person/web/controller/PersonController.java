package ingjulianvega.ximic.person.web.controller;


import ingjulianvega.ximic.person.services.PersonService;
import ingjulianvega.ximic.person.web.model.Person;
import ingjulianvega.ximic.person.web.model.PersonDto;
import ingjulianvega.ximic.person.web.model.PersonList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PersonController implements PersonI {
    private final PersonService personService;

    @Override
    public ResponseEntity<PersonList> get(Boolean usingCache) {
        return new ResponseEntity<>(personService.get(usingCache), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(personService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Person person) {
        personService.create(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Person person) {
        personService.updateById(id, person);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}