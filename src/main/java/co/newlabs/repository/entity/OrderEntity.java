package co.newlabs.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderEntity {
    private int id;
    private int customerid;
    private int complete;
}
