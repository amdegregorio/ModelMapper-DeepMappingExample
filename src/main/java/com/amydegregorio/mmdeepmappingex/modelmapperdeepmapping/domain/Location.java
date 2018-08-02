/**
 * 
 */
package com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * A persisted Location.
 * 
 * @author AMD
 */
@Entity
public class Location {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long id;
   
   private String warehouseName;
   private Integer rowNumber;
   private String binLabel;
   
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
    * Gets warehouseName.
    * @return the warehouseName
    */
   public String getWarehouseName() {
      return warehouseName;
   }
   
   /**
    * Sets warehouseName.
    * @param warehouseName the warehouseName to set
    */
   public void setWarehouseName(String warehouseName) {
      this.warehouseName = warehouseName;
   }
   
   /**
    * Gets rownNumber.
    * @return the rownNumber
    */
   public Integer getRowNumber() {
      return rowNumber;
   }
   
   /**
    * Sets rownNumber.
    * @param rownNumber the rownNumber to set
    */
   public void setRowNumber(Integer rownNumber) {
      this.rowNumber = rownNumber;
   }
   
   /**
    * Gets binLabel.
    * @return the binLabel
    */
   public String getBinLabel() {
      return binLabel;
   }
   
   /**
    * Sets binLabel.
    * @param binLabel the binLabel to set
    */
   public void setBinLabel(String binLabel) {
      this.binLabel = binLabel;
   }
}
