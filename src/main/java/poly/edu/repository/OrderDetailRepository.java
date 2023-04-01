package poly.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import poly.edu.domain.OrderDetail;


import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query("SELECT o FROM OrderDetail o WHERE o.order.id = ?1")
    List<OrderDetail> findByOrderId(Long id);
}
