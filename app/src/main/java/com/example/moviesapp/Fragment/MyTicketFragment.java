
package com.example.moviesapp.Fragment;

import static android.app.Activity.RESULT_OK;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.Activity.BookingActivity;
import com.example.moviesapp.Adapters.TicketAdapter;
import com.example.moviesapp.Api.TicketAPIRepo;
import com.example.moviesapp.Domain.Ticket;
import com.example.moviesapp.R;

import java.util.List;

public class MyTicketFragment extends Fragment {
    private RecyclerView ticketRecyclerView;
    private TicketAdapter ticketAdapter;
    private TicketAPIRepo ticketAPIRepo;
    private static final String USER_ID = "1"; // Thay bằng user_id thực tế, có thể lấy từ SharedPreferences hoặc Bundle

    ImageButton btnBack;

    public MyTicketFragment() {
        // Bắt buộc có constructor rỗng
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myticket, container, false);

        // Khởi tạo các thành phần giao diện
        btnBack = view.findViewById(R.id.btnBack);
        ticketRecyclerView = view.findViewById(R.id.ticketRecyclerView);

        // Thiết lập RecyclerView
        ticketRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ticketAdapter = new TicketAdapter();
        ticketRecyclerView.setAdapter(ticketAdapter);

        // Khởi tạo TicketAPIRepo để gọi API
        ticketAPIRepo = new TicketAPIRepo();

        // Gọi API để lấy danh sách vé
        fetchTickets();

        // Xử lý sự kiện nút Back
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavigationHelper.navigateTo(MyTicketFragment.this,
                        new ProfileFragment(), "profile_fragment");
            }
        });

        return view;
    }

    private void fetchTickets() {
        ticketAPIRepo.getTicketsByUser(USER_ID, new TicketAPIRepo.OnResultCallback<List<Ticket>>() {
            @Override
            public void onSuccess(List<Ticket> tickets) {
                // Cập nhật dữ liệu vào adapter
                for (Ticket ticket : tickets) {
                    ticketAdapter.addTicket(ticket);
                }
            }

            @Override
            public void onError(Throwable error) {
                // Hiển thị thông báo lỗi nếu có
                Toast.makeText(getContext(), "Lỗi khi lấy danh sách vé: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Ticket ticket = (Ticket) data.getSerializableExtra("ticket");
            if (ticket != null) {
                ticketAdapter.addTicket(ticket);
            }
        }
    }

    public void startBookingActivityForResult() {
        Intent intent = new Intent(getActivity(), BookingActivity.class);
        startActivityForResult(intent, 1);
    }
}