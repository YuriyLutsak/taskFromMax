package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(exclude = "product")
@Entity
public class ProductVersion {

   @Id
   @GeneratedValue(generator = "UUID")
   private UUID id;

   private String details;

   private String creator;

   private int version;

   @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private Product product;
}
