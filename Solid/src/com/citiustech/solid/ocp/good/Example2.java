package com.citiustech.solid.ocp.good;

class OrderService {
	
	Status orderStatus(int orderId) {
		NotificationService notificationService = new PushNotificationService();
		notificationService.notifyCustomer();
		return null;
	}
}

class Status {
	
}

interface NotificationService {
	
	public void notifyCustomer();
}

class EmailNotificationService implements NotificationService {
	@Override
	public void notifyCustomer() {
	}
}
class SmsNotificationService implements NotificationService {
	@Override
	public void notifyCustomer() {
	}
}
class PushNotificationService implements NotificationService {
	@Override
	public void notifyCustomer() {
	}
}

public class Example2 {

}
