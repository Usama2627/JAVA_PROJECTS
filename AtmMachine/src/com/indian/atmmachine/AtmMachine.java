package com.indian.atmmachine;

import java.util.Scanner;

class Atm {

	private float balance;
	private final int pin = 2627;

	public void checkPin() {
		System.out.println("Enter your Pin: ");
		Scanner sc = new Scanner(System.in);
		int enteredPin = sc.nextInt();
		if (enteredPin == pin) {
			menu();
		} else {
			System.err.println("Invalid pin! Enter a Valid Pin");
			checkPin();
		}
	}

	public void menu() {
		System.out.println("\n*****MENU*****");
		System.out.println("1. Check A/C Balance");
		System.out.println("2. Withdraw Money");
		System.out.println("3. Deposit Money");
		System.out.println("4. Exit");

		Scanner sc = new Scanner(System.in);
		int opt = sc.nextInt();

		switch (opt) {
		case 1:
			checkBalance();
			break;
		case 2:
			withdrawMoney();
			break;
		case 3:
			depositMoney();
			break;
		case 4:
			exit();
			break;
		default:
			System.err.println("Enter a Valid Choice");
		}
	}

	public void checkBalance() {
		System.out.println("Balance: " + balance);
		menu();
	}

	public void withdrawMoney() {
		System.out.println("Enter amount to Withdraw: ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		if (amount > balance) {
			System.err.println("Insufficient Balance");
		} else {
			balance = balance - amount;
			System.out.println("Money Withdrawal Successful");
		}
		menu();
	}

	public void depositMoney() {
		System.out.println("Enter amount to Deposit: ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		balance = balance + amount;
		System.out.println("Amount Deposited Successfully");
		menu();
	}

	public void exit() {
		System.out.println("*****THANK YOU*****");
	}
}

public class AtmMachine {
	public static void main(String[] args) {
		Atm atm = new Atm();
		atm.checkPin();
	}
}
