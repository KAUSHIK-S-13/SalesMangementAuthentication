package com.sales.management.Controller;

import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.BaseResponse.baseresp;
import com.sales.management.DTO.SparepartsDTO;
import com.sales.management.DTO.UserDTO;
import com.sales.management.Model.Spareparts;
import com.sales.management.Model.User;
import com.sales.management.ServiceImpl.SparepartsServiceImpl;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/spareparts")
@RestController
public class SparepartsController {

    @Autowired
    private SparepartsServiceImpl sparepartsserviceimpl;

    @PostMapping("/add")
    @Authorization(value="Bearer")
    public baseresp<Spareparts> addspareparts(@Valid @RequestBody SparepartsDTO sparepartsDTO) {
        baseresp<Spareparts> base=null;
        base=baseresp.<Spareparts>builder().Data(sparepartsserviceimpl.addSpareparts(sparepartsDTO)).build();
        return base ;
    }
   @GetMapping("/{offset}/{pageSize}/{sparepartsName}")
   @Authorization(value="Bearer")
   private APIResponse<Spareparts> getSparepartsWithPagination(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String sparepartsName) {
       return sparepartsserviceimpl.GetSparepartsWithPagination(offset, pageSize, sparepartsName);
   }


    @PutMapping("/update")
    @Authorization(value="Bearer")
    public baseresp<Optional<Spareparts>> updatespareparts(@RequestBody SparepartsDTO sparepartsDTO) {
       baseresp<Optional<Spareparts>> base=null;
       base=baseresp.<Optional<Spareparts>>builder().Data(sparepartsserviceimpl.updateSpareparts(sparepartsDTO)).build();
        return base ;
    }

    @GetMapping("/{id}")
    @Authorization(value="Bearer")
    public baseresp<Optional<Spareparts>> findsparepartsById(@PathVariable int id){
        baseresp<Optional<Spareparts>> base=null;
        base =baseresp.<Optional<Spareparts>>builder().Data(sparepartsserviceimpl.findSparepartsById(id)).build();
        return base;
    }

    @PutMapping("/delete")
    @Authorization(value="Bearer")
    public baseresp<Optional<Spareparts>> deletespareparts(@RequestBody SparepartsDTO sparepartsDTO) {
        baseresp<Optional<Spareparts>> base=null;
        base=baseresp.<Optional<Spareparts>>builder().Data(sparepartsserviceimpl.deleteSpareparts(sparepartsDTO)).build();
        return base ;
    }

}
