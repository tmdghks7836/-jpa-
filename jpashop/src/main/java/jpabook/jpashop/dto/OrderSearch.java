package jpabook.jpashop.dto;

import jpabook.jpashop.entity.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;
}
