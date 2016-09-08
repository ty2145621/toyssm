package com.toy.service.impl;

import com.toy.dao.ToyAdminExample;
import com.toy.dao.ToyUser;
import com.toy.dao.ToyUserExample;
import com.toy.mapper.ToyUserMapper;
import com.toy.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by toy on 2016/8/3.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    @Resource
    ToyUserMapper toyUserMapper;

    @Override
    public int count(HashMap<String, Object> hashMap)
    {
        return toyUserMapper.count(hashMap);
    }

    @Override
    public List<ToyUser> findUsers(HashMap<String, Object> hashMap) throws Exception {
        return toyUserMapper.selectUsers(hashMap);
    }

    @Override
    public int update(ToyUser user)
    {
        return toyUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public ToyUser findById(int id)
    {
        return toyUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int add(ToyUser user)
    {
        return toyUserMapper.insertSelective(user);
    }

    @Override
    public List<ToyUser> selectAll() {
        ToyUserExample toyUserExample = new ToyUserExample();
        ToyUserExample.Criteria criteria = toyUserExample.createCriteria();

        return toyUserMapper.selectByExample(toyUserExample);
    }
}
