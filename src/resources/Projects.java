package resources;

import java.util.Set;

import org.jgraph.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;

import saver_loader.DataResource;

import java.util.ArrayList;
import java.util.HashSet;


/**
 * Projects Class:
 * 
 * This class represents the Project object, which is associated with a User and contains Activities that are dependent on each other.
 * The Projects class holds and manipulates all the data used for Projects and their associated activities.
 * Projects have an id, projectName, ArrayList of users (userList), date, Connected Directed graph of Activities (activityGraph),
 * ArrayList of Activities, managerID, budget and description.
 * Activities are held in a DefaultDirectedGraph from the JGraphT library. Activities are vertices and DefaultEdges are edges.
 * The graph structure allows for dependencies among acitivities to be set by the edges.
 * The ArrayList of Activities works in parallel and allows for values of Activities to be changed (this may be refactored later on).
 * Projects hold a static projectCount variable which is automatically incremented and used to set id when new objects are created.
 * This static variable is set based on the highest project id stored in the database, and ensures that id is always unique.
 * Many of the methods in this class are used for iterating the graph, which is useful for future functionalities.
 * 
 * JGraphT Documentation: http://jgrapht.org/javadoc/
 * 
 * @author waffy
 *
 */

public class Projects {

	private static int projectCount = 0;
	private int id;
	private String projectName;
	private ArrayList<Users> userList;
	private String date;
	private DefaultDirectedGraph<Activities,DefaultEdge> activityGraph;
	private ArrayList<Activities> activityList;
	private int managerID;
	private double budget;
	private String description;

	
	/**
	 * Default Constructor.
	 * Sets all values to junk or null values.
	 */
	public Projects () {
		this.id = -1;
		this.projectName = null;
		this.userList = null;
		this.date = null;
		this.activityGraph = null;
		this.activityList = null;
		this.managerID = -1;
		this.budget = -1;
		this.description = null;
	}
	
	/**
	 * Parameterized constructor used for creating new Projects.
	 * The value for id is set to an automatically incrementing projectCount, which is initialized upon load from database.
	 * The Activity graph and list is initalized to an empty list, as no activities are associated yet.
	 * 
	 * @param projectName value for projectName
	 * @param userList value for userList
	 * @param date value for date
	 * @param managerID value for managerID
	 * @param description value for description
	 * @param budget value for budget
	 */
	public Projects(String projectName, ArrayList<Users> userList, String date, int managerID,
			String description, double budget) {
		this.id = ++projectCount;
		this.projectName = projectName;
		this.userList = userList;
		this.date = date;
		this.activityGraph = new DefaultDirectedGraph<Activities,DefaultEdge>(DefaultEdge.class);
		this.activityList = new ArrayList<Activities>();
		this.managerID = managerID;
		this.budget = budget;
		this.description = description;
	}

	/**
	 * Parameterized constructor for creating Projects from values in database.
	 * Not be used when creating NEW Projects, but rather for creating Projects existing in the database.
	 * Does not automatically set id attribute.
	 * Does not set the Activities graph or list. As such, all Activities must be added and all dependencies set.
	 * 
	 * @param projectName value for projectName
	 * @param userList value for userList
	 * @param date value for date
	 * @param projectID value for projectID
	 * @param managerID value for managerID
	 * @param description value for description
	 * @param budget value for budget
	 */
	public Projects(String projectName, ArrayList<Users> userList, String date, int projectID, int managerID,
			String description, double budget) {
		this.projectName = projectName;
		this.userList = userList;
		this.date = date;
		this.activityGraph = new DefaultDirectedGraph<Activities,DefaultEdge>(DefaultEdge.class);
		this.activityList = new ArrayList<Activities>();
		this.managerID = managerID;
		this.budget = budget;
		this.description = description;
		this.id = projectID;
	}
	
	/**
	 * Getter for userList
	 * @return ArrayList userList
	 */
	public ArrayList<Users> getUserList() {
		return userList;
	}

	/**
	 * Setter for userList
	 * @param userList value for userList
	 */
	public void setUserList(ArrayList<Users> userList) {
		this.userList = userList;
	}

	/**
	 * Getter for managerID
	 * @return int managerID
	 */
	public int getManagerID() {
		return managerID;
	}

	/**
	 * Setter for managerID
	 * @param managerID value for managerID
	 */
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	/**
	 * Getter for budget
	 * @return double budget
	 */
	public double getBudget() {
		return budget;
	}

	/**
	 * Setter for budget
	 * @param budget value for budget
	 */
	public void setBudget(double budget) {
		this.budget = budget;
	}

	/**
	 * Getter for description
	 * @return String description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter for description
	 * @param description value for description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Getter for projectCount
	 * @return int projectCount
	 */
	public static int getProjectCount() {
		return projectCount;
	}

	/**
	 * Setter for projectcount
	 * @param projectCount value for projectCount
	 */
	public static void setProjectCount(int projectCount) {
		Projects.projectCount = projectCount;
	}
	
	/**
	 * Getter for id
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for id
	 * @param id value for id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter for projectName
	 * @return String projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Setter for projectName
	 * @param projectName value for projectName
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Getter for date
	 * @return String date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Setter for date
	 * @param date value for date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Getter for activityGraph
	 * @return DefaultDirectedGraph activityGraph
	 */
	public DefaultDirectedGraph<Activities, DefaultEdge> getActivityGraph() {
		return activityGraph;
	}

	/**
	 * Setter for activityGraph
	 * @param activityGraph value activityGraph
	 */
	public void setActivityGraph(DefaultDirectedGraph<Activities, DefaultEdge> activityGraph) {
		this.activityGraph = activityGraph;
	}
	
	/**
	 * Getter for activityList
	 * @return the activityList
	 */
	public ArrayList<Activities> getActivityList() {
		return activityList;
	}

	/**
	 * Setter for activityList
	 * @param activityList the activityList to set
	 */
	public void setActivityList(ArrayList<Activities> activityList) {
		this.activityList = activityList;
	}

	/**
	 * Adds Activity in parameters to both the activityGraph and the activityList
	 * @param A Activity to add
	 */
	public void addActivity(Activities A) {
		this.activityGraph.addVertex(A);
		this.activityList.add(A);
	}
	
	/**
	 * Adds edge (dependency) between Activities in parameters.
	 * Given Activities A and B, addArrow(A, B) adds a dependency from A to B. Thus, B depends on A.
	 * @param A Origin Activity
	 * @param B Dependent Activity
	 */
	public void addArrow(Activities A, Activities B) {
		this.activityGraph.addEdge(A, B);
	}
	
	/**
	 * Returns a Set of Activities contained in this instance of the Project.
	 * @return Set of Activities currently contained in activityGraph
	 */
	public Set<Activities> getActivitySet() {
		return this.activityGraph.vertexSet();
	}
	
	/**
	 * Returns a Set of edges (DefaultEdge) contained in this instance of the Project.
	 * @return Set of DefaultEdge (dependencies) currently contained in activityGraph
	 */
	public Set<DefaultEdge> getArrowSet() {
		return this.activityGraph.edgeSet();
	}
	
	/**
	 * Returns a Set of incoming edges for the Activity given in parameters.
	 * Given Activity A, method returns a Set of all edges incoming to A. 
	 * In other words, the edges connecting A to all activities it depends on.
	 * @param A Activity for which we wish to get incoming edges
	 * @return Set of incoming edges to A
	 */
	public Set<DefaultEdge> getIncomingArrowsOfActivity(Activities A) {
		return this.activityGraph.incomingEdgesOf(A);
	}
	
	/**
	 * Returns a Set of outgoing edges for the Activity given in parameters.
	 * Given Activity A, method returns a Set of all edges outgoing from A. 
	 * In other words, the edges connecting A to all activities that depend on it.
	 * @param A Activity for which we wish to get outgoing edges
	 * @return Set of outgoing edges to A
	 */
	public Set<DefaultEdge> getOutgoingArrowsOfActivity(Activities A) {
		return this.activityGraph.outgoingEdgesOf(A);
	}
	
	/**
	 * Returns the Activity preceeding the edge passed in parameters.
	 * Given edge E, method returns the Activity for which E is an outgoing edge.
	 * @param e Edge for which we wish to get origin Activity
	 * @return Activity preceeding edge e
	 */
	public Activities getActivityBefore(DefaultEdge e) {
		return this.activityGraph.getEdgeSource(e);
	}
	
	/**
	 * Returns the Activity after the edge passed in parameters.
	 * Given edge E, method returns the Activity for which E is an incoming edge.
	 * @param e Edge for which we wish to get end Activity
	 * @return Activity after edge e
	 */
	public Activities getActivityAfter(DefaultEdge e) {
		return this.activityGraph.getEdgeTarget(e);
	}
	
	/**
	 * Given an Activity A, method returns an ArrayList of Activities that A depends on.
	 * @param A activity for which we wish to get Activities A depends on
	 * @return ArrayList of Activities that A depends on
	 */
	public ArrayList<Activities> getSetofDependencyActivities(Activities A) {
		Set<DefaultEdge> edgelist = this.getIncomingArrowsOfActivity(A);
		ArrayList<Activities> dependencies = new ArrayList<Activities>();
		for(DefaultEdge e : edgelist)
		{
			dependencies.add(this.getActivityBefore(e));
		}
		return dependencies;
	}
	
	/**
	 * Given Activity A, method returns an ArrayList of Activities that depend on A.
	 * @param A Activity for which we wish to get Activities that depend on A
	 * @return ArrayList of Activities that depend on A
	 */
	public ArrayList<Activities> getSetofActivitiesSucceeding(Activities A) {
		Set<DefaultEdge> edgelist = this.getOutgoingArrowsOfActivity(A);
		ArrayList<Activities> dependencies = new ArrayList<Activities>();
		for(DefaultEdge e : edgelist)
		{
			dependencies.add(this.getActivityAfter(e));
		}
		return dependencies;
	}
	
	/**
	 * Sets the earliestStart of the Activity in parameters to double passed in parameters.
	 * The Activity modified is in the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and make the modification.
	 * Not currently used in this iteration.
	 * @param A Activity to modify
	 * @param n value to set for earliestStart
	 */
	public void setES(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setEarliestStart(n);
		}
	}
	
	/**
	 * Gets the earliestStart of the Activity in parameters.
	 * The value is fetched from the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and return the value.
	 * Not currently used in this iteration. 
	 * @param A Activity who's value we wish to retrive
	 * @return double earliestStart of Activity A
	 */
	public double getES(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getEarliestStart();
		}
		return -1;
	}
	
	/**
	 * Sets the earliestFinish of the Activity in parameters to double passed in parameters.
	 * The Activity modified is in the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and make the modification.
	 * Not currently used in this iteration.
	 * @param A Activity to modify
	 * @param n value to set for earliestFinish
	 */
	public void setEF(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setEarliestFinish(n);
		}
	}
	
	/**
	 * Gets the earliestFinish of the Activity in parameters.
	 * The value is fetched from the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and return the value.
	 * Not currently used in this iteration. 
	 * @param A Activity who's value we wish to retrive
	 * @return double earliestFinish of Activity A
	 */
	public double getEF(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getEarliestFinish();
		}
		return -1;
	}
	
	/**
	 * Sets the latestStart of the Activity in parameters to double passed in parameters.
	 * The Activity modified is in the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and make the modification.
	 * Not currently used in this iteration.
	 * @param A Activity to modify
	 * @param n value to set for lastestStart
	 */
	public void setLS(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setLatestStart(n);
		}
	}
	
	/**
	 * Gets the latestStart of the Activity in parameters.
	 * The value is fetched from the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and return the value.
	 * Not currently used in this iteration. 
	 * @param A Activity who's value we wish to retrive
	 * @return double latestStart of Activity A
	 */
	public double getLS(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getLatestStart();
		}
		return -1;
	}
	
	/**
	 * Sets the latestFinish of the Activity in parameters to double passed in parameters.
	 * The Activity modified is in the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and make the modification.
	 * Not currently used in this iteration.
	 * @param A Activity to modify
	 * @param n value to set for latestFinish
	 */
	public void setLF(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setLatestFinish(n);
		}
	}
	
	/**
	 * Gets the latestFinish of the Activity in parameters.
	 * The value is fetched from the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and return the value.
	 * Not currently used in this iteration. 
	 * @param A Activity who's value we wish to retrive
	 * @return double latestFinish of Activity A
	 */
	public double getLF(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getLatestFinish();
		}
		return -1;
	}
	
	/**
	 * Sets the activityFloat of the Activity in parameters to double passed in parameters.
	 * The Activity modified is in the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and make the modification.
	 * Not currently used in this iteration.
	 * @param A Activity to modify
	 * @param n value to set for activityFloat
	 */
	public void setFloat(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setActivityFloat(n);
		}
	}
	
	/**
	 * Gets the activityFloat of the Activity in parameters.
	 * The value is fetched from the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and return the value.
	 * Not currently used in this iteration. 
	 * @param A Activity who's value we wish to retrive
	 * @return double activityFloat of Activity A
	 */
	public double getFloat(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getActivityFloat();
		}
		return -1;
	}
	
	/**
	 * Sets the maxDuration of the Activity in parameters to double passed in parameters.
	 * The Activity modified is in the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and make the modification.
	 * Not currently used in this iteration.
	 * @param A Activity to modify
	 * @param n value to set for maxDuration
	 */
	public void setMaxDuration(Activities A, double n) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				a.setMaxDuration(n);
		}
	}
	
	/**
	 * Gets the maxDuration of the Activity in parameters.
	 * The value is fetched from the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and return the value.
	 * Not currently used in this iteration. 
	 * @param A Activity who's value we wish to retrive
	 * @return double maxDuration of Activity A
	 */
	public double getMaxDuration(Activities A) {
		for(Activities a : this.activityList)
		{
			if (a.getId() == A.getId())
				return a.getMaxDuration();
		}
		return -1;
	}
	
	/**
	 * Gets an Activity from the activityList that has label equal to the String passed in parameters.
	 * The value is fetched from the activityList.
	 * The method will look for the Activity in activityList corresponding to Activity A passed in parameters, and return the value.
	 * @param l String label we wish to find in Activities
	 * @return Activity with label l
	 */
	public Activities getActivityByLabel(String l){
		for(Activities a : this.activityList)
		{
			if (a.getLabel().equals(l))
				return a;
		}
		return null;
	}
	
	/**
	 * Deletes an Activity from the Project.
	 * Activity A is deleted from the activityGraph and activityList, as well as the database.
	 * All incoming and outgoing edges from A are also removed from the graph and database.
	 * @param A Activity we wish to delete from project
	 */
	public void deleteActivity(Activities A) {
		this.activityGraph.removeVertex(A);
		this.activityList.remove(A);
		DataResource.deleteActivity(A);
	}
	
	/**
	 * Removes all incoming edges from Activity passed in parameters.
	 * All incoming edges from Activity A are removed from the activityGraph, as well as the database.
	 * @param A Activity who's incoming edges we wish to remove
	 */
	public void resetIncomingEdges(Activities A) {
		Set<DefaultEdge> incomingEdges = this.getIncomingArrowsOfActivity(A);
		Set<DefaultEdge> tempSet = new HashSet<DefaultEdge>(incomingEdges);
		for(DefaultEdge e : incomingEdges)
		{
			Activities beforeEdge = this.getActivityBefore(e);
			Activities afterEdge = this.getActivityAfter(e);
			DataResource.deleteEdgeFromDB(beforeEdge.getId(), afterEdge.getId());
		}
		for(DefaultEdge e : tempSet)
		{
			this.activityGraph.removeEdge(e);
		}
		
	}
	
	/**
	 * This method is to be used in future iterations to calculate and set the approriate variables for each Activity.
	 * Currently calculates earliestStart and earliestFinish for all Activities in the project by doing a forward pass.
	 */
	public void calculateTimes() {
		Set<Activities> vertexList = getActivitySet();
		//Set<DefaultEdge> edgeList = getArrowSet();		
		
		// forward pass
		for (Activities i : vertexList)
		{
			// check if activity is a "first level" activity, no incoming edges
			if (this.activityGraph.inDegreeOf(i) == 0)
			{
				setES(i, 0);
				setEF(i, i.getDuration());	
			}
			else
			{
				Set<DefaultEdge> inEdges = getIncomingArrowsOfActivity(i);
				double highestEF = 0;
				for (DefaultEdge e : inEdges)
				{
					if (getActivityBefore(e).getEarliestFinish() >= highestEF)
						highestEF = getActivityBefore(e).getEarliestFinish();
				}
				setES(i, highestEF);
				setEF(i, highestEF + i.getDuration());
			}
			
		}
		
		// backward pass
		
		// float
		
		// critial path
		
		// max duration
		
	}
	
	
	
}