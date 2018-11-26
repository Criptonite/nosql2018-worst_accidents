package com.leti.server.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportBody {
    Integer reportType;
    List<Integer> years;
    List<Region> regions;
}
