package org.ac.cst8277.Befekadu.Nahom.twitternbk.dao;



import org.ac.cst8277.Befekadu.Nahom.twitternbk.model.Subscribers;

import java.util.List;
import java.util.Optional;

public interface SubscribersDao {
    int insertSubscription( Subscribers followers);
    int deleteSubscription(int id);
    int updateSubscription(int id, Subscribers followers);

    List<Subscribers> selectAllSubscription();
    //optional due to possibly returning null when no information found.
    Optional<Subscribers > selectSubscribersByID(int id);
}
