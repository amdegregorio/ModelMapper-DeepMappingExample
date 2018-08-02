/**
 * 
 */
package com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.dto;

/**
 * @author AMD
 *
 */
public class ItemDto {
   private Long id;
   private String name;
   private String description;
   private Integer quantity;
   private Long warehouseId;
   private String warehouseName;
   private Integer warehouseRowNumber;
   private String warehouseBinLabel;
   
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
    * Gets warehouseRowNumber.
    * @return the warehouseRowNumber
    */
   public Integer getWarehouseRowNumber() {
      return warehouseRowNumber;
   }
   
   /**
    * Sets warehouseRowNumber.
    * @param warehouseRowNumber the warehouseRowNumber to set
    */
   public void setWarehouseRowNumber(Integer warehouseRowNumber) {
      this.warehouseRowNumber = warehouseRowNumber;
   }
   
   /**
    * Gets warehouseBinLabel.
    * @return the warehouseBinLabel
    */
   public String getWarehouseBinLabel() {
      return warehouseBinLabel;
   }
   
   /**
    * Sets warehouseBinLabel.
    * @param warehouseBinLabel the warehouseBinLabel to set
    */
   public void setWarehouseBinLabel(String warehouseBinLabel) {
      this.warehouseBinLabel = warehouseBinLabel;
   }

   
   /**
    * Gets warehouseId.
    * @return the warehouseId
    */
   public Long getWarehouseId() {
      return warehouseId;
   }

   
   /**
    * Sets warehouseId.
    * @param warehouseId the warehouseId to set
    */
   public void setWarehouseId(Long warehouseId) {
      this.warehouseId = warehouseId;
   }

}
