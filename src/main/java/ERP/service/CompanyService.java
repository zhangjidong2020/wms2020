package ERP.service;

import ERP.pojo.Company;
import com.baomidou.mybatisplus.extension.service.IService;

public interface CompanyService extends IService<Company> {

    //根据公司名查询公司是否已存在
    Company getCompanyByCompanyName(String companyName);

}
