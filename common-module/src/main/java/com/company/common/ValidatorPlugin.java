package com.company.common;

import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Mojo(name = "validate-dependencies", defaultPhase = LifecyclePhase.VALIDATE, threadSafe = true)
public class ValidatorPlugin extends AbstractMojo {

    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException{
        // Define hardcoded dependencies for each module
        Map<String, List<String>> requiredDependenciesByModule = Map.of(
                "finance-module", List.of("junit"),
                "hr-module", List.of("mysql-connector-java"),
                "it-module", List.of("common-module")
        );

        // Get the current module artifactId
        String artifactId = project.getArtifactId();
        getLog().info("Validating dependencies for module: " + artifactId);

        // Get the required dependencies for the module
        List<String> requiredDependencies = requiredDependenciesByModule.get(artifactId);
        if (requiredDependencies == null) {
            getLog().info("No hardcoded dependencies defined for module: " + artifactId);
            return;
        }

        // Fetch the actual dependencies of the module

        List<String> actualDependencies = new ArrayList<>();
        for (Dependency dependency : project.getDependencies()) {
            actualDependencies.add(dependency.getArtifactId());
        }

        // Compare required and actual dependencies
        for (String requiredDependency : requiredDependencies) {
            if (actualDependencies.contains(requiredDependency)) {
                getLog().info("Dependency " + requiredDependency + " is present in module: " + artifactId);
            } else {
                getLog().warn("Missing required dependency: " + requiredDependency + " in module: " + artifactId);
            }
        }
    }
}

