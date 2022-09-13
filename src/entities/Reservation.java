package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private int roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(int roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		if(checkOut.after(checkIn)) {
			return "check-out date must be after chack-in date ";
		}
		this.checkOut = checkOut;
		this.checkIn = checkIn;
		return null;
	}
	
	public String toString() {
		return "Status de reserva\n quarto: " + roomNumber + ", data de entrada: " + sdf.format(checkIn) + " data de sa�da: " + sdf.format(checkOut) + " " + duration() +  " noites";
	}
}
