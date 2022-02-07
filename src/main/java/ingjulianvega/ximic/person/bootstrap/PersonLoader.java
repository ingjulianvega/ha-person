package ingjulianvega.ximic.person.bootstrap;


import ingjulianvega.ximic.person.domain.PersonEntity;
import ingjulianvega.ximic.person.domain.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class PersonLoader implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        if (personRepository.count() == 0) {
            loadMaritalStatusObjects();
        }
    }

    private void loadMaritalStatusObjects() {
        personRepository.saveAll(Arrays.asList(
                PersonEntity.builder().name("Lucia").documentNumber("148576").build(),
                PersonEntity.builder().name("Maria").documentNumber("197463").build(),
                PersonEntity.builder().name("Paula").documentNumber("196485").build(),
                PersonEntity.builder().name("Daniela").documentNumber("146780").build(),
                PersonEntity.builder().name("Sara").documentNumber("735615").build(),
                PersonEntity.builder().name("Carla").documentNumber("125096").build(),
                PersonEntity.builder().name("Sophia").documentNumber("615804").build(),
                PersonEntity.builder().name("Emma").documentNumber("463863").build(),
                PersonEntity.builder().name("Isabela").documentNumber("257053").build(),
                PersonEntity.builder().name("Olivia").documentNumber("360427").build(),
                PersonEntity.builder().name("Emily").documentNumber("369462").build(),
                PersonEntity.builder().name("Sofia").documentNumber("973546").build(),
                PersonEntity.builder().name("Giulia").documentNumber("9734257").build(),
                PersonEntity.builder().name("Martina").documentNumber("2458576").build(),
                PersonEntity.builder().name("Giorgia").documentNumber("3075135").build(),
                PersonEntity.builder().name("Sara").documentNumber("74639244").build(),
                PersonEntity.builder().name("Emma").documentNumber("1257963").build(),
                PersonEntity.builder().name("Aurora").documentNumber("3579863").build(),
                PersonEntity.builder().name("Chiara").documentNumber("2467812").build(),
                PersonEntity.builder().name("Alice").documentNumber("4687531").build(),
                PersonEntity.builder().name("Alessia").documentNumber("3579631").build(),
                PersonEntity.builder().name("Amelia").documentNumber("2469742").build(),
                PersonEntity.builder().name("Olivia").documentNumber("2465342").build(),
                PersonEntity.builder().name("Jessia").documentNumber("9753680").build(),
                PersonEntity.builder().name("Lily").documentNumber("8531580").build(),
                PersonEntity.builder().name("Ava").documentNumber("6357925").build(),
                PersonEntity.builder().name("Mia").documentNumber("2468042").build()
        ));
    }
}
