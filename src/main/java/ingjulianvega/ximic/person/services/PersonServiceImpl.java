package ingjulianvega.ximic.person.services;


import ingjulianvega.ximic.person.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.person.domain.PersonEntity;
import ingjulianvega.ximic.person.domain.repositories.PersonRepository;
import ingjulianvega.ximic.person.exception.PersonException;
import ingjulianvega.ximic.person.web.Mappers.PersonMapper;
import ingjulianvega.ximic.person.web.model.Person;
import ingjulianvega.ximic.person.web.model.PersonDto;
import ingjulianvega.ximic.person.web.model.PersonList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Cacheable(cacheNames = "personListCache")
    @Override
    public PersonList get() {
        log.debug("get()...");
        return PersonList
                .builder()
                .personList(personMapper.personEntityListToPersonDtoList(personRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "personCache")
    @Override
    public PersonDto getById(UUID id) {
        log.debug("getById()...");
        return personMapper.personEntityToPersonDto(
                personRepository.findById(id).orElseThrow(() -> PersonException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.PERSON_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.PERSON_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.PERSON_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.PERSON_NOT_FOUND_SOLUTION)
                        .build()));
    }

    @Override
    public void create(Person person) {
        log.debug("create()...");
        personMapper.personEntityToPersonDto(
                personRepository.save(
                        personMapper.personDtoToPersonEntity(
                                PersonDto
                                        .builder()
                                        .name(person.getName())
                                        .documentNumber(person.getDocumentNumber()).
                                        build())));
    }

    @Override
    public void updateById(UUID id, Person maritalStatus) {
        log.debug("updateById...");
        PersonEntity maritalStatusEntity = personRepository.findById(id).orElseThrow(() -> PersonException
                .builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .apiCode(ErrorCodeMessages.PERSON_NOT_FOUND_API_CODE)
                .error(ErrorCodeMessages.PERSON_NOT_FOUND_ERROR)
                .message(ErrorCodeMessages.PERSON_NOT_FOUND_MESSAGE)
                .solution(ErrorCodeMessages.PERSON_NOT_FOUND_SOLUTION)
                .build());
        maritalStatusEntity.setName(maritalStatus.getName());

        personRepository.save(maritalStatusEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        personRepository.deleteById(id);
    }
}