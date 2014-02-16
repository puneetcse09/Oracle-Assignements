package hudson;
import hudson.tasks.Builder;

import org.kohsuke.stapler.DataBoundConstructor;


public class HudsonBuilder extends Builder {

    private final String task;

    @DataBoundConstructor
    public HudsonBuilder(String task) {
        this.task = task;
    }

    public String getTask() {
    	   System.out.println("Customer Publish ");
    	}
    
    
    @Extension
    public static class Descriptor extends BuildStepDescriptor<Builder> {

        @Override
        public boolean isApplicable(Class<? extends AbstractProject> jobType) {
            return FreeStyleProject.class.isAssignableFrom(jobType);
        }

        @Override
        public String getDisplayName() {
            return "execute Hadson task";
        }
    }
    }