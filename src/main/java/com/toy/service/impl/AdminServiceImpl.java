package com.toy.service.impl;

import com.toy.dao.ToyAdmin;
import com.toy.dao.ToyAdminExample;
import com.toy.dao.ToyUser;
import com.toy.mapper.ToyAdminMapper;
import com.toy.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by toy on 2016/8/2.
 */
@Service
public class AdminServiceImpl implements IAdminService{

    @Resource
    ToyAdminMapper toyAdminMapper;

    @Override
    public List<ToyAdmin> login(ToyAdminExample toyAdminExample) throws Exception
    {
        List<ToyAdmin> result = toyAdminMapper.selectByExample(toyAdminExample);
        return result;
    }

    @Override
    public ToyAdmin findByName(String username) throws Exception
    {
        return toyAdminMapper.findByName(username);
    }
}
