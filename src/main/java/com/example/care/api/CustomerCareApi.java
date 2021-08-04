package com.example.care.api;

import com.example.care.entity.Account;
import com.example.care.entity.Complain;
import com.example.care.entity.Department;
import com.example.care.service.CustomerCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1")
public class CustomerCareApi {
    @Autowired
    private CustomerCareService customerCareService;

    //-	Chức năng thêm/sửa/xóa thông tin phòng ban:
    @RequestMapping(value = "/createDepartment", method = RequestMethod.POST)
    public Department createDep (@RequestBody Department department){
        return customerCareService.createDeprecated(department);
    }
    @RequestMapping(value = "/editDepartment/{id}", method = RequestMethod.PUT)
    public Department editDep(@PathVariable Long id, @RequestBody Department updateDepartment){
        return customerCareService.editDeprecated(id,updateDepartment);
    }
    @RequestMapping(value = "/deleteDepartment/{id}", method = RequestMethod.DELETE)
    public String deleteDep(@PathVariable Long id){
        return customerCareService.deleteDeprecated(id);
    }
    //-----//
    //-	Chức năng ghi nhận ý kiến KH
    @RequestMapping(value = "/createComplain", method = RequestMethod.POST)
    public Complain createCom (@RequestBody Complain complain){
        return customerCareService.createComplain(complain);
    }
    //-----//
    //-	Quản lý các khiếu nại từ các thuê bao theo Ticket
    @RequestMapping(value = "/getAllComplain", method = RequestMethod.GET)
    public List<Complain> listAllComplain (){
        return customerCareService.listAllComplain();
    }
    //-----//
    //-	TÌm kiếm theo Ticket và Phone
    @RequestMapping(value = "/findTicketorPhone", method = RequestMethod.GET)
    public List<Complain> getTicketOrPhone (@RequestParam(defaultValue = "") String ticket,@RequestParam(defaultValue = "") String phone){
        return customerCareService.findTicketOrPhone(ticket, phone);
    }
    //-	Hiển thị toàn bộ phòng ban
    @RequestMapping(value = "/findAllDepartment", method = RequestMethod.GET)
    public List<Department> listAllDepartment (){
        return customerCareService.listAllDepartment();
    }
    //-----//
}
