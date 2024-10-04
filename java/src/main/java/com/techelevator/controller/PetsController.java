package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Customers;
import com.techelevator.model.Pets;
import com.techelevator.model.PlaydatePets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class PetsController {
    @Autowired
    private PetDao petDao;
    @Autowired
    private UserDao userDao;
    @RequestMapping(path="/pets", method = RequestMethod.GET)
    public List<Pets> getAllPets(){
        return petDao.getAllPets();
    }
    @RequestMapping(path="/{customerId}/pets", method = RequestMethod.GET)
    public List<Pets> getAllPetsByCustomerId(@PathVariable int customerId, Principal principal){
        Customers customers = userDao.getCustomer(principal.getName());
        customerId = customers.getId();
        return petDao.getPetsByCustomerId(customerId);
    }
    @RequestMapping(path="/pet/{id}", method = RequestMethod.GET)
    public Pets getPetById(@PathVariable int id){
        return petDao.getPetById(id);
    }
    @RequestMapping(path="/update-pet", method = RequestMethod.PUT)
    public boolean updatePet(@Valid @RequestBody Pets pet, Principal principal){
        Customers customers = userDao.getCustomer(principal.getName());
        return petDao.updatePet(pet, customers.getId());
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path="/pets/{id}", method = RequestMethod.DELETE)
    public void deletePet(@PathVariable int id){
        petDao.deletePetById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/add-pet", method = RequestMethod.POST)
    public void addPet(@Valid @RequestBody Pets pet){
        petDao.addPet(pet);
    }
    @RequestMapping(path="/register-playdate", method = RequestMethod.POST)
    public void linkPetPlaydate(@Valid @RequestBody PlaydatePets playdatePets){
        petDao.linkPetPlaydate(playdatePets);
    }
    @RequestMapping(path = "/{playdateId}/pets", method = RequestMethod.GET)
    public List<Pets> getPetsByPlaydateId(@PathVariable int playdateId){
        return petDao.getPetsByPlaydateId(playdateId);
    }

}