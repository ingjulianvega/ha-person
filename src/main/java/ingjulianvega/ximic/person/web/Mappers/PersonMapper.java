package ingjulianvega.ximic.person.web.Mappers;

import ingjulianvega.ximic.person.domain.PersonEntity;
import ingjulianvega.ximic.person.web.model.PersonDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface PersonMapper {
    PersonDto personEntityToPersonDto(PersonEntity personEntity);

    PersonEntity personDtoToPersonEntity(PersonDto personDto);

    ArrayList<PersonDto> personEntityListToPersonDtoList(List<PersonEntity> personEntityList);
}

