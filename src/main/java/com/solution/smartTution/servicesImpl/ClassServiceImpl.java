package com.solution.smartTution.servicesImpl;

import com.solution.smartTution.model.TutionClass;
import com.solution.smartTution.repositories.ClassInfoRepo;
import com.solution.smartTution.services.ClassService;
import com.solution.smartTution.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClassServiceImpl implements ClassService {

	@Autowired
	private ClassInfoRepo classInfoRepo;

	@Override
	public Iterable<TutionClass> fetch() {
		return classInfoRepo.findAll();
	}

	@Override
	public ResponseEntity<TutionClass> fetchSingleItem(int id) {
		try {
			TutionClass classinfo = classInfoRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("CUSTOMER WITH ID = " + id + " IS NOT FOUND"));
			return ResponseEntity.ok().body(classinfo);

		} catch (ResourceNotFoundException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<TutionClass> insert(TutionClass classinfo) {
		try {
			classInfoRepo.save(classinfo);
			return ResponseEntity.ok().body(classinfo);
		} catch (Exception E) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	public Map<String, Boolean> remove(int id) {
		Map<String, Boolean> map = new HashMap<>();
		try {
			TutionClass classinfo =classInfoRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("class with id = " + id + "is not found"));
			map.put("Deleted Successfully", true);
			return map;
		}catch(Exception E) {
			map.put("Delete Unsuccessful", false);
			return map;
		}
	}

	@Override
	public ResponseEntity<TutionClass> update(int classinfo_id, TutionClass classinfo) {
		try {
			TutionClass classinfo2 = classInfoRepo.findById(classinfo_id).orElseThrow(
					() -> new ResourceNotFoundException("class with id = " + classinfo_id + "is not found"));
			classinfo2.setName(classinfo.getName());
			classinfo2.setFee(classinfo.getFee());
			classinfo2.setSubject(classinfo.getSubject());
			classinfo2.setTeacher(classinfo.getTeacher());
			classinfo2.setTime(classinfo.getTime());
			classinfo2.setUsers(classinfo.getUsers());
			classinfo2.setLessons(classinfo.getLessons());

			return ResponseEntity.ok().body(classinfo2);

		} catch (Exception E) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}
}
