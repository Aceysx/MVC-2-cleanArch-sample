package cn.acey.mvc2cleanarch.auth;

import cn.acey.mvc2cleanarch.models.User;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AuthResolver implements HandlerMethodArgumentResolver {

    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(Auth.class) != null;
    }

    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {

        String roleStr = webRequest.getHeader("roles");
        String id = webRequest.getHeader("id");

        List<Integer> roles = Arrays.stream(roleStr.split(","))
            .map(Integer::valueOf)
            .collect(Collectors.toList());
        return new User(Long.parseLong(id), roles);
    }
}
