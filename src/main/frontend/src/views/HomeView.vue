<script setup>
import Header from "../components/Header.vue";
import SliderComponent from "../components/SliderComponent.vue";
import EventComponent from "../components/EventComponent.vue";
import { onBeforeMount } from "vue";
import { useEventsStore } from "../stores/EventsStore";
import { useUsersStore } from "../stores/UsersStore";

const store = useEventsStore();

const userStore = useUsersStore();
onBeforeMount(async () => {
  await userStore.fetchUsers(1);
 await store.fetchEvents();
});
</script>
<template>
  <Header></Header>
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
