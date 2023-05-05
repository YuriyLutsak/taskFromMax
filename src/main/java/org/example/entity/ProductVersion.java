package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(exclude = "product")
@Table(name = "product_version")
@Entity
public class ProductVersion {

   @Id
   @GeneratedValue(generator = "UUID")
   private UUID id;

   @Column(name = "details")
   private String details;

   @Column(name = "creator")
   private String creator;

   @Column(name = "version")
   private int version;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Product product;
}
