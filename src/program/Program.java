package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Enter room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Enter check-in date: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Enter check-out date: ");
			Date checkOut = sdf.parse(sc.next());
			
			Reservation reserva = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Rreserva: " + reserva);
			
			System.out.println("enter data to update the reservation: ");
			System.out.print("Data de entrada: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data de saída: ");
			checkOut = sdf.parse(sc.next());
			
			reserva.updateDates(checkIn, checkOut);
			System.out.println("Rreserva: " + reserva);
		}
		catch(ParseException e) {
			System.out.println("Invalide date format ");
		}
		catch(DomainException e) {
			System.out.println("Error in reservation" + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
	}

}
