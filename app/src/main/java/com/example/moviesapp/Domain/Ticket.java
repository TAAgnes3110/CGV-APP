package com.example.moviesapp.Domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Ticket implements Serializable {
    private String id; // Thêm trường id
    private String movie_name;
    private LocalDate show_date;
    private String show_time;
    private List<String> seats;
    private String user_id; // Thêm trường user_id
    private long total_price; // Thêm trường total_price
    private LocalDateTime booking_time;

    public Ticket(String id, String movieName, LocalDate showDate, String showTime, List<String> seats,
                  String userId, long totalPrice, LocalDateTime bookingTime) {
        this.id = id;
        this.movie_name = movieName;
        this.show_date = showDate;
        this.show_time = showTime;
        this.seats = seats;
        this.user_id = userId;
        this.total_price = totalPrice;
        this.booking_time = bookingTime;
    }

    // Getters và Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieName() {
        return movie_name;
    }

    public void setMovieName(String movieName) {
        this.movie_name = movie_name;
    }

    public LocalDate getShowDate() {
        return show_date;
    }

    public void setShowDate(LocalDate showDate) {
        this.show_date = show_date;
    }

    public String getShowTime() {
        return show_time;
    }

    public void setShowTime(String showTime) {
        this.show_time = show_time;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    public String getUserId() {
        return user_id;
    }

    public void setUserId(String userId) {
        this.user_id = user_id;
    }

    public long getTotalPrice() {
        return total_price;
    }

    public void setTotalPrice(long totalPrice) {
        this.total_price = total_price;
    }

    public LocalDateTime getBookingTime() {
        return booking_time;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.booking_time = booking_time;
    }
}