package com.example.exo3spring.mappers;

import com.example.exo3spring.entities.Contact;
import com.example.exo3spring.models.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;

@Mapper
public interface ContactMapper {


    @Mapping(source = "birthDate", target = "age", qualifiedByName = "convertDateToAge")
    ContactDTO contactToContactDto(Contact contact);
    Contact contactDTOToPerson(ContactDTO dto);


    @Named("convertDateToAge")
    public static Integer convertDateToAge(LocalDate date) {
        LocalDate now = LocalDate.now();
        Integer age = now.getYear() - date.getYear();

        if (now.minusYears(age).isBefore(date)) {
            age--;
        }

        return age;
    }
}
