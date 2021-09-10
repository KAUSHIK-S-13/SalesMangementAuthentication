package com.sales.management.Service;

import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.DTO.SparepartstypeDTO;
import com.sales.management.Model.Sparepartstype;

import java.util.List;
import java.util.Optional;

public interface SparepartstypeInterface {

    Sparepartstype addSparepartstype(SparepartstypeDTO sparepartstypeDTO);

    Optional<Sparepartstype> updateSparepartstype(SparepartstypeDTO sparepartstypeDTO);

    Optional<Sparepartstype>  deleteSparepartstype(SparepartstypeDTO sparepartstypeDTO);

    List<Sparepartstype> Listall();
}
