/**
 * 
 */
package com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * A persisted Item.
 * 
 * @author AMD
 */
@Entity
public class Item {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   
   private String name;
   private String description;
   private Integer quantity;
   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name="location_id", nullable=true)
   private Location location;
   
   /**
    * Gets id.
    * @return the id
    */
   public Long getId() {
      return id;
   }
   
   /**
    * Sets id.
    * @param id the id to set
    */
   public void setId(Long id) {
      this.id = id;
   }
   
   /**
    * Gets name.
    * @return the name
    */
   public String getName() {
      return name;
   }
   
   /**
    * Sets name.
    * @param name the name to set
    */
   public void setName(String name) {
      this.name = name;
   }
   
   /**
    * Gets description.
    * @return the description
    */
   public String getDescription() {
      return description;
   }
   
   /**
    * Sets description.
    * @param description the description to set
    */
   public void setDescription(String description) {
      this.description = description;
   }
   
   /**
    * Gets quantity.
    * @return the quantity
    */
   public Integer getQuantity() {
      return quantity;
   }
   
   /**
    * Sets quantity.
    * @param quantity the quantity to set
    */
   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }
   
   /**
    * Gets location.
    * @return the location
    */
   public Location getLocation() {
      return location;
   }
   
   /**
    * Sets location.
    * @param location the location to set
    */
   public void setLocation(Location location) {
      this.location = location;
   }
}
