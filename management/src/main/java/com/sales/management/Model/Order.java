package com.sales.management.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private int orderId;

    @Column(name="order_quantity")
    private int orderQuantity;

    @Column(name="order_destination")
    private String orderDestination;

    @Column(name="is_active",columnDefinition = "integer default 0")
    private int isActive;

    @Column(name="is_delete",columnDefinition = "integer default 0")
    private int isDelete;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name = "modified_at")
    private LocalDateTime updateDateTime;

    @ManyToOne
    @JoinColumn(name = "fk_spareparts_id")
    private Spareparts sparepartss;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User users;

}
