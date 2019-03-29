package club.futurer.community.business.user.service;

import club.futurer.community.business.user.dao.UserMapper;
import club.futurer.community.business.user.model.entity.User;
import club.futurer.community.business.user.model.entity.UserExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class.getName());

    @Autowired
    private UserMapper userMapper;

    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> findUsersByIds(List<Long> ids) {
        UserExample example = new UserExample();
        example.createCriteria().andIdIn(ids);
        return userMapper.selectByExample(example);
    }
}
