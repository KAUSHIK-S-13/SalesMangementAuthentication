package com.sales.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

}
/* public BaseResponse addspareparts(SparepartsDTO sparepartsDTO)
    {
        Spareparts spareparts=new Spareparts();
        Sparepartstype sparepartstype=new Sparepartstype();
        sparepartstype.setSparepartstypeName(sparepartsDTO.getSparepartstypeName());
        sparepartstype.setIsActive(sparepartsDTO.getIsActive());
        sparepartstype.setIsDelete(sparepartsDTO.getIsDelete());
        sparepartstype=sparepartstypeRepository.save(sparepartstype);
        spareparts.setSparepartsName(sparepartsDTO.getSparepartsName());
        spareparts.setIsActive(sparepartsDTO.getIsActive());
        spareparts.setIsDelete(sparepartsDTO.getIsDelete());
        spareparts.setSparepartstypeId(sparepartstype);
        spareparts=sparepartsRepository.save(spareparts);
        BaseResponse baseResponse=new BaseResponse();
        baseResponse.setStatusCode("200");
        baseResponse.setStatusMsg("success");
        baseResponse.setData(spareparts);
        baseResponse.setData(sparepartstype);
        return  baseResponse;
    }*/
