package com.sales.management.ServiceImpl;

import com.sales.management.DTO.SparepartstypeDTO;
import com.sales.management.Model.Sparepartstype;
import com.sales.management.Repository.SparepartstypeRepository;
import com.sales.management.Service.SparepartstypeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional

public class SparepartstypeServiceImpl implements SparepartstypeInterface {

    @Autowired
    private SparepartstypeRepository sparepartstypeRepository;


   @Override
    public Sparepartstype addSparepartstype(SparepartstypeDTO sparepartstypeDTO) {
        Sparepartstype sparepartstype = new Sparepartstype();
        sparepartstype.setSparepartstypeName(sparepartstypeDTO.getSparepartstypeName());
        sparepartstypeRepository.save(sparepartstype);
        return sparepartstype;
    }

    @Override
    public Optional<Sparepartstype> updateSparepartstype(SparepartstypeDTO sparepartstypeDTO) {
        Optional<Sparepartstype> existSparepartstype= sparepartstypeRepository.findById(sparepartstypeDTO.getSparepartstypeId());
        if(existSparepartstype.isPresent())
        {
            existSparepartstype.get().setSparepartstypeName(sparepartstypeDTO.getSparepartstypeName());
            sparepartstypeRepository.save(existSparepartstype.get());
        }
        else
        {
            throw new RuntimeException("not found");
        }
        return existSparepartstype;
    }

    @Override
    public List<Sparepartstype> Listall(){
        List<Sparepartstype> obj=sparepartstypeRepository.findAll();
        return obj;
    }

   @Override
    public Optional<Sparepartstype> deleteSparepartstype(SparepartstypeDTO sparepartstypeDTO) {
        Optional<Sparepartstype> existSparepartstype = sparepartstypeRepository.findById(sparepartstypeDTO.getSparepartstypeId());
        if(existSparepartstype.isPresent())
        {
            existSparepartstype.get().setIsDelete(1);
            sparepartstypeRepository.save(existSparepartstype.get());
        }
        else
        {
            throw new RuntimeException("not found");
        }

        return existSparepartstype;
    }
}
