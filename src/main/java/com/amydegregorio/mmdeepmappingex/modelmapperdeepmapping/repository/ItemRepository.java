/**
 * 
 */
package com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.domain.Item;

/**
 * @author AMD
 *
 */
public interface ItemRepository extends JpaRepository<Item, Long> {

}
