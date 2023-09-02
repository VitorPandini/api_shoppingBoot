package com.vitorpandini.shoppingapi.repository;

import com.vitorpandini.shoppingapi.dto.ShopReportDTO;
import com.vitorpandini.shoppingapi.model.Shop;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ReportRepository {

    public List<Shop> getShopByFilters(Date dataInicio,Date dataFim,Float valorMinimo);

    public ShopReportDTO getReportByDate(LocalDate dataInicio, LocalDate dataFim);
}
