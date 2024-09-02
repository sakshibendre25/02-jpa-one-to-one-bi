package com.sakshi.cruuddemo;

import com.sakshi.cruuddemo.dao.AppDAO;
import com.sakshi.cruuddemo.entity.Instructor;
import com.sakshi.cruuddemo.entity.InstructorDetail;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruuddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruuddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return  runner -> {
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);
			
			//findInstructorDetail(appDAO);

			//deleteInstructorDetail(appDAO);
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int theId = 4;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailsById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!");

	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("chad", "Darby", "darby@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Luv 2 code!!!");
*/


		// create the instructor
		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");


		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// NOTE: This will ALSO save the details object
		// because of CascadeType.ALL
		//
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
