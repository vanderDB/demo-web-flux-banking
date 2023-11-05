package com.banking.demowebflux.web.resolver;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.reactive.BindingContext;
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PageableHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final String DEFAULT_PAGE = "0";
    private static final String DEFAULT_SIZE = "10";
    private static final Integer MAX_SIZE = 50;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Pageable.class.equals(parameter.getParameterType());
    }

    @Override
    public Mono<Object> resolveArgument(MethodParameter methodParameter, BindingContext bindingContext,
                                        ServerWebExchange serverWebExchange) {
        List<String> pageValues = serverWebExchange.getRequest().getQueryParams().getOrDefault("page", List.of(DEFAULT_PAGE));
        List<String> sizeValues = serverWebExchange.getRequest().getQueryParams().getOrDefault("size", List.of(DEFAULT_SIZE));

        String page = pageValues.get(0);

        List<String> sortParams = serverWebExchange.getRequest().getQueryParams().get("sort");
        Sort sort = Sort.unsorted();
        List<Sort.Order> orders = new ArrayList<>();

        for (String sortParam : sortParams) {
            if (sortParam != null) {
                String[] parts = sortParam.split(",");
                if (parts.length == 2) {
                    String property = parts[0];
                    Sort.Direction direction = Sort.Direction.fromString(parts[1]);

                    Sort.Order order = new Sort.Order(direction, property);
                    orders.add(order);
                }
            }
        }

        if (orders.size() > 0) {
            sort = Sort.by(orders);
        }

        return Mono.just(
                PageRequest.of(
                        Integer.parseInt(page),
                        Math.min(Integer.parseInt(sizeValues.get(0)),
                                MAX_SIZE), sort
                )
        );
    }
}
