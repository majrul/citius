package com.citiustech.solid.isp.good;

interface Register {
	
	void register();
	void updateProfile();
}

interface Login {
	void login();
	void logout();
}

interface Subscribe {
	void subscribe();
}

interface Order {
	void placeOrder();
	void cancelOrder();
}

class CustomerService implements Login, Register {

	@Override
	public void register() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProfile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

}
public class Example1 {

}
