package com.github.pkoli.mojo;

import com.github.pkoli.reader.XlsReader;
import com.github.pkoli.util.FileLister;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

import java.io.File;

/**
 * Created by Pavan on 15-07-2017.
 */
@Mojo(name = "xls2pojo", defaultPhase = LifecyclePhase.GENERATE_SOURCES,
        requiresDependencyResolution = ResolutionScope.COMPILE)
public class XlsToPojoMojo extends AbstractMojo {
    @Parameter(property = "fileName", required = true)
    private String fileName;

    @Parameter(defaultValue = "${project.build.directory}/generated-sources/xls2pojo/",
            required = false)
    private File outputDirectory;

    public void execute() throws MojoExecutionException, MojoFailureException {
        XlsReader.readAndWrite(fileName, outputDirectory);
        FileLister.listAllCreatedFiles(outputDirectory, getLog());
    }
}
