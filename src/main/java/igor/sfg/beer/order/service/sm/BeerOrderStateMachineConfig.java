package igor.sfg.beer.order.service.sm;

import igor.sfg.beer.order.service.domain.BeerOrderEventEnum;
import igor.sfg.beer.order.service.domain.OrderStatusEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class BeerOrderStateMachineConfig extends StateMachineConfigurerAdapter<OrderStatusEnum, BeerOrderEventEnum>{
    @Override
    public void configure(StateMachineStateConfigurer<OrderStatusEnum, BeerOrderEventEnum> states) throws Exception {
        states.withStates()
                .initial(OrderStatusEnum.NEW)
                .states(EnumSet.allOf(OrderStatusEnum.class))
                .end(OrderStatusEnum.PICKED_UP)
                .end(OrderStatusEnum.DELIVERED)
                .end(OrderStatusEnum.DELIVERY_EXCEPTION)
                .end(OrderStatusEnum.VALIDATION_EXCEPTION)
                .end(OrderStatusEnum.ALLOCATION_EXCEPTION);

    }
}
