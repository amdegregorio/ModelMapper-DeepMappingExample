/**
 * 
 */
package com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.domain.Item;
import com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.dto.ItemDto;
import com.amydegregorio.mmdeepmappingex.modelmapperdeepmapping.repository.ItemRepository;

/**
 * MVC Controller for Item actions.
 * 
 * @author AMD
 */
@Controller
public class ItemController {
   @Autowired
   private ItemRepository itemRepository;
   private ModelMapper modelMapper;
   
   /**
    * Constructs an ItemController with the injected ModelMapper instance.
    * <br>
    * Adds custom mappings to the instance.
    * 
    * @param modelMapper injected ModelMapper instance.
    */
   @Autowired
   public ItemController(ModelMapper modelMapper) {
      this.modelMapper = modelMapper;
      this.modelMapper.addMappings(warehouseFieldMapping);
      this.modelMapper.addMappings(warehouseMapping);
   }
   
   /**
    * Lists all the items.
    * 
    * @param model
    * @return
    */
   @RequestMapping("/")
   public String listAll(Model model) {
      List<Item> items = itemRepository.findAll();
      
      List<ItemDto> itemDtos = items.stream().map(item -> modelMapper.map(item, ItemDto.class)).collect(Collectors.toList());
      model.addAttribute("items", itemDtos);
      return "item/list";
   }
   
   /**
    * Goes to the page for adding an item.
    * 
    * @param itemDto
    * @param model
    * @return
    */
   @RequestMapping(value="/item/add", method=RequestMethod.GET)
   public String addItem(ItemDto itemDto, Model model) {
      model.addAttribute("action", "item/add");
      return "item/entry";
   }
   
   /**
    * Saves a new item if valid.
    * 
    * @param itemDto
    * @param bindingResult
    * @param model
    * @return
    */
   @RequestMapping(value="/item/add",  params={"save"}, method=RequestMethod.POST)
   public String saveNewItem(@Valid ItemDto itemDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         model.addAttribute("action", "item/add");
         return "item/entry";
      }
      
      
      Item item = modelMapper.map(itemDto, Item.class);
      itemRepository.save(item);
      return "redirect:/";
   }
   
   /**
    * Cancels the add item request and goes back to the list without saving.
    * 
    * @return
    */
   @RequestMapping(value="/item/add", params={"cancel"}, method=RequestMethod.POST)
   public String cancelNewItem() {
      return "redirect:/";
   }
   
   @RequestMapping(value="/item/edit", method=RequestMethod.GET)
   public String editItem(ItemDto itemDto, Model model, @RequestParam("id") Long id) {
      model.addAttribute("action", "item/edit");
      Item item = itemRepository.getOne(id);
      itemDto = modelMapper.map(item, ItemDto.class);
      model.addAttribute("itemDto", itemDto);
      return "item/entry";
   }
   
   @RequestMapping(value="/item/edit",  params={"save"}, method=RequestMethod.POST)
   public String saveItem(@Valid ItemDto itemDto, BindingResult bindingResult, Model model) {
      if (bindingResult.hasErrors()) {
         model.addAttribute("action", "item/edit");
         return "item/entry";
      }
      
      Item item = modelMapper.map(itemDto, Item.class);
      itemRepository.save(item);
      return "redirect:/";
   }
   
   @RequestMapping(value="/item/edit", params={"cancel"}, method=RequestMethod.POST)
   public String cancelItem() {
      return "redirect:/";
   }
   
   /**
    * Custom mapping for deep mapping between the input form with the warehouse information
    * flattened out into the Location object in the item entity.
    */
   PropertyMap<ItemDto, Item> warehouseMapping = new PropertyMap<ItemDto, Item>() {
      protected void configure() {
         map().getLocation().setId(source.getWarehouseId());
         map().getLocation().setWarehouseName(source.getWarehouseName());
         map().getLocation().setRowNumber(source.getWarehouseRowNumber());
         map().getLocation().setBinLabel(source.getWarehouseBinLabel());
      }
   };
   
   /**
    * Custom mapping for deep mapping between the Location object in the item entity
    * into the flattened fields in the DTO object.
    */
   PropertyMap<Item, ItemDto> warehouseFieldMapping = new PropertyMap<Item, ItemDto>() {
      protected void configure() {
         map().setWarehouseId(source.getLocation().getId());
         map().setWarehouseName(source.getLocation().getWarehouseName());
         map().setWarehouseRowNumber(source.getLocation().getRowNumber());
         map().setWarehouseBinLabel(source.getLocation().getBinLabel());
      }
   };
}
