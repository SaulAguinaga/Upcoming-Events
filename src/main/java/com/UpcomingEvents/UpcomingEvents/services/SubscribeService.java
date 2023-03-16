package com.UpcomingEvents.UpcomingEvents.services;



import org.springframework.stereotype.Service;

import com.UpcomingEvents.UpcomingEvents.models.Event;
import com.UpcomingEvents.UpcomingEvents.models.User;
import com.UpcomingEvents.UpcomingEvents.payloads.SubscribePayload;
import com.UpcomingEvents.UpcomingEvents.repositories.EventRepository;
import com.UpcomingEvents.UpcomingEvents.repositories.UserRepository;

@Service
public class SubscribeService {
    private UserRepository userRepository;
    private EventRepository eventRepository;

    

    public SubscribeService(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    public void signIn(Long id_event, Long id_user) {
        User user = userRepository.findById(id_user).get();
        Event event = eventRepository.findById(id_event).get();

        if (!user.getEvents().contains(event)) {
            event.setSigned_users(event.getSigned_users()+1);
            user.getEvents().add(event);
        }
        else if(user.getEvents().contains(event)) {
            this.signOut(event, user);
        }
        else{
            userRepository.save(user);
        }
        
        userRepository.save(user);
    }

    public void signOut(Event event, User user) {
        // Event event = eventRepository.findById(id_event).get();
        // User user = userRepository.findById(id_user).get();

        // if (user.getEvents().contains(event)) {
            event.setSigned_users(event.getSigned_users()-1);
            user.getEvents().remove(event);
        // }
        userRepository.save(user);
    }
    
}
