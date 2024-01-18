package com.example.hibernate.config;

import com.example.hibernate.listener.EventDataJpaListener;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class HibernateEventConfig {
    @PersistenceUnit private EntityManagerFactory emf;
    @PostConstruct
    public void registerListeners() {
        SessionFactoryImplementor sessionFactory = emf.unwrap(SessionFactoryImplementor.class);
        EventListenerRegistry registry = sessionFactory.getServiceRegistry().getService(EventListenerRegistry.class);
        EventDataJpaListener listener = new EventDataJpaListener();
        registry.getEventListenerGroup(EventType.POST_COMMIT_INSERT).appendListener(listener);
    }
}
