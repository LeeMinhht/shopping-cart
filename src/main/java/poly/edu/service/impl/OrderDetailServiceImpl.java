package poly.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poly.edu.domain.OrderDetail;
import poly.edu.repository.OrderDetailRepository;
import poly.edu.service.OrderDetailService;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }




    @Override
    public List<OrderDetail> findByOrderId(Long id) {
        return orderDetailRepository.findByOrderId(id);
    }


}
