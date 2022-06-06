package com.citiustech.solid.ocp.bad;

class OrderService {
	
	Status orderStatus(int orderId) {
		NotificationService notificationService = new NotificationService();
		notificationService.notifyCustomer();
		return null;
	}
}

class Status {
	
}

/*
 * but what if we want to support multiple ways of notifying user (email, sms, push, ..)
 * writing if conditions below would be a bad idea
 */
class NotificationService {
	
	public void notifyCustomer() {
		//send the notification as an email
	}
}

public class Example2 {

}
