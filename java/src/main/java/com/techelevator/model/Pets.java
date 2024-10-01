package com.techelevator.model;

public class Pets {

    private int id;
    private String name;
    private String breed;
    private String dateOfBirth;
    private String gender;
    private int customerId;
    private boolean vaccination;
    private boolean neutor;
    private String energyLevel;
    private String personality;
    private String image;

    public Pets() {
    }

    public Pets(int id, String name, String breed, String dateOfBirth, String gender, int customerId, boolean vaccination, boolean neutor, String energyLevel, String personality, String image) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.customerId = customerId;
        this.vaccination = vaccination;
        this.neutor = neutor;
        this.energyLevel = energyLevel;
        this.personality = personality;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isVaccination() {
        return vaccination;
    }

    public void setVaccination(boolean vaccination) {
        this.vaccination = vaccination;
    }

    public boolean isNeutor() {
        return neutor;
    }

    public void setNeutor(boolean neutor) {
        this.neutor = neutor;
    }

    public String getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(String energyLevel) {
        this.energyLevel = energyLevel;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}