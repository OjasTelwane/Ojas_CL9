// Java program to implement the PowInterface

import java.rmi.*;
import java.rmi.server.*;
import java.lang.Math;
public class Impl extends UnicastRemoteObject
	implements PowInterface 
	{

		// Default constructor to throw RemoteException
		// from its parent constructor
		public Impl() throws Exception { super(); }

		// Implementation of the PowInterface,

		public double pow(double x, double y) { return Math.pow(x, y); }
	}

