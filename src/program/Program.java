package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Enter check-in date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Enter check-out date: ");
		Date checkOut = sdf.parse(sc.next());
		
		if(checkOut.before(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after chack-in date ");
		}else {
			Reservation reserva = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Rreserva: " + reserva);
			
			System.out.println("enter data to update the reservation: ");
			System.out.print("Data de entrada: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de saída: ");
			checkOut = sdf.parse(sc.next());
			
			String error = reserva.updateDates(checkIn, checkOut);
			if(error != null) {
				System.out.println("Error in reservation: " + error);
			}else {
				System.out.println("Rreserva: " + reserva);
			}
		}	
		
		sc.close();
	}

}
