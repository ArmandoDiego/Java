package com.collections.diego;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
			
	private final String theatreName;
	private List<Seat> seats=new ArrayList<>();
	
	public Theatre(String theatreName, int numRows, int seatsPerRow){
		this.theatreName=theatreName;
		int lastRow='A' + (numRows-1);
		for(char row='A'; row<=lastRow; row++){
			for(int seatNum=1; seatNum<=seatsPerRow; seatNum++){
				Seat seat=new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}

	public String getTheatreName() {
		return theatreName;
	}
	
	public boolean reserveSeat(String seatNumber){
		Seat requestedSeat=null;
		for(Seat seat: seats){
			if(seat.getSeatNumber().equals(seatNumber)){
				requestedSeat=seat;
				break;
			}
		}
		if(requestedSeat==null){
			System.out.println("There is no seat: "+ seatNumber);
			return false;
		}
//		return requestedSeat.reserve();
		return true;
	}
	
	public void getSeats(){
		for(Seat seats: seats){
			System.out.println(seats.getSeatNumber());
		}
	}
	
	public class Seat{
		private final String seatNumber;
		private boolean reversed=false;
		
		public Seat(String seatNumber){
			this.seatNumber=seatNumber;
		}
		public boolean z(){
			if(!this.reversed){
				this.reversed=true;
				System.out.println("Seat: " + seatNumber + " reserved") ;
				return true;
			}
			return false;
		}
		
		public boolean cancel(){
			if(this.reversed){
				this.reversed=false;
				System.out.println("Reservation of seat" + seatNumber + "cancelled");
				return true;
			}
			return false;
		}
		public String getSeatNumber() {
			return seatNumber;
		}
		
		
	}
}
