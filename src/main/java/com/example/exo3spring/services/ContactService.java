package com.example.exo3spring.services;


import com.example.exo3spring.models.ContactDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Primary
public class ContactService {
    private final Map<UUID, ContactDTO> contacts;

    public ContactService() {
        contacts = new HashMap<>();

        ContactDTO contactA = ContactDTO.builder()
                .id(UUID.randomUUID())
                .LastName("Dupont")
                .FirstName("Paul")
                .Age(24)
                .build();

        ContactDTO contactB = ContactDTO.builder()
                .id(UUID.randomUUID())
                .LastName("Kirt")
                .FirstName("Leonidas")
                .Age(34)
                .build();

        ContactDTO contactC = ContactDTO.builder()
                .id(UUID.randomUUID())
                .LastName("Lord")
                .FirstName("Franck")
                .Age(44)
                .build();

        contacts.put(contactA.getId(), contactA);
        contacts.put(contactB.getId(), contactB);
        contacts.put(contactC.getId(), contactC);
    }

    public List<ContactDTO> getContacts() {
        return contacts.values().stream().toList();
    }

    public Optional<ContactDTO> getContactById(UUID id) {
        return contacts.values().stream().filter(d -> d.getId().equals(id)).findFirst();
    }

    public ContactDTO addContact(ContactDTO contactData) {
        if (contactData.getId() == null) {
            contactData.setId(UUID.randomUUID());
        }

        contacts.put(contactData.getId(), contactData);

        return contactData;
    }

    public Boolean deleteContactById(UUID id) {
        Optional<ContactDTO> foundContact = getContactById(id);

        if (foundContact.isPresent()){
            contacts.remove(foundContact.get().getId());

            return true;
        }

        return false;
    }


    public ContactDTO editContact(UUID id, ContactDTO newDatas){
        AtomicReference<ContactDTO> atomicReference = new AtomicReference<>();

        Optional<ContactDTO> foundContact = getContactById(id);

        foundContact.ifPresentOrElse(found -> {
            if(newDatas.getLastName() != null) {
                found.setLastName(newDatas.getLastName());
            }

            if(newDatas.getFirstName() != null) {
                found.setFirstName(newDatas.getFirstName());
            }

            if (newDatas.getAge() != null) {
                found.setAge(newDatas.getAge());
            }

            atomicReference.set(found);
        }, () -> {
            atomicReference.set(null);
        });


        return atomicReference.get();
    }
}
