package com.change.projects.book.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "productid")
    private int productid;
    @Column(name = "producname")
    private String productname;
    @Column(name = "qty")
    private int qty;
    @Column(name = "price")
    private int price;
    @Column(name = "image")
    private String image;

}
