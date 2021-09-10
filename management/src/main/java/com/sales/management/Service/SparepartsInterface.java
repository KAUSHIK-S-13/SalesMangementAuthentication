package com.sales.management.Service;

import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.DTO.SparepartsDTO;
import com.sales.management.Model.Spareparts;

import java.util.Optional;

public interface SparepartsInterface {
    Spareparts addSpareparts(SparepartsDTO sparepartsDTO);

    APIResponse<Spareparts> GetSparepartsWithPagination(int offset, int pageSize, String sparepartsName);

    Optional<Spareparts> updateSpareparts(SparepartsDTO sparepartsDTO);

    Optional<Spareparts> findSparepartsById(int id);

    Optional<Spareparts> deleteSpareparts(SparepartsDTO sparepartsDTO);
}
