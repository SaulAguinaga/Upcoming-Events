<script setup>
import SliderComponent from "../components/SliderComponent.vue";
import Header from "../components/Header.vue";
import PaginationComponent from "../components/PaginationComponent.vue";
import SliderChecking from "../components/SliderChecking.vue";
import { onBeforeMount } from "vue";
import { useEventsStore } from "../stores/EventsStore";
import { useUsersStore } from "../stores/UsersStore";
import EventComponent from "../components/EventComponent.vue";

const store = useEventsStore();

const userStore = useUsersStore();
onBeforeMount(async () => {
  await userStore.fetchUsers(1);
 await store.fetchEvents();
});
</script>
<template>
  <Header />
  <SliderChecking />
  <SliderComponent />
  <div v-for="event of store.Events">
    <EventComponent
      :event="event"
      :user="userStore.Users"
    />
  </div>

  <PaginationComponent />
</template>
<style scoped></style>
