package com.africa.semicolon.wazobia_app.Services;

import com.africa.semicolon.wazobia_app.dtos.request.BookARideRequest;
import com.africa.semicolon.wazobia_app.dtos.response.BookARideResponse;

public interface BookingService {
    BookARideResponse bookARide(BookARideRequest request);
}
