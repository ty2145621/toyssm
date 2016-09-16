package com.toy.shiro.realm;

import com.toy.dao.ToyAdmin;
import com.toy.service.IAdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;


/**
 * Created by toy on 2016/9/16.
 */
public class AdminRealm extends AuthorizingRealm {
    @Resource
    private IAdminService adminService;

    @Override
    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(new HashSet<String>(){
            {
                add("user");
                add("admin");
            }
        });

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String username = (String)token.getPrincipal();
        ToyAdmin toyAdmin = null;
        try {
            toyAdmin = adminService.findByName(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(toyAdmin == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        /*if(Boolean.TRUE.equals(toyAdmin.getLocked())) {
            throw new LockedAccountException(); //帐号锁定
        }*/

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                toyAdmin.getUsername(), //用户名
                toyAdmin.getPassword(), //密码
                /*ByteSource.Util.bytes(toyAdmin.getCredentialsSalt()),*///salt=username+salt
                getName()  //realm name
        );
        return authenticationInfo;
    }
}