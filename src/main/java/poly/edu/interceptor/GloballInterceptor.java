package poly.edu.interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import poly.edu.service.ProductService;
import poly.edu.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class GloballInterceptor implements HandlerInterceptor {

    @Autowired
    ProductService productService;

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        request.setAttribute("data", productService.findByCategoryId());
        request.setAttribute("data1", productService.findByCategoryId1());
        request.setAttribute("data2", productService.findByCategoryId2());
    }
}
