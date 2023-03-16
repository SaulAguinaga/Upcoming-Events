import { defineStore } from "pinia";

export const useUsersStore = defineStore({
  id: "Users", 
  state: () => ({
    Users: {},
  }),
  actions: {
    async fetchUsers(id_user) {
      const response = await fetch(`http://localhost:8080/api/users/`+id_user);
      const responseJson = await response.json();
      this.Users = responseJson;
      console.log(this.Users);
    },
  },
});