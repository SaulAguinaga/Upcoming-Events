<script setup>
import SliderComponent from "../components/SliderComponent.vue";
import HeaderAdmin from "../components/HeaderAdmin.vue";
import SliderChecking from "../components/SliderChecking.vue";
import { onBeforeMount } from "vue";
import { useEventsStore } from "../stores/EventsStore";
import EventComponent from "../components/EventComponent.vue";

const store = useEventsStore();
onBeforeMount(async () => {
  await store.fetchEvents();
});
</script>
<template>
  <HeaderAdmin/>
  <SliderChecking />
  <SliderComponent />
  <div v-for="event in store.Events" :key="event">
    <EventComponent
      :event="event"
    />
  </div>

</template>
<style scoped></style>
