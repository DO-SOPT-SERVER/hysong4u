package com.sopt.server.seminar_week6.dto;

import com.sopt.server.seminar_week6.domain.Part;
import lombok.Data;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}
