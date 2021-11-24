package com.nttdata.customer.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("customerType")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerType {
    @Id
    private String id;
    private String type;
}
