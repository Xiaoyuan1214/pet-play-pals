<template>
  <div class="allPets">
    <h1>All Pets</h1>
        <router-link to="/pets/add-pet">
             <button class="button is-info">Add</button>
        </router-link>
        <div class="buttons">
        <button class="button is-success" @click="editPet(pet)">Edit</button>
        <button class="button is-warning" @click="deletePet(pet.id)">Delete</button>
       </div>
   </div>
    <div class="pets" v-for="pet in pets" v-bind:key="pet.id">
      <router-link :to="{name: 'petDetails', params:{id:pet.id}}">
        <img v-bind:src="pet.image" alt="pet image" width="300" height="200">
        <h3><strong>{{pet.name}}</strong></h3>
        <p>{{pet.personality}}</p>
      </router-link>
  
    </div>
  
</template>

<script>
import petService from '../services/petService'
export default {
  data() {
    return {
      pets: [],
      editedPet: {}
    }
  },
  created() {
    this.loadPets();
  },
  methods: {
    loadPets() {
      petService.getAllPetsByCustomerId(this.$route.params.customerId).then(
        (response) => {
          this.pets = response.data;
        }
      ).catch(
        (error) => {
          console.log(error);
        }
      );
    },
    
 //delete pet
    
    deletePet() {
      if (confirm('Are you sure you want to delete this pet?')) {
        petService.deletePet(this.pet.id).then(
          (response) => {
            if (response.status === 200) {
              this.$store.commit(
                'SET_NOTIFICATION',
                {
                  message: 'The pet was deleted.',
                  type: 'success'
                }
              );
              this.$router.push({ name: 'pets', params: { customerId: this.pet.customerId } });
            }
          }
        ).catch(
          (error) => {
            console.log(error);
          }
        );
      }
    }
    
  }
}
</script>

<style>

</style>