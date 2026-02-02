package com.aquarium.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aquarium.models.tables.BalanceMovement;
import com.aquarium.models.tables.OrderDetail;
import com.aquarium.models.tables.OrderDetailBack;
import com.aquarium.repositories.OrderDetailBackRepository;

@Service
public class OrderDetailBackService {

    @Autowired
    private OrderDetailBackRepository orderDetailBackRepository;

    @Autowired
    private BalanceMovementService balanceMovementService;

    @Autowired
    private BalanceMovementTypeService balanceMovementTypeService;
    
    public void returnItem(OrderDetail detail) {
        OrderDetailBack back = new OrderDetailBack();
            back.setOrderDetail(detail);
            // The value is what the client paid: totalPrice
            back.setValue(detail.getBackValue());
            save(back);

            BalanceMovement movement = new BalanceMovement();
            movement.setAmount(detail.getBackValue());
            movement.setType(balanceMovementTypeService.findById(2L)); // 2 = Rendu
            balanceMovementService.save(movement);
    }

    public OrderDetailBack save(OrderDetailBack orderDetailBack) {
        return orderDetailBackRepository.save(orderDetailBack);
    }

    public double getTotalReturns() {
        Double total = orderDetailBackRepository.sumValue();
        return total != null ? total : 0.0;
    }
}
