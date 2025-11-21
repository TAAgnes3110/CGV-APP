package com.example.moviesapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.Domain.Ticket;
import com.example.moviesapp.R;

import java.util.ArrayList;
import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.TicketViewHolder> {
    private List<Ticket> ticketList = new ArrayList<>();

    @NonNull
    @Override
    public TicketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ticket, parent, false);
        return new TicketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketViewHolder holder, int position) {
        Ticket ticket = ticketList.get(position);
        holder.movieNameTextView.setText("Phim: " + (ticket.getMovieName() != null ? ticket.getMovieName() : "N/A"));
        holder.showDateTextView.setText("Ngày chiếu: " + (ticket.getShowDate() != null ? ticket.getShowDate().toString() : "N/A"));
        holder.showTimeTextView.setText("Giờ chiếu: " + (ticket.getShowTime() != null ? ticket.getShowTime() : "N/A"));
        holder.seatsTextView.setText("Ghế: " + (ticket.getSeats() != null ? ticket.getSeats().toString() : "N/A"));
        holder.totalPriceTextView.setText("Tổng giá: " + ticket.getTotalPrice());
        holder.bookingTimeTextView.setText("Thời gian đặt: " + (ticket.getBookingTime() != null ? ticket.getBookingTime().toString() : "N/A"));
    }

    @Override
    public int getItemCount() {
        return ticketList.size();
    }

    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
        notifyItemInserted(ticketList.size() - 1);
    }

    public static class TicketViewHolder extends RecyclerView.ViewHolder {
        TextView movieNameTextView, showDateTextView, showTimeTextView, seatsTextView, totalPriceTextView, bookingTimeTextView;

        public TicketViewHolder(@NonNull View itemView) {
            super(itemView);
            movieNameTextView = itemView.findViewById(R.id.movieNameTextView);
            showDateTextView = itemView.findViewById(R.id.showDateTextView);
            showTimeTextView = itemView.findViewById(R.id.showTimeTextView);
            seatsTextView = itemView.findViewById(R.id.seatsTextView);
            totalPriceTextView = itemView.findViewById(R.id.totalPriceTextView);
            bookingTimeTextView = itemView.findViewById(R.id.bookingTimeTextView);
        }
    }
}