<script setup>
import PopUpLogin from "./PopUpLogin.vue";
import PopUpRegister from "./PopUpRegister.vue";
</script>
<template>
  <header>
    <div class="header-content navbar navbar-expand-sm">
      <div class="col-md-2 p-2">
        <img
          src="../assets/resources/Upcomming-events-logo.png"
          class="img img-fluid"
          alt="Upcoming Events Logo"
          id="logoHeader"
        />
      </div>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#opciones"
      >
        <span class="navbar-toggler-icon" id="pp"></span>
      </button>

      <div class="collapse navbar-collapse justify-content-end" id="opciones">
        <div class="front-page-container" id="login-view">
          <PopUpRegister/>
          <PopUpLogin />
        </div>
      </div>
    </div>
  </header>
</template>
<style scoped>
@import "../assets/css/NavBarComponent.css";
</style>
