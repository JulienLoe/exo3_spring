package com.example.exo3spring.mappers;

import com.example.exo3spring.entities.Contact;
import com.example.exo3spring.models.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper
public interface ContactMapper {
    @Mapping(source = "blabla", target = "firstName")
    Contact contactDTOToPerson(ContactDTO dto);

    @Mapping(source = "firstName", target = "blabla")
    @Mapping(source = "birthDate", target = "age", qualifiedByName = "convertDateToAge")
    ContactDTO contactToContactDto(Contact contact);



    @Named("convertDateToAge")
    public static Integer convertDateToAge(LocalDate date) {
        LocalDate now = LocalDate.now();
        int age = now.getYear() - date.getYear();

        if (now.minusYears(age).isBefore(date)) {
            age--;
        }

        return age;
    }
}
