package com.pkoli.mojo;

import com.pkoli.reader.XlsToPojoReader;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Created by Pavan on 15-07-2017.
 */
@Mojo(name = "xls2pojo")
public class XlsToPojoMojo extends AbstractMojo {

    @Parameter(property = "fileName")
    private String fileName;

    public void execute() throws MojoExecutionException, MojoFailureException {
        XlsToPojoReader.read(fileName, getLog());
    }
}
