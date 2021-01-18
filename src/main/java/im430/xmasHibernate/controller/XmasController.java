package im430.xmasHibernate.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import im430.xmasHibernate.business.Child;
import im430.xmasHibernate.dao.AddressDAO;
import im430.xmasHibernate.dao.ChildDAO;
import im430.xmasHibernate.dao.GiftDAO;
import im430.xmasHibernate.business.Gift;
import im430.xmasHibernate.business.Address;


@Controller	
public class XmasController {
   
	@Autowired
	private ChildDAO childDAO;
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private GiftDAO giftDAO;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public void getAllChildren(Model model) {
		List<Child> children = childDAO.getAll();
		model.addAttribute("children", children);
	}
	
	@RequestMapping(value="childDetail", params="id", method=RequestMethod.GET)
	public void getChildDetail(@RequestParam("id") int childId, Model model) {
		Child child = childDAO.getById(childId);
		model.addAttribute("child", child);
	};
	
	@RequestMapping(value="addChild", method=RequestMethod.GET)
	public void addChild(Model model) {};
	
	@RequestMapping(value="addChild", method=RequestMethod.POST)
	public ModelAndView addChildPost(Model model, @RequestParam("childname") String name, @RequestParam("address") String text) {
		
		Address address = new Address();
		address.setText(text);
		addressDAO.saveOrUpdate(address);
		
		Child child = new Child();
		child.setName(name);
		address.addChild(child);
		
		childDAO.saveOrUpdate(child);
		
		return new ModelAndView("redirect:/xmas/list");
	};
	
	@RequestMapping(value="updateChild", params="entryId",method=RequestMethod.GET)
	public void updateChild(@RequestParam("entryId") int childId, Model model) {
		Child child = childDAO.getById(childId);
		model.addAttribute("child", child);
	};

	@RequestMapping(value="updateChild", method=RequestMethod.POST)
	public ModelAndView updateChildPost(Model model, @RequestParam("childname") String name, @RequestParam("id") int childId) {
		
		Child child = childDAO.getById(childId);
		child.setName(name);
		childDAO.saveOrUpdate(child);
		
		return new ModelAndView("redirect:/xmas/list");
		
	};
	
	@RequestMapping(value="deleteChild", method=RequestMethod.GET)
	public ModelAndView deletChild(Model model, @RequestParam("entryId") int childid) {
		
		Child child = childDAO.getById(childid);
		childDAO.delete(child);
		
		return new ModelAndView("redirect:/xmas/list");
	};
	
	@RequestMapping(value="updateAddress", method=RequestMethod.POST)
	public ModelAndView updateAddressPost(Model model,@RequestParam("childId") int childId,  @RequestParam("addressId") int addressId, @RequestParam("address") String text) {
		
		Address address = addressDAO.getById(addressId);
		address.setText(text);
		addressDAO.saveOrUpdate(address);
		
		return new ModelAndView("redirect:/xmas/childDetail?id="+ childId ); 
		
	};
	
	@RequestMapping(value="addGift", method=RequestMethod.GET)
	public void addGift( Model model, @RequestParam("childId") int childId) {
		model.addAttribute("childId", childId);
	};
	
	@RequestMapping(value="addGift", method=RequestMethod.POST)
	public ModelAndView addGiftPost(Model model, @RequestParam("childId") int childId, @RequestParam("giftdesc") String giftdesc) {
		
		Gift gift = new Gift();
		gift.setDescription(giftdesc);
		
		Child child = childDAO.getById(childId);
		child.addGift(gift);
		
		giftDAO.saveOrUpdate(gift);
		
		return new ModelAndView("redirect:/xmas/childDetail?id="+ childId ); 
		
	};
	
	@RequestMapping(value="deleteGift", method=RequestMethod.GET)
	public ModelAndView deleteGift( Model model, @RequestParam("childId") int childId, @RequestParam("giftId") int giftId) {
		Child child = childDAO.getById(childId);
		Set<Gift> gifts = child.getGifts();
		Gift currentGift = null;
		
		for (Gift gift : gifts) {
		    if(gift.getId() == giftId ) {
		    	currentGift = gift;
		    }
		}
		
		if(currentGift != null) {
			giftDAO.delete(currentGift);
		}
			
		return new ModelAndView("redirect:/xmas/childDetail?id="+ childId ); 
		
	};
	
	@RequestMapping(value="updateGift", method=RequestMethod.GET)
	public void updateGift( Model model, @RequestParam("childId") int childId, @RequestParam("giftId") int giftId) {
		Child child = childDAO.getById(childId);
		Set<Gift> gifts = child.getGifts();
		Gift currentGift = null;
		
		for (Gift gift : gifts) {
		    if(gift.getId() == giftId ) {
		    	currentGift = gift;
		    }
		}
		
		if(currentGift != null) {
			model.addAttribute("gift", currentGift);
		}
		
		model.addAttribute("childId", child);
	};
	
	@RequestMapping(value="updateGift", method=RequestMethod.POST)
	public ModelAndView updateGiftPost(Model model, @RequestParam("childId") int childId, @RequestParam("giftId") int giftId, @RequestParam("giftdesc") String giftdesc) {
		
		Child child = childDAO.getById(childId);
		Set<Gift> gifts = child.getGifts();
		Gift currentGift = null;
		
		for (Gift gift : gifts) {
		    if(gift.getId() == giftId ) {
		    	currentGift = gift;
		    }
		}
		
		currentGift.setDescription(giftdesc);
		
		giftDAO.saveOrUpdate(currentGift);
		
		return new ModelAndView("redirect:/xmas/childDetail?id="+ childId ); 
		
	};
	
	@RequestMapping(value="giftOverview", method=RequestMethod.GET)
	public void giftOverview(Model model) {
		
		List<Child> children = childDAO.getAll();
		
		model.addAttribute("children", children);
		
	};
	
}

