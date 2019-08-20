package com.imooc.springbootdemo.repositpry;

import com.imooc.springbootdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  代表这是一个User的仓储
 *  {@link User} {@link Repository}
 *
 */
@Repository
public class UserRepository {

    //内存形的存储方式
    private final static ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<Integer, User>();

    //自增参数
    private final static AtomicInteger idGenarator = new AtomicInteger();

    public boolean save(User user){
        //生成ID
        Integer id = idGenarator.incrementAndGet();
        //设置ID
        user.setId(id);
        return repository.put(id,user) != null;
    }
}
