package com.example.exo3spring.mappers;

import com.example.exo3spring.entities.Contact;
import com.example.exo3spring.models.ActeurDTO;
import com.example.exo3spring.models.ContactDTO;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.util.List;

//public interface MoviesCreditsMapper {
//
//    @Mapping(source = "blabla", target = "firstName")
//    Contact contactDTOToContact(ContactDTO dto);
//
//    @Mapping(source = "firstName", target = "blabla")
//    @Mapping(source = "birthDate", target = "birthDate", qualifiedByName = "convertDate")
//    ContactDTO contactToContactDto(Contact contact);
//
//
//
//    @Named("convertStringToTab")
//    public List<ActeurDTO> convertStringToTab() {
//        String str = "Do this at \"2014-09-16 05:40:00.0\"";
//        String []splitterString=str.split("\"");
//        for (String s : splitterString) {
//            System.out.println(s);
//        }
//        }
//
//        return age;
//    }
//
//    @Named("convertDate")
//    public static String convertDate(LocalDate date) {
//        String string = date.toString();
//
//        return string;
//    }
//}
