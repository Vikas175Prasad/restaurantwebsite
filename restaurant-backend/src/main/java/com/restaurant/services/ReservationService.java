package com.restaurant.services;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entities.Reservations;
import com.restaurant.models.BookReservationModel;
import com.restaurant.repos.ReservationRepo;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepo reservationRepo;

	@Transactional
	public void bookReservation(BookReservationModel bookReservationModel) {

		long timestamp = Long.parseLong(bookReservationModel.getReservationDate());
		Date reservationDate = new Date(timestamp);
		Reservations reservation = new Reservations(bookReservationModel.getName(), bookReservationModel.getPhone(),
				bookReservationModel.getEmail(), reservationDate, bookReservationModel.getTime(),
				bookReservationModel.getNumberOfAttendees(), bookReservationModel.getAdditionalRequests());

		reservationRepo.bookReservation(reservation);
		sendMail(bookReservationModel.getEmail(), "Friends & Family Restaurant Reservation!!!",
				"<h4>Thanks for making reservation with us. Following are your reservation details:</h4><br />"
						+ "Name:  " + bookReservationModel.getName() + "<br />Phone :" + bookReservationModel.getPhone()
						+ "<br />Email: " + bookReservationModel.getEmail() + "<br />Date: " + reservationDate
						+ "<br />Time: " + bookReservationModel.getTime() + "<br />Number of attendees: "
						+ bookReservationModel.getNumberOfAttendees() + "<br />Additional Requests:"
						+ bookReservationModel.getAdditionalRequests()
						+ "<br /><br /> Thanks</br><h4>Friends & Family Restaurant");

	}

	public String sendMail(String to, String subject, String text) {

		String host = "smtp.gmail.com";
		Properties properties = System.getProperties();

		properties.put("mail.smtp.starttls.enable", "false");
		properties.put("mail.smtp.socketFactory.fallback", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication("<email>", "<password>");

			}

		});

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress("<email>"));

			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject(subject);

			message.setContent(text, "text/html");

			System.out.println("sending...");

			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}

		return "Success";
	}

}
