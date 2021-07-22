package com.mercadolibre.cupon.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "item")
public class ItemEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "item_id")
    private String itemId;

    @Column(name = "id")
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Double price;

}
