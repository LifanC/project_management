package com.project.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.sql.SQLException;
import java.util.*;
import com.project.entity.*;

@Controller
public class ProjectController {

	@Autowired
	private AngularRepository angularRepository;

	@GetMapping("index")
	public String index(ModelMap model) {
		return "index";
	}

	@GetMapping("projectall")
	public @ResponseBody ProjectListVO getAll() {
		List<Project> data = angularRepository.findAll();
		ProjectListVO vo = new ProjectListVO(data);
		return vo;
	}

	@PostMapping("projectadd")
	public @ResponseBody ProjectListVO save(Project project) throws SQLException {
		List<Project> datanumber = angularRepository.queryByNumber(project.getNumber());
		if (datanumber.size() == 0) {
			System.out.println("YES");
			angularRepository.save(project);
			System.out.println(project);
		} else if (datanumber.size() >= 1) {
			for (Project ex : datanumber) {
				System.out.println(ex);
				project.setId(ex.getId());
				System.out.println("更新");
				System.out.println(project);
				AngularImp set = new AngularImp();
				set.updateProjectData(project);
			}
		}
		List<Project> data = angularRepository.findAll();
		ProjectListVO vo = new ProjectListVO(data);
		return vo;
	}

	@PostMapping("delete")
	public @ResponseBody ProjectListVO delete(Project project) throws SQLException {
		List<Project> datadel = angularRepository.queryByNumberAndName(project.getNumber(), project.getName());
		for (Project ex : datadel) {
			System.out.println(ex);
			angularRepository.deleteById(ex.getId());
		}
		List<Project> data = angularRepository.findAll();
		ProjectListVO vo = new ProjectListVO(data);
		return vo;
	}

	@PostMapping("set")
	public @ResponseBody ProjectListVO set(Project Project) throws SQLException {
		List<Project> datafirst = angularRepository.queryById(Project.getId());
		ProjectCount c = new ProjectCount(0);
		c.setCount(Project.getCount());
		Integer f = c.getCount();
		datafirst.forEach(e -> {
			Integer b = e.getCount();
			Integer result = b - f;
			Project.setCount(result);
			AngularImp set = new AngularImp();
			try {
				set.updateCount(Project);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		});
		List<Project> data = angularRepository.findAll();
		ProjectListVO vo = new ProjectListVO(data);
		return vo;
	}
}
