<template>
    <form v-on:submit.prevent="submitForm" class="cardForm">
  <div class="field">
  <label class="label">Name</label>
  <div class="control">
    <input class="input" type="text" placeholder="Text input">
  </div>
</div>

<div class="field">
  <label class="label">Breed</label>
  <div class="control">
    <input class="input is-success" type="text" placeholder="Text input">
    <span class="icon is-small is-left">
      <i class="fas fa-user"></i>
    </span>
    <span class="icon is-small is-right">
      <i class="fas fa-check"></i>
    </span>
  </div>
</div>

<div class="field">
  <label class="label">Date of Birth</label>
  <div class="control">
    <input class="input is-danger" type="date" placeholder="Email input">
    <span class="icon is-small is-left">
      <i class="fas fa-envelope"></i>
    </span>
    <span class="icon is-small is-right">
      <i class="fas fa-exclamation-triangle"></i>
    </span>
  </div>
</div>

<div class="field gender">
  <label class="label">Gender</label>
  <div class="control">
    <div class="select">
      <select>
        <option>Male</option>
        <option>Female</option>
      </select>
    </div>
  </div>
</div>
<div class="field size">
  <label class="label">Size</label>
  <div class="control">
    <div class="select">
      <select>
        <option>small</option>
        <option>medium</option>
        <option>large</option>
        <option>extra large</option>
      </select>
    </div>
  </div>
</div>
<div class="field vaccination">
  <div class="control">
    <label class="checkbox">
     Is Vaccinated <input type="checkbox">
    </label>
  </div>
</div>
<div class="field spay_neuter">
  <div class="control">
    <label class="checkbox">
     Is Spayed or Neuter <input type="checkbox">
    </label>
  </div>
</div>
<div class="field size">
  <label class="label">Energy Level</label>
  <div class="control">
    <div class="select">
      <select>
        <option>low</option>
        <option>medium</option>
        <option>high</option>
      </select>
    </div>
  </div>
</div>

<div class="field">
  <label class="label">Personality</label>
  <div class="control">
    <textarea class="textarea" placeholder="Textarea"></textarea>
  </div>
</div>
<div class="file is-primary">
  <label class="file-label">
    <input class="file-input" type="file" name="resume" />
    <span class="file-cta">
      <span class="file-icon">
        <i class="fas fa-upload"></i>
      </span>
      <span class="file-label"> Add your fur friend picture! </span>
    </span>
  </label>
</div>

<div class="field is-grouped">
  <div class="control">
    <button class="button is-link">Submit</button>
  </div>
  <div class="control">
    <button class="button is-link is-light" v-on:click="cancelForm">Cancel</button>
  </div>
</div>
</form>
</template>

<script>
import petService from '../services/petService';
export default {
    props: {
        pet: {
            type: Object,
            required: true
        }
    },
    data(){
        return{
            newPet:{
                id: this.pet.id,
                customerId: this.pet.customerId,
                name: this.pet.name,
                breed: this.pet.breed,
                dateOfBirth: this.pet.dateOfBirth,
                gender: this.pet.gender,
                petSize: this.pet.petSize,
                vaccination: this.pet.vaccination,
                isSpayNeuter: this.pet.isSpayNeuter,
                energyLevel: this.pet.energyLevel,
                personality: this.pet.personality,
                image: this.pet.image
            },
        }
    },
    methods:{
//submit form
      submitForm(){
            if(!this.validateForm()){
                return;
            }
            if(this.newPet.id === 0){
                petService.addPet(this.newPet).then(
                    (response) => {
                        if(response.status === 201){
                            this.$store.commit( 
                                'SET_NOTIFICATION',
                                {
                                    message: 'A new card was added.',
                                    type: 'success'
                                }
                            );
                            //redirect to pets page
                        this.$router.push( {name: 'pets', params: { customerId: this.newPet.customerId } });
                        }
                    }
                ).catch(
                    (error) => {
                        console.log(error);
                    }
                );
            }else{
                petService.updatePet(this.newPet.id, this.newPet).then(
                    (response) => {
                        if(response.status === 200){
                            this.$store.commit( 
                                'SET_NOTIFICATION',
                                {
                                    message: 'The card was updated.',
                                    type: 'success'
                                }
                            );
                            //redirect to pets page
                        this.$router.push( {name: 'pets', params: { customerId: this.newPet.customerId } });
                        }
                    }
                ).catch(
                    (error) => {
                        console.log(error);
                    }
                );
            }
        },
//cancel form
        cancelForm(){
            this.$router.push( {name: 'pets', params: { customerId: this.newPet.customerId } });
        },

    }
}
</script>

<style>

</style>