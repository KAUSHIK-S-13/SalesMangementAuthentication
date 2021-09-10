package com.sales.management.ServiceImpl;

import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.DTO.SparepartsDTO;
import com.sales.management.Model.Spareparts;
import com.sales.management.Model.Sparepartstype;
import com.sales.management.Model.User;
import com.sales.management.Repository.SparepartsRepository;
import com.sales.management.Repository.SparepartstypeRepository;
import com.sales.management.Service.SparepartsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional

public class SparepartsServiceImpl implements SparepartsInterface {
    @Autowired
    private SparepartsRepository sparepartsRepository;

    @Autowired
    private SparepartstypeRepository sparepartstypeRepository;

    @Override
    public Spareparts addSpareparts(SparepartsDTO sparepartsDTO) {
        Spareparts spareparts = new Spareparts();
        spareparts.setSparepartsName(sparepartsDTO.getSparepartsName());
        Optional<Sparepartstype> obj=sparepartstypeRepository.findBySparepartstypeId(sparepartsDTO.getSparepartstypeId());
        if(obj.isPresent())
        {
            spareparts.setSparepartstypeId(obj.get());
            sparepartsRepository.save(spareparts);
        }
        else
        {
            throw new RuntimeException("not found");
        }
        return spareparts;
    }

    @Override
    public APIResponse<Spareparts> GetSparepartsWithPagination(int offset, int pageSize, String sparepartsName) {
        Pageable paging= PageRequest.of(offset, pageSize);
        Page<Spareparts> Sparepartss = sparepartsRepository.searchAllBySparepartsNameLike("%" + sparepartsName + "%", paging);
        APIResponse apiResponse=new APIResponse();
        apiResponse.setResponse(Sparepartss);
        apiResponse.setRecordCount(Sparepartss.getTotalPages());
        return apiResponse;
    }

    @Override
    public Optional<Spareparts> updateSpareparts(SparepartsDTO sparepartsDTO) {
        Optional<Spareparts> existSpareparts= sparepartsRepository.findById(sparepartsDTO.getSparepartsId());
        if(existSpareparts.isPresent())
        {
            existSpareparts.get().setSparepartsName(sparepartsDTO.getSparepartsName());
        }
        else
        {
            throw new RuntimeException("not found");
        }
        Optional<Sparepartstype> obj=sparepartstypeRepository.findBySparepartstypeId(sparepartsDTO.getSparepartstypeId());
        if(obj.isPresent())
        {
            existSpareparts.get().setSparepartstypeId(obj.get());
        }
        else
        {
            throw new RuntimeException("not found");
        }
        sparepartsRepository.save(existSpareparts.get());
        return existSpareparts;
    }

    @Override
    public Optional<Spareparts> findSparepartsById(int id){
       Optional<Spareparts> Sparepartss=sparepartsRepository.findById(id);
       return Sparepartss;
    }

    @Override
    public Optional<Spareparts> deleteSpareparts(SparepartsDTO sparepartsDTO) {
        Optional<Spareparts> existpareparts = sparepartsRepository.findById(sparepartsDTO.getSparepartsId());
        if(existpareparts.isPresent())
        {
            existpareparts.get().setIsDelete(1);
            sparepartsRepository.save(existpareparts.get());
        }
        else
        {
            throw new RuntimeException("not found");
        }
        return existpareparts;
    }
}
