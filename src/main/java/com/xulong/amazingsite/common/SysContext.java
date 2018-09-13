package com.xulong.amazingsite.common;

import com.xulong.amazingsite.config.MyUserDetails;
import com.xulong.amazingsite.model.User;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.beans.ConstructorProperties;

/**
 * SysContext
 *
 * @author xulong
 * @date 2017/10/27
 */
public class SysContext {

    private static final Logger logger = Logger.getLogger(SysContext.class);

    private User user;

    private static ThreadLocal<SysContext> threadLocal = new ThreadLocal<SysContext>();

    public static void initializeContext(HttpServletRequest request) throws BizException {

        if (request == null) {

            logger.warn("HttpServletRequest is empty!");

        } else {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null) {

//                String authorization = request.getHeader(Constant.OAUTH2_TOKEN_NAME);
//                if (!authorization.contains(Constant.OAUTH2_TOKEN_TYPE)) {
//                    throw new BizException("Unauthorized", 401);
//                }

                MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();

                SysContext.SysContextBuilder builder = builder();
                User currentUser = userDetails.getUser();
                builder.user(currentUser);
                threadLocal.set(builder.build());

            }

        }

    }

    public static User getCurrentUser() {

        SysContext sysContext = (SysContext) threadLocal.get();

        if (sysContext == null) {

            logger.warn("UserContext is empty!");
            return null;

        } else {

            return sysContext.getUser();

        }

    }

    public static SysContext.SysContextBuilder builder() {
        return new SysContext.SysContextBuilder();
    }

    public User getUser() {
        return this.user;
    }

    @ConstructorProperties({"user"})
    public SysContext(User user) {
        this.user = user;
    }

    public static class SysContextBuilder {

        private User user;

        SysContextBuilder() {
        }

        public SysContext.SysContextBuilder user(
                User user) {
            this.user = user;
            return this;
        }

        public SysContext build() {
            return new SysContext(this.user);
        }

        @Override
        public String toString() {
            return "SysContext.SysContextBuilder(user=" + this.user + ")";
        }

    }

    public static void remove() {
        threadLocal.remove();
    }

}
