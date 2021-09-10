package com.sales.management.Controller;

import com.sales.management.BaseResponse.BaseResponse;
import com.sales.management.BaseResponse.baseresp;
import com.sales.management.DTO.SparepartstypeDTO;
import com.sales.management.DTO.UserDTO;
import com.sales.management.Model.Sparepartstype;
import com.sales.management.Model.User;
import com.sales.management.ServiceImpl.SparepartstypeServiceImpl;
import io.swagger.annotations.Authorization;
import javafx.scene.chart.PieChartBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RequestMapping("/sparepartstype")
@RestController
public class SparepartstypeController {

    @Autowired
    private SparepartstypeServiceImpl sparpartstypeserviceimpl;

   @PostMapping("/add")
   @Authorization(value="Bearer")
   public baseresp<Sparepartstype> addsparepartstype(@Valid @RequestBody SparepartstypeDTO sparepartstypeDTO) {
       baseresp<Sparepartstype> base=null;
       base=baseresp.<Sparepartstype>builder().Data(sparpartstypeserviceimpl.addSparepartstype(sparepartstypeDTO)).build();
       return base ;
    }

    @PutMapping("/update")
    @Authorization(value="Bearer")
    public baseresp<Optional<Sparepartstype>> updatesparepartstype(@RequestBody SparepartstypeDTO sparepartstypeDTO) {
        baseresp<Optional<Sparepartstype>> base=null;
        base=baseresp.<Optional<Sparepartstype>>builder().Data(sparpartstypeserviceimpl.updateSparepartstype(sparepartstypeDTO)).build();
        return base ;
    }


    @GetMapping("/getall")
    @Authorization(value="Bearer")
    public baseresp<List<Sparepartstype>> listall(){
        baseresp<List<Sparepartstype>> base=null;
        base =baseresp.<List<Sparepartstype>>builder().Data(sparpartstypeserviceimpl.Listall()).build();
        return base;
    }


   @PutMapping("/delete")
   @Authorization(value="Bearer")
   public baseresp<Optional<Sparepartstype>> deletesparepartstype(@RequestBody SparepartstypeDTO sparepartstypeDTO) {
       baseresp<Optional<Sparepartstype>> base=null;
       base=baseresp.<Optional<Sparepartstype>>builder().Data(sparpartstypeserviceimpl.deleteSparepartstype(sparepartstypeDTO)).build();
       return base ;
    }
}
