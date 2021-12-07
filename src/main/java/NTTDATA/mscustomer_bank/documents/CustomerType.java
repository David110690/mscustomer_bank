package NTTDATA.mscustomer_bank.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document("customerType")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerType {
    @Id
    private String id;

    @NotEmpty
    private String type;
}
