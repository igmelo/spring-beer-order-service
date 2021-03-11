package igor.sfg.beer.order.service.web.mappers;

import igor.sfg.beer.order.service.domain.Customer;
import igor.sfg.brewery.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface CustomerMapper {
    CustomerDto customerToDto(Customer customer);

    Customer dtoToCustomer(Customer dto);
}