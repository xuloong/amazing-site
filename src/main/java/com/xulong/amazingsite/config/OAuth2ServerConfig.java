package com.xulong.amazingsite.config;


import com.xulong.amazingsite.common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * OAuth2ServerConfig
 *
 * @author xulong
 * @date 2018-07-11
 */
@Configuration
public class OAuth2ServerConfig {

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(ResourceServerSecurityConfigurer resources) {
            resources.resourceId(Constant.OAUTH2_RESOURCE_ID).stateless(true);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                    .and()
//                    .requestMatchers().anyRequest()
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
                    .antMatchers("/users1/**").access("#oauth2.hasScope('read') and hasRole('ROLE_USER')")
                    .antMatchers("/users1/**").authenticated()
                    .antMatchers("/users/**").permitAll();
        }
    }


    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

        @Autowired
        AuthenticationManager authenticationManager;
        @Autowired
        RedisConnectionFactory redisConnectionFactory;
        @Autowired
        UserDetailsService userDetailsService;
        @Autowired
        private TokenStore tokenStore;

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            //配置两个客户端,一个用于password认证一个用于client认证
            clients.inMemory()
                    .withClient(Constant.OAUTH2_CLIENT_ID1)
                    .resourceIds(Constant.OAUTH2_RESOURCE_ID)
                    .authorizedGrantTypes("client_credentials")
                    .authorities("oauth2")
                    .secret(Constant.OAUTH2_CLIENT_ID1_SECRET)
                    .and().withClient(Constant.OAUTH2_CLIENT_ID2)
                    .resourceIds(Constant.OAUTH2_RESOURCE_ID)
                    .authorizedGrantTypes("password", "refresh_token")
                    .authorities("oauth2")
                    .scopes("read", "write")
                    .secret(Constant.OAUTH2_CLIENT_ID2_SECRET)
                    .accessTokenValiditySeconds(Constant.OAUTH2_ACCESS_TOKEN_VALIDITY_SECONDS)
                    .refreshTokenValiditySeconds(Constant.OAUTH2_REFRESH_TOKEN_VALIDITY_SECONDS);
        }

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(tokenStore)
                    .authenticationManager(authenticationManager)
                    .userDetailsService(userDetailsService)
                    .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);

            endpoints.reuseRefreshTokens(true);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            //允许表单认证
            oauthServer.allowFormAuthenticationForClients();
        }

        @Bean
        public TokenStore tokenStore() {
            //使用内存的tokenStore
            return new InMemoryTokenStore();
            //使用Redis的tokenStore
            //return new RedisTokenStore(redisConnectionFactory);
        }

    }

}
