package club.futurer.community.business.user.resolver;

import club.futurer.community.business.user.model.Grade;
import club.futurer.community.business.user.model.entity.User;
import com.coxautodev.graphql.tools.GraphQLResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserResolver implements GraphQLResolver<User> {
    private static final Logger logger = LoggerFactory.getLogger(UserResolver.class.getName());

    public String name(User user) {
        return user.getUserName();
    }

    public Long userId(User user) {
        return user.getId();
    }

    public String grade(User user) {
        return Grade.lookup(user.getGrade()).getDesc();
    }
}
