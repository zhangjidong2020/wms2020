package ERP.service.impl;

import ERP.mapper.CompanyMapper;
import ERP.pojo.Company;
import ERP.service.CompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements CompanyService {


    @Resource
    private CompanyMapper companyMapper;


    @Override
    public Company getCompanyByCompanyName(String companyName) {
        return companyMapper.getCompanyByCompanyName(companyName);
    }
}
