package com.toy.service;

import com.toy.dao.ToyAdmin;
import com.toy.dao.ToyAdminExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by toy on 2016/8/2.
 */

public interface IAdminService {
    List<ToyAdmin> login(ToyAdminExample toyAdminExample) throws Exception;
}
