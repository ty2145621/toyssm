package com.toy.service;

import com.toy.dao.ToyUser;

import java.util.HashMap;
import java.util.List;

/**
 * Created by toy on 2016/8/3.
 */
public interface IUserService {

    ToyUser findById(int id);

    int update(ToyUser user);

    int add(ToyUser user);

    List<ToyUser> findUsers(HashMap<String, Object> hashMap) throws Exception;

    int count(HashMap<String, Object> hashMap);

    List<ToyUser> selectAll();
}
