package com.xidian.sso.service;

import com.xidian.common.pojo.TaotaoResult;
import com.xidian.pojo.TbUser;

public interface UserService {
    TaotaoResult checkData(String data, int type);
    TaotaoResult register(TbUser user);
    TaotaoResult login(String username, String password);
    TaotaoResult getUserByToken(String token);

}
