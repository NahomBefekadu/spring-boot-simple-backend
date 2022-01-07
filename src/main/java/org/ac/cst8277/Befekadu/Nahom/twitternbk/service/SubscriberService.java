package org.ac.cst8277.Befekadu.Nahom.twitternbk.service;


import org.ac.cst8277.Befekadu.Nahom.twitternbk.dao.SubscribersDao;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.exception.NotFoundException;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Message;
import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Subscribers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriberService {

    public SubscriberService(@Qualifier("mysqlss")SubscribersDao subscribersDao) {
        this.subscribersDao = subscribersDao;
    }

    private final SubscribersDao subscribersDao;

    public List<Subscribers> getAllSubscribers(){return subscribersDao.selectAllSubscription();}

    public Subscribers getSubscriptionById(int id){
        return subscribersDao.selectSubscribersByID(id).orElseThrow(()-> new NotFoundException(String.format("User with id $s not found",id)));
    }

    public void deleteSubscription(int id){
        Optional<Subscribers> followers =subscribersDao.selectSubscribersByID(id);
        followers.ifPresentOrElse(follower ->{
            int result = subscribersDao.deleteSubscription(id);
            if (result !=1){
                throw new IllegalStateException("Could not delete message");
            }
        },()->{
            throw new NotFoundException(String.format("Could not find message with $s id",id));
        });
    }
    public void createaSubscription(Subscribers followers){
        int result = subscribersDao.insertSubscription(followers);
        if (result != 1){
            throw new IllegalStateException("Something went wrong");
        }
    }
    public void updateSubscription(int id,Subscribers followers){
        int result = subscribersDao.updateSubscription(id,followers);
        if (result != 1){
            throw new IllegalStateException("Something went wrong");
        }
    }
}
