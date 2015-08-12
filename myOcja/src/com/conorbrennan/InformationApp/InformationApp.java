package com.myocja.infoapp ;
import java.util.Scanner ;
	public class InfoApp {
	private String pps ;
	private String name ;
	boolean validName = true ;
	boolean validPPS = true ;
		public static void main(String[] args){
			InfoApp ia = new InfoApp();
			ia.run();	
		}
		
		public void run(){
			
			do{
				try{
					this.enterName();
				}catch(InvalidNameException in ){
					System.out.println(in);
					validName = false;		
				}
			}while(validName == false) ;
			do{	
				try{
					this.enterPPS();
				}catch(InvalidPPSException ip){
					ip.printStackTrace();
					validPPS = false;	
				}
			}while(validPPS == false) ;

			System.out.println("		Name: "+name+"\n		PPSN: "+pps);
		}

		public void enterName(){
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter your full name: " );
			this.name = scan.nextLine();
				if(name.contains("\u0020")){
					validName = true ;
				}else{
					System.out.println("Please enter your full name with a space seperating first and second name eg. Joe Bloggs");
					throw new InvalidNameException() ;
				}
			
		
		}
		public void enterPPS() throws InvalidPPSException {
			Scanner scan = new Scanner(System.in);
			System.out.println("Please enter your full pps: " );
			boolean ppsNumeric = true;
			this.pps = scan.nextLine();
			pps.toCharArray();
			for(int i = 0 ; i<(pps.length()-1) ; ++i){
				if(pps.charAt(i)>='0' && pps.charAt(i)<='9'){
					ppsNumeric = true;
				}else{
					validPPS = false ;
					throw new InvalidPPSException("Please make sure the first 7 characters are numeric") ;
				}
			}
			if(pps.length()!=8){
				
				validPPS = false ;
				throw new InvalidPPSException("Please enter exactly 8 characters") ;
			}else if (pps.charAt(7)<'A'||pps.charAt(7)>'W') {
				validPPS = false ;
				throw new InvalidPPSException("Please enter a letter as the last character") ;
			}else{
				if(ppsNumeric){
					validPPS = true ;
				}
			}
		}
	}

	class InvalidNameException extends RuntimeException {
		

	}
	
	class InvalidPPSException extends Exception {
		public InvalidPPSException(){
			super();
			
		}

		public InvalidPPSException(String s){
			super(s);
			
		}
	}
