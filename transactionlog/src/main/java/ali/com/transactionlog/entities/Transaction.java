package ali.com.transactionlog.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue
    private Integer id;
    
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;
}
