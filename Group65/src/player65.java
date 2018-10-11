import org.vu.contest.*;
import java.util.Random;
import java.util.Properties;

/*
javac -cp .\contest.jar player65.java *.java
jar cmf MainClass.txt submission.jar player65.class *.class
jar uf contest.jar player65.class *.class
java -jar testrun.jar -submission=player65 -evaluation=BentCigarFunction -seed=1

SphereEvaluation  best result - 11.10.2018:
 - Score -  9.999944208243948
 - Population size -  90
 - Fittest size -  4
 - Recombination size -  70
 - Mutation size -  16
*/

public class player65 implements ContestSubmission
{
	Random rnd_;
	ContestEvaluation evaluation_;
    private int evaluations_limit_;
	
	public player65()
	{
		rnd_ = new Random();
	}
	
	public void setSeed(long seed)
	{
		// Set seed of algortihms random process
		rnd_.setSeed(seed);
	}

	public void setEvaluation(ContestEvaluation evaluation)
	{
		// Set evaluation problem used in the run
		evaluation_ = evaluation;
		
		// Get evaluation properties
		Properties props = evaluation.getProperties();
        // Get evaluation limit
        evaluations_limit_ = Integer.parseInt(props.getProperty("Evaluations"));
		// Property keys depend on specific evaluation
		// E.g. double param = Double.parseDouble(props.getProperty("property_name"));
        boolean isMultimodal = Boolean.parseBoolean(props.getProperty("Multimodal"));
        boolean hasStructure = Boolean.parseBoolean(props.getProperty("Regular"));
        boolean isSeparable = Boolean.parseBoolean(props.getProperty("Separable"));

		// Do sth with property values, e.g. specify relevant settings of your algorithm
        if(isMultimodal){
            // Do sth
        }else{
            // Do sth else
        }
    }
    
	public void run() {
		Evolution.startEvolutionaryAlgorithm(this.evaluation_, evaluations_limit_);
	}
}
