package org.example;

public class ClientImpl implements Client{

    private String identificationNumber;
    private String name;
    private String lastName;

    public ClientImpl(String identificationNumber, String name, String lastName) {
        this.identificationNumber = identificationNumber;
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String getIdentificationNumber() {
        return this.identificationNumber;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
