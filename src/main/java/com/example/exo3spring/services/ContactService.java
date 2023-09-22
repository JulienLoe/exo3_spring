package com.example.exo3spring.services;


import com.example.exo3spring.entities.Contact;
import com.example.exo3spring.exceptions.ResourceNotFoundException;
import com.example.exo3spring.mappers.ContactMapper;
import com.example.exo3spring.models.ContactDTO;
import com.example.exo3spring.repositories.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Primary
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public List<ContactDTO> getContacts() {
        return contactRepository
                .findAll()
                .stream()
                // .map(p -> personMapper.personToPersonDto((p)))
                .map(contactMapper::contactToContactDto)
                .toList();
    }

    public Optional<ContactDTO> getContactById(UUID id) {
        Optional<Contact> foundContact = contactRepository.findById(id);

        if (foundContact.isPresent()){
            ContactDTO contactDTO = contactMapper.contactToContactDto(foundContact.get());

            return Optional.ofNullable(contactDTO);
        }

        throw new ResourceNotFoundException();
    }

    public ContactDTO addContact(ContactDTO dto) {
//        Person person = personMapper.personDtoToPerson(dto);
//        Person savedPerson = personRepository.save(person);
//        PersonDTO savedDto = personMapper.personToPersonDto(savedPerson);
//        return savedDto;

        return contactMapper.contactToContactDto(contactRepository
                .save(contactMapper.contactDTOToContact(dto)));
    }

    public Boolean deleteContactById(UUID id) {
        Contact foundContact = contactRepository.findById(id).stream().findFirst().orElse(null);

        if (foundContact != null){

            contactRepository.delete(foundContact);


            return true;
        }

        return false;
    }

    public ContactDTO editContact(UUID id, ContactDTO newDatas){
        AtomicReference<ContactDTO> atomicReference = new AtomicReference<>();

        Optional<Contact> foundContact = contactRepository.findById(id);


        foundContact.ifPresentOrElse(found -> {
            if(newDatas.getLastName() != null) {
                found.setLastName(newDatas.getLastName());
            }

            if(newDatas.getBlabla() != null) {
                found.setFirstName(newDatas.getBlabla());
            }

            if (newDatas.getBirthDate() != null) {
                found.setBirthDate(LocalDate.parse(newDatas.getBirthDate()));
            }
            atomicReference.set(contactMapper.contactToContactDto(found));
            contactRepository.save(contactMapper.contactDTOToContact(atomicReference.get()));
        }, () -> {
            atomicReference.set(null);

        });


        return atomicReference.get();
    }
}





//@Service
//@Primary
//public class ContactService {
//    private final Map<UUID, ContactDTO> contacts;
//
//    public ContactService() {
//        contacts = new HashMap<>();
//
//        ContactDTO contactA = ContactDTO.builder()
//                .id(UUID.randomUUID())
//                .LastName("Dupont")
//                .FirstName("Paul")
//                .Age(24)
//                .build();
//
//        ContactDTO contactB = ContactDTO.builder()
//                .id(UUID.randomUUID())
//                .LastName("Kirt")
//                .FirstName("Leonidas")
//                .Age(34)
//                .build();
//
//        ContactDTO contactC = ContactDTO.builder()
//                .id(UUID.randomUUID())
//                .LastName("Lord")
//                .FirstName("Franck")
//                .Age(44)
//                .build();
//
//        contacts.put(contactA.getId(), contactA);
//        contacts.put(contactB.getId(), contactB);
//        contacts.put(contactC.getId(), contactC);
//    }
//
//    public List<ContactDTO> getContacts() {
//        return contacts.values().stream().toList();
//    }
//
//    public Optional<ContactDTO> getContactById(UUID id) {
//        return contacts.values().stream().filter(d -> d.getId().equals(id)).findFirst();
//    }
//
//    public ContactDTO addContact(ContactDTO contactData) {
//        if (contactData.getId() == null) {
//            contactData.setId(UUID.randomUUID());
//        }
//
//        contacts.put(contactData.getId(), contactData);
//
//        return contactData;
//    }
//
//    public Boolean deleteContactById(UUID id) {
//        Optional<ContactDTO> foundContact = getContactById(id);
//
//        if (foundContact.isPresent()){
//            contacts.remove(foundContact.get().getId());
//
//            return true;
//        }
//
//        return false;
//    }
//
//
//    public ContactDTO editContact(UUID id, ContactDTO newDatas){
//        AtomicReference<ContactDTO> atomicReference = new AtomicReference<>();
//
//        Optional<ContactDTO> foundContact = getContactById(id);
//
//        foundContact.ifPresentOrElse(found -> {
//            if(newDatas.getLastName() != null) {
//                found.setLastName(newDatas.getLastName());
//            }
//
//            if(newDatas.getFirstName() != null) {
//                found.setFirstName(newDatas.getFirstName());
//            }
//
//            if (newDatas.getAge() != null) {
//                found.setAge(newDatas.getAge());
//            }
//
//            atomicReference.set(found);
//        }, () -> {
//            atomicReference.set(null);
//        });
//
//
//        return atomicReference.get();
//    }
//}
