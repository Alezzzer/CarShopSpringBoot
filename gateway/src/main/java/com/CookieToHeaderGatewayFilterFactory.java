package com;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class CookieToHeaderGatewayFilterFactory extends AbstractGatewayFilterFactory<CookieToHeaderGatewayFilterFactory.Config> {

    public CookieToHeaderGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            HttpCookie cookie = exchange.getRequest().getCookies().getFirst(config.getCookieName());
            if (cookie != null) {
                exchange.getRequest().mutate().header(config.getHeaderName(), cookie.getValue()).build();
            }
            return chain.filter(exchange);
        };
    }

    public static class Config {
        private String cookieName;
        private String headerName;

        public String getCookieName() {
            return cookieName;
        }

        public void setCookieName(String cookieName) {
            this.cookieName = cookieName;
        }

        public String getHeaderName() {
            return headerName;
        }

        public void setHeaderName(String headerName) {
            this.headerName = headerName;
        }
    }
}
