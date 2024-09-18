package org.example;

import java.util.List;

public interface ClientController {
    void createClient(Client client);
    Client findClientByIdentification(String identificationNumber);
    void updateClient(Client client);
    void removeClient(String identificationNumber);
    List<Client> listClient();
}
