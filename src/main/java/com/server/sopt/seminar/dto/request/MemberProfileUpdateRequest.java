package com.server.sopt.seminar.dto.request;

import com.server.sopt.seminar.entity.Part;
import lombok.Data;

@Data
public class MemberProfileUpdateRequest {
    private int generation;
    private Part part;
}
