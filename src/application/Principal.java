package application;

import model.exceptions.DomainException;
import model.reservation.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
        System.out.print("Room number: ");
        int number = leia.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(leia.next());
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(leia.next());

        Reservation reservation = new Reservation(number, checkIn, checkOut);
        System.out.println("Reservation" + reservation);

        System.out.println();
        System.out.println("Enter data to update the reservation:\n");
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkIn = sdf.parse(leia.next());
        System.out.print("Check-in date (dd/MM/yyyy): ");
        checkOut = sdf.parse(leia.next());

        reservation.updateDates(checkIn, checkOut);
        System.out.println("Reservation" + reservation);
        }
        catch (ParseException e){
            System.out.println("Invalid date format");
        }
        catch (DomainException e){
            System.out.println("Erro in reservation " + e.getMessage());
        }catch (RuntimeException e){
            System.out.println("Error. Algo de errado não está certo");
        }

        leia.close();
    }
}
