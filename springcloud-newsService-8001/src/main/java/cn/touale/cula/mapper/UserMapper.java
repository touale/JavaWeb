package cn.touale.cula.mapper;

import cn.touale.cula.entity.NewsUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Touale
 * @description UserMapper
 * @date 2021/12/31 15:33
 */
@Mapper
public interface UserMapper {
    Integer tryLogin(NewsUser newUser);
}
