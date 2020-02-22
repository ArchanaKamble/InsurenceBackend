package com.lti.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.entities.BikeModel;
import com.lti.entities.CarModel;
import com.lti.entities.Users;
import com.lti.exceptions.HrException;

@Repository
public class FetchVehicleDaoImp implements FetchVehicleDao {

	@PersistenceContext
	private EntityManager manager;
	
	public Map<String, Map<String,List<String>>> getCarList() throws HrException {
		String strQry = "from CarModel";
		Query qry = manager.createQuery(strQry);
		List<CarModel> lst=qry.getResultList();
		Map<String, Map<String,List<String>>> map = new HashMap<String, Map<String,List<String>>>();
		Map<String,List<String>> map2 = new HashMap<String,List<String>>();
		List<String> list = new ArrayList<String>();
		for(CarModel c : lst){
			map.put(c.getBrand(),map2);
			if(map.containsKey(c.getBrand())){
				map2.put(c.getModel(),list);
				if(map2.containsKey(c.getModel())){
					list.add(c.getVariant());

				}
							}
		}
//		 for(Map.Entry m:map.entrySet()){  
//			   System.out.println(m.getKey()+"-"+m.getValue());  
//			  }  
		return map;
	}
	public ArrayList<BikeModel> getBikeList() throws HrException {
		String strQry = "from BikeModel";
		Query qry = manager.createQuery(strQry);
		List<BikeModel> lst=qry.getResultList();
		return (ArrayList<BikeModel>) lst;
	}

}
