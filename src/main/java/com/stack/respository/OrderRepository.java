package com.stack.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stack.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{

	List<Orders> findAllByuserId(Integer userId);

}
