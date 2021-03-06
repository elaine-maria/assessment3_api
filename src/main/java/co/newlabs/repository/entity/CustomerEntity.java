package co.newlabs.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerEntity {
    private int id;
    private String name;
    private double lat;
    private double lon;
}
