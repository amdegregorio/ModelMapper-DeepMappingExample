/**
 * 
 */
package com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.domain.Location;
import com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.repository.LocationRepository;

/**
 * @author AMD
 *
 */
@Controller
public class LocationController {
   @Autowired
   private LocationRepository locationRepository;

   /**
    * Lists all the location.
    * 
    * @param model
    * @return
    */
   @RequestMapping("/location/")
   public String listAll(Model model) {
      List<Location> locations = locationRepository.findAll();
      
      //List<ItemDto> itemDtos = items.stream().map(item -> modelMapper.map(item, ItemDto.class)).collect(Collectors.toList());
      model.addAttribute("locations", locations);
      return "location/list";
   }
}
