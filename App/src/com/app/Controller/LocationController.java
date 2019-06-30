package com.app.Controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.Util.LocationUtil;
import com.app.model.Location;
import com.app.service.ILocationService;

@Controller
public class LocationController {
   @Autowired
   private ILocationService service;
   @Autowired
   private ServletContext sc;
   @Autowired
   private LocationUtil locutil;
   
   @RequestMapping("regloc")
   public String showReg(){
	   return "LocationRegister";
   }
   @RequestMapping(value="/saveLoc",method=RequestMethod.POST)
   public String insertLoc(@ModelAttribute("location")Location loc,ModelMap map){
	   int locId=service.SaveLocation(loc);
	   String info="Save with:"+locId;
	   map.addAttribute("Msg",info);
	   return "LocationRegister";
   }
   @RequestMapping("/getAlllocs")
   public String getData(ModelMap map){
	   List<Location> locs=service.getAllLocations();
	   map.addAttribute("locs",locs);
	   return "LocationData";
   }
   @RequestMapping("deleteLoc")
   public String delLoc(@RequestParam("locId")int loc){
	   service.DeleteLocation(loc);
	   return "redirect:getAlllocs";
   }
   @RequestMapping("editLoc")
   public String showEdit(@RequestParam("locId")int locId,ModelMap map){
	   Location loc=service.getLocationById(locId);
	   map.addAttribute("loc", loc);
	   return "LocationDataEdit";
   }
   @RequestMapping(value="updateLoc",method=RequestMethod.POST)
   public String updateLoc(@ModelAttribute("location")Location loc){
	   service.UpdateLocation(loc);
	   return "redirect:getAlllocs";
   }
 	@RequestMapping("locExcel")
 	public String doExcelExport(ModelMap map){
 		List<Location> locList=service.getAllLocations();
 		map.addAttribute("locList", locList);
 		return "LocExcelView";
 	}
 	
 	@RequestMapping("locPdf")
 	public String doPdfExport(ModelMap map){
 		List<Location> locList=service.getAllLocations();
 		map.addAttribute("locList", locList);
 		return "LocPdfView";
 	}
 	@RequestMapping("/locReport")
 	public String generateCharts(){
 		String path=sc.getRealPath("/");
 		List<Object[]> data=service.getLocTypeAndCount();
 		locutil.generatePieChart(path,data);
 		locutil.generateBarChart(path,data);
 		return"LocationReport";
 	}

}
