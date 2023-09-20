package com.example.exo3spring.services;


import com.example.exo3spring.models.ContactDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.*;

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
}
