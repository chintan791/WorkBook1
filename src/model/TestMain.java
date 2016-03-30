package model;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;


import model.DBUtil; 

public class TestMain { 
	public static void main(String[] args) { 


		Scanner keyboard = new Scanner(System.in);

		System.out.print("What is the id?");
		int id = keyboard.nextInt();


		EntityManager em = DBUtil.getEmFactory().createEntityManager(); 
		try { 
			model.Gradebook hey = em.find(model.Gradebook.class, (long)id); 
			System.out.println(hey.getGrade()); 
		} catch (Exception e)
		{ 
			System.out.println(e); 
		} finally 
		{ 
			em.close(); 
			System.out.println("cerrado!"); 
		} 


		/*
System.out.println("Select one of the following: ");
System.out.println("1. All assignments by a student");
System.out.println("2. All assignments of a particular type by anyone");
System.out.println("3. All assignments of a particular type by a particular student");
System.out.println("4. The average for a student by assignment type");
System.out.println("5. The highest and lowest grade for a particular assignment type");
int selection = keyboard.nextInt();
		 */


		//Assignments from a student


		List<Gradebook> fullbook = selectGrades();
		for(Gradebook gs:fullbook)
		{
			System.out.print("This student submitted: ");
			System.out.println(gs.getAssignmentname());
		}


		//Assignments of a type

		List<Gradebook> fullbook2 = selectType();
		for(Gradebook gs:fullbook2)
		{
			System.out.print("This student who submitted type selected: ");
			System.out.println(gs.getStudentid());
		}

		//particular assignment type by particular student

		List<Gradebook> fullbook3 = selectTypeStudent();
		for(Gradebook gs:fullbook3)
		{
			System.out.print("This student & type: ");
			System.out.println(gs.getGrade());
		}




		// Average by assignment type
		List<Gradebook> fullbook4 = selectAvg();
		for(Gradebook gs:fullbook4)
		{

			System.out.print("This student & type: ");
			System.out.println(gs.getGrade());
		}




	}



	public static List<Gradebook> selectGrades()
	{
		EntityManager em= DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT d from Gradebook d " + 
				"WHERE d.studentid= 1007";
		TypedQuery<Gradebook> q= em.createQuery(qString, Gradebook.class);

		List<Gradebook> gradebooks;
		try
		{
			gradebooks = q.getResultList();
			if (gradebooks == null || gradebooks.isEmpty())
				gradebooks=null;
		} 
		finally
		{
			em.close();
		}
		return gradebooks;
	}






	public static List<Gradebook> selectType()
	{

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Select type 'quiz' 'assignment'  'test'  'Project'");
		String type = keyboard.next();

		EntityManager em= DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT d from Gradebook d " + 
				"WHERE d.assignmenttype= "+ type;
		TypedQuery<Gradebook> q= em.createQuery(qString, Gradebook.class);

		List<Gradebook> gradebooks;
		try
		{
			gradebooks = q.getResultList();
			if (gradebooks == null || gradebooks.isEmpty())
				gradebooks=null;
		} 
		finally
		{
			em.close();
		}
		return gradebooks;
	}



	public static List<Gradebook> selectTypeStudent()
	{

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Select student id: ");
		int id = keyboard.nextInt();

		System.out.print("Select assignmenttype: 'quiz' 'assignment'  'test'  'Project' ");
		String type = keyboard.next();

		EntityManager em= DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT d from Gradebook d " + 
				"WHERE d.studentid= "+ id + " AND d.assignmenttype= "+ type;
		TypedQuery<Gradebook> q= em.createQuery(qString, Gradebook.class);

		List<Gradebook> gradebooks;
		try
		{
			gradebooks = q.getResultList();
			if (gradebooks == null || gradebooks.isEmpty())
				gradebooks=null;
		} 
		finally
		{
			em.close();
		}
		return gradebooks;
	}

	public static List<Gradebook> selectAvg()
	{

		Scanner keyboard = new Scanner(System.in);

		System.out.print("Select assignmentype as:  'quiz' 'assignment'  'test'  'Project' ");
		String nw = keyboard.next();



		EntityManager em= DBUtil.getEmFactory().createEntityManager();
		String qString = "SELECT avg(grade) from Gradebook d " + 
				"WHERE d.assignmenttype= "+ nw;
		TypedQuery<Gradebook> q= em.createQuery(qString, Gradebook.class);

		List<Gradebook> gradebooks;
		try
		{
	
			gradebooks = q.getResultList();
			if (gradebooks == null || gradebooks.isEmpty())
				gradebooks=null;
		
		} 
		finally
		{
			em.close();
		}

		 return gradebooks;
	}

}

