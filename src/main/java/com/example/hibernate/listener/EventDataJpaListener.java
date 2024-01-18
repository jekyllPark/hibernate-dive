package com.example.hibernate.listener;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.event.spi.PostCommitInsertEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.persister.entity.EntityPersister;

@Slf4j
public class EventDataJpaListener implements PostCommitInsertEventListener {
    @Override
    public void onPostInsertCommitFailed(PostInsertEvent event) {

    }

    @Override
    public void onPostInsert(PostInsertEvent event) {
        String id = event.getId().toString();
        Object entity = event.getEntity();
        log.info("POST INSERT / id [{}], entity [{}]", id, entity);
    }

    @Override
    public boolean requiresPostCommitHandling(EntityPersister persister) {
        return true;
    }
}
