<script setup>
import { ref } from 'vue';

let switchButton=ref(true);
let reactive = ref(1);

let props = defineProps({
  event:{
    type: Object,
  },
  user:{
    type: Object
  }
});


const singup =async (id_event, id_user)=>{
  const response = await fetch(`http://localhost:8080/api/subscribe/${id_event}/${id_user}`,{
    method: "PUT"
  });
};


</script>
<template>
  <div class="card mb" id="mainContainer">
    <div class="row g-0" id="childrenContainer">
      <div class="col-md" id="imgContainer">
        <img :src="event.image" :alt="title" />
      </div>
      <div class="col-md-9">
        <div class="card-body">
          <div class="d-flex" id="titleCard">
            <p class="card-title">{{ event.title}}</p>
            <p id="date">{{ event.date }}</p>
          </div>
          <p class="card-text">
            {{ event.description }}
          </p>
        </div>
      </div>
      <div class="col-sm-1" id="thirdColumn">
        <div class="card-body" id="btnmaxpeopleContainer">
          <div id="divBtnSign">
              <button v-if="switchButton==true" class="buttonSign" @click="singup(event.id, user.id), switchButton=false, event.signed_users++" >Sign up</button>
              <button v-if="switchButton==false" class="using-button" @click="singup(event.id, user.id), switchButton=true, event.signed_users--">Sign Out</button>
          </div>
          <span v-if="event.signed_users==event.max_users" class="full">FULL</span>
          <div id="maxPeople">{{ event.signed_users }}/{{ event.max_users }}</div>
        </div> 
      </div>
    </div>
  </div>
</template>
<style scoped>
@import "../assets/css/eventComponent.css";
</style>
